package com.example.stolovapadangorderfood;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stolovapadangorderfood.Buyers.HomeActivity;
import com.example.stolovapadangorderfood.Helpers.DataHelper;

public class SplashScreenActivity extends AppCompatActivity {
    private int waktu_loading = 2000;
    DataHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        dataHelper = new DataHelper(SplashScreenActivity.this);

//        if (dataHelper.isLoggedIn()) {
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
//                }
//            }, waktu_loading);
//        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                }
            }, waktu_loading);
//        }

    }
}
