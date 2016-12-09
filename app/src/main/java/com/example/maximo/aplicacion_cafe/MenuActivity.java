package com.example.maximo.aplicacion_cafe;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private ClipData.Item btnLogOut;

    //JSon
    TextView txtJson;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Fragment
        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentMain, new MainFragment()).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuActivity.this, "Carro de Compra", Toast.LENGTH_SHORT).show();
                fragmentManager.beginTransaction().replace(R.id.fragmentMain, new CarroCompraFragment()).commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fragmentManager = getSupportFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_hisPedidos) {
            Toast.makeText(this, "historial", Toast.LENGTH_SHORT).show();
            fragmentManager.beginTransaction().replace(R.id.fragmentMain, new HistorialPedidosFragment()).commit();

        } else if (id == R.id.nav_carroDeCompra) {
            Toast.makeText(this, "Carro de Compra", Toast.LENGTH_SHORT).show();
            fragmentManager.beginTransaction().replace(R.id.fragmentMain, new CarroCompraFragment()).commit();

        } else if (id == R.id.nav_carta) {

            Toast.makeText(this, "Carta", Toast.LENGTH_SHORT).show();

            //JsonTask jt = new JsonTask(MenuActivity.this);
            //jt.execute("http://cafeteria-app.herokuapp.com/api/productos");
            fragmentManager.beginTransaction().replace(R.id.fragmentMain, new CartaFragment()).commit();
        } else if (id == R.id.nav_combo) {
            Toast.makeText(this, "Combo", Toast.LENGTH_SHORT).show();
            fragmentManager.beginTransaction().replace(R.id.fragmentMain, new ComboFragment()).commit();

        } else if (id == R.id.nav_LogOut){
            mAuth = FirebaseAuth.getInstance();
            mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    if (firebaseAuth.getCurrentUser() == null){
                        startActivity(new Intent(MenuActivity.this, LoginActivity.class));
                        Toast.makeText(MenuActivity.this, "Sesión Finalizada", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            };
            mAuth.signOut();
            //super.onStart();
            mAuth.addAuthStateListener(mAuthStateListener);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /*
    public void recibir (String str) throws JSONException {
        Log.e("Respuesta", str);
        List<Producto> listaProducto = new ArrayList<>();
        JSONObject object = new JSONObject(str);
        JSONArray jsonArray = object.optJSONArray("producto");

        for (int i = 0; i < jsonArray.length(); i++){
            listaProducto.add(new Producto(jsonArray.getJSONObject(i)));
        }

        for (Producto product : listaProducto){
            Log.e("prueba", product.getNombre());
        }
    }
    */
}
