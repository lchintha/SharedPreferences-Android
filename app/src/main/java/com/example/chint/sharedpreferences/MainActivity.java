package com.example.chint.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname1;
    EditText psw1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname1 = (EditText)findViewById(R.id.uname);
        psw1 = (EditText)findViewById(R.id.psw);
    }
    public void saveInfo(View v){
        SharedPreferences sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("uname",uname1.getText().toString());
        editor.putString("psw",psw1.getText().toString());
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }
    public void displayInfo(View v){
        SharedPreferences sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String uname = sp.getString("uname","");
        String psw = sp.getString("psw","");
        uname1.setText(uname);
        psw1.setText(psw);
    }
}

