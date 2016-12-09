package com.example.maximo.aplicacion_cafe;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Carlos Ignacio on 28-11-2016.
 */

public class JsonTask extends AsyncTask<String, String, String> {
    private CartaFragment parent;

    public JsonTask(CartaFragment main) {

        this.parent = main;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        parent.pd = new ProgressDialog(parent.getContext());
        parent.pd.setMessage("Please wait");
        parent.pd.setCancelable(false);
        parent.pd.show();
    }

    protected String doInBackground(String... params) {
        int timeout = 10000;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-length", "0");
            connection.setUseCaches(false);
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setAllowUserInteraction(false);
            Log.d("parametros: ", params[0]);

            connection.connect();

            int status = connection.getResponseCode();
            switch (status){
                case 200:
                    Log.d("Soy un 201", "lo que quieras x2");
                    InputStream stream = connection.getInputStream();
                    //Se entrega formato a la respuesta.
                    reader = new BufferedReader(new InputStreamReader(stream));
                    StringBuffer buffer = new StringBuffer();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line+"\n");
                    }
                    reader.close();
                    return buffer.toString();
                case 404:
                    Log.d("Soy un error", "404");
            }
        } catch (MalformedURLException |NullPointerException e) {
            Log.d("Errores", e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (parent.pd.isShowing()){
            parent.pd.dismiss();
        }
        if(result== null) {
            //parent.recibir(result);
            //Mostrar una list view
               /* View myView = (View) R.layout.row;
                TextView id = (TextView) myView.findViewById(R.id.id);
                id.setText("1");

                listProducts.addView(myView);
                */

            //txtJson.setText(result);
            result = "Error al conectar";
            //Toast.makeText(MainActivity.this, "Error al conectar", Toast.LENGTH_SHORT).show();
        }
        try {
            parent.recibir(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
