package com.vba.gearvrdisabler;

import android.content.Intent;
import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        AdView mAdView = (AdView) findViewById(R.id.about_adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("32AD31E5208FECC334D4FA0D7D1B6CAD")
                .addTestDevice("DE464F2336490373C94A1C6ECE1FBBAE")
                .addTestDevice("1BB6E2B19973F7E94FB3B250694057D3")
                .build();
        mAdView.loadAd(adRequest);

        final Button donateButton = (Button) findViewById(R.id.about_donate_button);
        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donate();
            }
        });
    }

    private void donate() {

        Intent donate = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=T9M6ELFAU7RFL&lc=US&item_name=GearVR%20Disabler&item_number=GearDonations&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted"));
        startActivity(donate);
    }
}
