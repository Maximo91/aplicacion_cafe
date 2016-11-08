package com.example.maximo.aplicacion_cafe.activity.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.maximo.aplicacion_cafe.LoginActivity;
import com.example.maximo.aplicacion_cafe.R;
import com.example.maximo.aplicacion_cafe.activity.admin.HelpActivity;

public class MenuPrincipalUser extends AppCompatActivity {

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_user);
        editor = getSharedPreferences("Datos", MODE_PRIVATE).edit();
    }


    public void btonCerrarSesionUser(View v) {
        editor.putString("tipoSesion", "");
        editor.commit();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }


    @Override
    public void onBackPressed() {}
}
