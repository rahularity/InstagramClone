package com.geekyvisuals.rahularity.instagramclone.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.geekyvisuals.rahularity.instagramclone.R;
import com.geekyvisuals.rahularity.instagramclone.utils.BottomNavigationViewHelper;
import com.geekyvisuals.rahularity.instagramclone.utils.SectionsPagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final int ACTIVITY_NUM = 0;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: starting.");

        setupBottomNavigationView();
        setUpViewPager();
    }

    /**
     * Setting up ViewPager to the camera, home, messages fragments
     */
    private void setUpViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new CameraFragment()); //index 0
        adapter.addFragments(new HomeFragment()); //index 1
        adapter.addFragments(new MessagesFragment()); //index 2

        ViewPager viewPager = (ViewPager)findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabs.getTabAt(1).setIcon(R.drawable.ic_home);
        tabs.getTabAt(2).setIcon(R.drawable.ic_messages);

    }



    /**
     *BottomNavigationView setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(context,bottomNavigationViewEx);

        //getting menu item so as to highlight the correct BottomNavigationItem
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
