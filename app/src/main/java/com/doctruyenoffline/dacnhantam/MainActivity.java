package com.doctruyenoffline.dacnhantam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.mjebooksdk.Config;
import com.mjebooksdk.MjEbookReader;
import com.mjebooksdk.util.AppUtil;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    private MjEbookReader mjEbookReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        mjEbookReader = MjEbookReader.get();

        Config config = AppUtil.getSavedConfig(getApplicationContext());
        if (config == null){
            config = new Config();
        }
        config.setAllowedDirection(Config.AllowedDirection.ONLY_VERTICAL);

        mjEbookReader.setConfig(config, true)
                .setShowLastLocation(true)
                .setInterAdsId("ca-app-pub-4586982117024368/3919054473")
                .setBannerAdsId("ca-app-pub-4586982117024368/6860078439")
                .setShowInterAdsAfter(3)
                .setDeveloperId("morejump")
                .setFileNameEpub("dacnhantam")
                .openBook();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MjEbookReader.clear();
    }
}
