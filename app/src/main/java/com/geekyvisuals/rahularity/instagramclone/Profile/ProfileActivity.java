package com.geekyvisuals.rahularity.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.geekyvisuals.rahularity.instagramclone.AccountSettings;
import com.geekyvisuals.rahularity.instagramclone.R;
import com.geekyvisuals.rahularity.instagramclone.utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.zip.Inflater;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    public static final int ACTIVITY_NUM = 4;
    private Context context = ProfileActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: starting.");

        setupBottomNavigationView();
        setupToolbar();
    }

    /**
     * setting up the toolbar for the profile activity
     */
    public void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView)findViewById(R.id.profile_menu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Navigating to Account Setting");
                startActivity(new Intent(ProfileActivity.this, AccountSettings.class));
            }
        });

//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Log.d(TAG, "onMenuItemClick: inside menu option when clicked");
//
//                if(item.getItemId() == R.id.profileMenu){
//                    Log.d(TAG, "onMenuItemClick: navigating to profile page/activity");
//                }
//
//                return false;
//            }
//        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     //   getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }
}
