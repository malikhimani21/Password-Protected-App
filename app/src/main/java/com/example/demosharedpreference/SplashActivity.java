package com.example.demosharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static final String PREFS_KEY = "myPrefernces";
    private static final String PASSWORD_KEY = "myPrefernces";
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        password = sharedPreferences.getString(PASSWORD_KEY, "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (password.equals("")) {
                    Intent intent = new Intent(SplashActivity.this, CreatePasswordActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, EnterPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);
    }
}
