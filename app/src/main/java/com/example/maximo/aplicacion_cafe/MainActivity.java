package com.example.maximo.aplicacion_cafe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.maximo.aplicacion_cafe.activity.admin.MenuPrincipal;
import com.example.maximo.aplicacion_cafe.activity.user.MenuPrincipalUser;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView texto;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 2;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            texto.setText(progressStatus + "% / 100%");
                        }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                SharedPreferences prefs = getSharedPreferences("Datos", MODE_PRIVATE);
                String tipoSesion = prefs.getString("tipoSesion", "");

                if (tipoSesion.equals("admin")) {
                    startActivity(new Intent(getApplicationContext(), MenuPrincipal.class));
                } else if (tipoSesion.equals("user")) {
                    startActivity(new Intent(getApplicationContext(), MenuPrincipalUser.class));
                } else
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        }).start();


    }
}
