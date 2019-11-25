package com.example.demosharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private static final String PREFS_KEY = "myPrefernces";
    private static final String PASSWORD_KEY = "myPrefernces";
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        password = sharedPreferences.getString(PASSWORD_KEY, "");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if(text.equals(password)){
                    Intent intent = new Intent(EnterPasswordActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(EnterPasswordActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
