package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedpreferences.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    private SharedPreferences.Editor editor;
    private CheckBox savelogincheckbox;


    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        savelogincheckbox=findViewById(R.id.checkBox);
        Button login = findViewById(R.id.button);

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.KEY_LOGIN, MODE_PRIVATE);

       editor= sharedPreferences.edit();
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               login();

           }
       });

        boolean saveLogin = sharedPreferences.getBoolean(Constants.KEY_SAVE_LOGIN, false);
       if(saveLogin){
           username.setText(sharedPreferences.getString(Constants.KEY_USERNAME,null));
           password.setText(sharedPreferences.getString(Constants.KEY_PASSWORD,null));
       }

    }

    public  void login(){
        String user=username.getText().toString();
        String pass=password.getText().toString();

        if(user.equals("NetSolutions")&& pass.equals("NetSolutions")) {
            Toast.makeText(this, "username and password matched", Toast.LENGTH_SHORT).show();
            if(savelogincheckbox.isChecked()){

                editor.putBoolean(Constants.KEY_SAVE_LOGIN,true);
                editor.putString(Constants.KEY_USERNAME,user);
                editor.putString(Constants.KEY_PASSWORD,pass);
                editor.commit();
            }
            Intent intent=new Intent(getApplicationContext(),NextActivity.class);
            startActivity(intent);


        }
        else
            {

            Toast.makeText(this, "username and password are not matched", Toast.LENGTH_SHORT).show();

            }
    }

    }

