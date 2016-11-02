package com.example.maximo.aplicacion_cafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LLama a LoginActivity
        Intent login_Activity = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(login_Activity);

        //Llama a help_activity
        Intent help_Activiy = new Intent(getApplicationContext(), HelpActivity.class);
        startActivity(help_Activiy);


    }
}
