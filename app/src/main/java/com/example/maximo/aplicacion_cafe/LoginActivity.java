package com.example.maximo.aplicacion_cafe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maximo.aplicacion_cafe.activity.admin.HelpActivity;
import com.example.maximo.aplicacion_cafe.activity.user.HelpActivityUser;

public class LoginActivity extends AppCompatActivity{

    EditText textCorreo, textPass;
    Button botonLogin;
    SharedPreferences.Editor editor;
    String tipoSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editor = getSharedPreferences("Datos", MODE_PRIVATE).edit();

        textCorreo = (EditText) findViewById(R.id.txtCorreo);
        textPass = (EditText) findViewById(R.id.txtPass);
        botonLogin = (Button) findViewById(R.id.btnLogin);
    }

    public void btonLogin(View v) {
        String txtCorreo = textCorreo.getText().toString();
        String txtPass = textPass.getText().toString();

        if (txtCorreo.equals("admin") && txtPass.equals("admin")) {
            tipoSesion = "admin";
            editor.putString("tipoSesion", tipoSesion);
            editor.commit();
            startActivity(new Intent(getApplicationContext(), HelpActivity.class));
        } else if (txtCorreo.equals("user") && txtPass.equals("user")){
            tipoSesion = "user";
            editor.putString("tipoSesion", tipoSesion);
            editor.commit();
            startActivity(new Intent(getApplicationContext(), HelpActivityUser.class));
        }
        else
            Toast.makeText(getApplicationContext(), "Usuario Inválido", Toast.LENGTH_SHORT).show();
    }


}
