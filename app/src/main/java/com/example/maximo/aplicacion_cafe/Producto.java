package com.example.maximo.aplicacion_cafe;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Carlos Ignacio on 03-12-2016.
 */

public class Producto {

    private String id;
    private String nombre;
    private int cantidad;
    private int precio;
    private String categoria;
    private String estado;
    private String horaInicio;
    private String horaFin;
    private String imagenURL;
    private String _v;

    public Producto(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getString("_id");
        nombre = jsonObject.getString("nombre");
        cantidad = jsonObject.getInt("cantidad");
        precio = jsonObject.getInt("precio");
        categoria = jsonObject.getString("categoria");
        estado = jsonObject.getString("estado");
        horaInicio = jsonObject.getString("hora_inicio");
        horaFin = jsonObject.getString("hora_fin");
        imagenURL = jsonObject.getString("imagen");
        _v = jsonObject.getString("__v");
    }

    public Producto(){
        super();
    }

    public Producto(String nombre, int precio) {
        super();
        this.nombre = nombre;
        this.precio = precio;
    }


    public String getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public String get_v() {
        return _v;
    }

    public String getNombre() {
        return nombre;
    }

}
