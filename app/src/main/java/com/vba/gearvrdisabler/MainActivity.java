package com.vba.gearvrdisabler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
                .addTestDevice("1BB6E2B19973F7E94FB3B250694057D3")
                .build();
        mAdView.loadAd(adRequest);

        mIntertitialAd = new InterstitialAd(this);
        mIntertitialAd.setAdUnitId("ca-app-pub-3212958863845087/9172352057");
        AdRequest adRequest1 = new AdRequest.Builder()
                .addTestDevice("32AD31E5208FECC334D4FA0D7D1B6CAD")
                .addTestDevice("DE464F2336490373C94A1C6ECE1FBBAE")
                .addTestDevice("1BB6E2B19973F7E94FB3B250694057D3")
                .build();
        mIntertitialAd.loadAd(adRequest1);

        checkFirstRun();


    }

    private void firstRunDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.first_run_dialog_title);
        builder.setMessage(R.string.first_run_dialog_content);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.dialog_continue, null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void uninstallDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.uninstall_dialog_titlle);
        builder.setMessage(R.string.uninstall_dialog_content);
        builder.setCancelable(true);
        builder.setNegativeButton(R.string.dialog_cancel, null);
        builder.setPositiveButton(R.string.dialog_continue, null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun) {
            //action
            firstRunDialog();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
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

        if (id == R.id.action_remove_ads) {
            return true;
        }

        if (id == R.id.action_report_bug) {
            return true;
        }

        if (id == R.id.action_uninstall) {
            uninstallDialog();
        }

        return super.onOptionsItemSelected(item);
    }
}
