package com.example.maximo.aplicacion_cafe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogOutActivity extends AppCompatActivity {

    private Button btnLogOut;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null){
                    startActivity(new Intent(LogOutActivity.this, LoginActivity.class));
                    Toast.makeText(LogOutActivity.this, "LogOut", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        };

        btnLogOut = (Button)findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mAuth.signOut();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }
}
