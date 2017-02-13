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
        editor.putString("UserName", uName.getText().toString());
        editor.putString("Password", pwd.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }

    public void getData(View view){
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = loginData.getString("UserName", "");
        String pw = loginData.getString("Password","");
        String msg = "Saved User Name: " + name + "\nSaved Password: " + pw;
        dView.setText(msg);
    }
}
