package com.example.maximo.aplicacion_cafe;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Ignacio on 05-12-2016.
 */

public class ApplicationController {

    List<Producto> listaCarroCompra = new ArrayList<>();

    public void AgregarCarroCompra(Producto lista){
        listaCarroCompra.add((Producto) lista);
        Log.e("Pruea", listaCarroCompra.get(listaCarroCompra.size()-1).getNombre());
    }


}
