package com.example.naval.hw3_basicstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class saveSettings extends AppCompatActivity {

    EditText uName;
    EditText pwd;
    TextView dView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_settings);

        uName = (EditText) findViewById(R.id.userNameInput);
        pwd = (EditText) findViewById(R.id.passwordInput);
        dView = (TextView) findViewById(R.id.dataTextView);
    }
    public void saveData(View view){
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginData.edit();
        editor.putString("Noti_freq", uName.getText().toString());
        editor.putString("API_freq", pwd.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }

    public void getData(View view){
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = loginData.getString("Noti_freq", "");
        String pw = loginData.getString("API_freq","");
        String msg = "Saved Notification Frequency: " + name + "\nSaved API Call Frequency: " + pw;
        dView.setText(msg);
    }
}
