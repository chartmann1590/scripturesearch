package com.charles.bible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AboutActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        // Amazon Appstore build: no outside-payment (donation) link (Amazon monetization policy)
        if ("amazon".equals(BuildConfig.STORE)) {
            View dev = findViewById(R.id.button_about_dev);
            if (dev != null) dev.setVisibility(View.GONE);
        }
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void AboutButton(View view) {

        String url = "https://www.buymeacoffee.com/charleshartmann";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }

    public void CloseButton(View view) {

        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();

    }
}