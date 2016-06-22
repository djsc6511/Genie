package org.androidtown.genie;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class Totalcontent extends TabActivity {
    private TabHost mTabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setContent(R.id.tab1).setIndicator("Tab1"));
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setContent(R.id.tab1).setIndicator("Tab2"));
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setContent(R.id.tab1).setIndicator("Tab3"));
    }

    public void onClickedreqbutton(View v){
        Intent intent = new Intent(getApplicationContext(),Writing.class);
        startActivity(intent);
    }

    public void onClickedSetting(View v){
        Intent intent = new Intent(getApplicationContext(),Setting.class);
        startActivity(intent);
    }
}
