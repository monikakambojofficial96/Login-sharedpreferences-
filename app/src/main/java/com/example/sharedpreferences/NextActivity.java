package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import com.example.sharedpreferences.utils.Constants;

public class NextActivity extends AppCompatActivity {


    protected TextView userName,password;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPreferences = getSharedPreferences(Constants.KEY_LOGIN, MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        userName=findViewById(R.id.usernamevalue);
        password=findViewById(R.id.passwordvalue);

        userName.setText(sharedPreferences.getString(Constants.KEY_USERNAME,""));
        password.setText(sharedPreferences.getString(Constants.KEY_PASSWORD,""));

    }
}
