package com.geekyvisuals.rahularity.instagramclone;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.geekyvisuals.rahularity.instagramclone.Profile.EditProfileFragment;
import com.geekyvisuals.rahularity.instagramclone.Profile.ProfileActivity;
import com.geekyvisuals.rahularity.instagramclone.Profile.SignOutFragment;
import com.geekyvisuals.rahularity.instagramclone.utils.SectionStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettings extends AppCompatActivity {

    private static final String TAG = "AccountsSettings";
    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        Log.d(TAG, "onCreate: oncreate started");

        viewPager = (ViewPager)findViewById(R.id.container);
        mRelativeLayout = (RelativeLayout)findViewById(R.id.relLayoutAccountSettingPage);



        setupToolbar();
        setupSettingsList();
        setupFragments();
    }

    public void setupToolbar(){
        Log.d(TAG, "setupToolbar: setting up toolbar in AccountsSetting Activity");
        Toolbar toolbar = (Toolbar)findViewById(R.id.accountSettingToolbar);
        setSupportActionBar(toolbar);

        ImageView backButton = (ImageView)findViewById(R.id.backArrow);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountSettings.this, ProfileActivity.class));
                finish();
            }
        });
    }


    public void setupSettingsList(){
        Log.d(TAG, "setupSettingsList: setting up settings list");
        ListView listView = (ListView)findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile)); //fragment 0
        options.add(getString(R.string.log_out)); //fragment 1

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: on item click navigating to fragment " + i);
                setupViewPager(i);
            }
        });
    }

    public void setupFragments(){
        pagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.log_out));
    }

    void setupViewPager(Integer fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setupViewPager: navigating to fragment #:" + fragmentNumber);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }
}
