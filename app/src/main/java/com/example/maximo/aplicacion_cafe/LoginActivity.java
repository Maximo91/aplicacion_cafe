package com.example.maximo.aplicacion_cafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements OnClickListener{

    EditText textCorreo, textPass;
    Button botonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textCorreo = (EditText) findViewById(R.id.txtCorreo);
        textPass = (EditText) findViewById(R.id.txtPass);
        botonLogin = (Button) findViewById(R.id.btnLogin);
        botonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String txtCorreo = textCorreo.getText().toString();
        String txtPass = textPass.getText().toString();
        if (txtCorreo.equals("admin") && txtPass.equals("admin")) {
            startActivity(new Intent(getApplicationContext(), HelpActivity.class));
            } else
                Toast.makeText(getApplicationContext(), "Usuario Inválido", Toast.LENGTH_SHORT).show();
    }
}
