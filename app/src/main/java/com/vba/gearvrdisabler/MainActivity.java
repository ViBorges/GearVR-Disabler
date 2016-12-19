package com.vba.gearvrdisabler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mIntertitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdView mAdView = (AdView) findViewById(R.id.main_adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("32AD31E5208FECC334D4FA0D7D1B6CAD")
                .addTestDevice("DE464F2336490373C94A1C6ECE1FBBAE")
                .build();
        mAdView.loadAd(adRequest);

        mIntertitialAd = new InterstitialAd(this);
        mIntertitialAd.setAdUnitId("ca-app-pub-3212958863845087/9172352057");
        AdRequest adRequest1 = new AdRequest.Builder()
                .addTestDevice("32AD31E5208FECC334D4FA0D7D1B6CAD")
                .addTestDevice("DE464F2336490373C94A1C6ECE1FBBAE")
                .build();
        mIntertitialAd.loadAd(adRequest1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            if (mIntertitialAd.isLoaded()) {
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                mIntertitialAd.show();
            } else {
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
