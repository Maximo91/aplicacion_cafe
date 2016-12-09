package com.example.maximo.aplicacion_cafe;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CartaFragment extends Fragment {
    ProgressDialog pd;
    public CartaFragment() {
        // Required empty public constructor
    }
    List<Producto> listaProducto = new ArrayList<>();
    //Listo
    ListView listView;
    LayoutInflater layoutInflater;
    ViewGroup containerG;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutInflater = inflater;
        containerG = container;
        View rootView = inflater.inflate(R.layout.fragment_carta, container, false);
        listView = (ListView) rootView.findViewById(R.id.ListViewCarta);

        JsonTask jT = new JsonTask(CartaFragment.this);
        jT.execute("http://cafeteria-app.herokuapp.com/api/productos");
        //Log.e("Prueba desde oncrearte", listaProducto.get(0).getNombre());
        //String[] st = new String[] {"fsadfsd","fdsfadf"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item , st);
        //listView.setAdapter(adapter);

        return rootView;
    }

    public void recibir (String str) throws JSONException {

        final ApplicationController controller = new ApplicationController();

        //Accede al Json y agrega valores a listaProducto
        JSONObject object = new JSONObject(str);
        JSONArray jsonArray = object.optJSONArray("producto");

        for (int i = 0; i < jsonArray.length(); i++){
            listaProducto.add(new Producto(jsonArray.getJSONObject(i)));
        }


        String[] st = new String[listaProducto.size()];


        int j = 0;
        Producto produc_data[] = new Producto[listaProducto.size()];
        for (Producto products : listaProducto){
            produc_data[j] = new Producto(products.getNombre(), products.getPrecio());
            j++;
        }



        View rootView = layoutInflater.inflate(R.layout.fragment_carta, containerG, false);
        ProductoAdapter productoAdapter = new ProductoAdapter(getContext(), R.layout.row_layout, produc_data);
        listView = (ListView) rootView.findViewById(R.id.ListViewCarta);
        View header = (View) getActivity().getLayoutInflater().inflate(R.layout.header_layout, null);
        listView.addHeaderView(header);
        listView.setAdapter(productoAdapter);

        /*
        int i = 0;
        for (Producto product : listaProducto){
            Log.e("prueba", product.getNombre());
            st[i] = product.getNombre();
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                R.layout.support_simple_spinner_dropdown_item , st);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext().getApplicationContext(), "fsda"+position, Toast.LENGTH_SHORT).show();
                controller.AgregarCarroCompra(listaProducto.get(position));
            }
        });
        */
    }



}
