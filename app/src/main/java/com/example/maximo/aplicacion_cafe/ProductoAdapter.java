package com.example.maximo.aplicacion_cafe;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Carlos Ignacio on 05-12-2016.
 */

public class ProductoAdapter extends ArrayAdapter<Producto>{
    Context context;
    int layoutResourceId;
    Producto data[] = null;

    public ProductoAdapter(Context context, int layoutResourceId, Producto[] data) {
        super(context, layoutResourceId, data);
        Log.e("productAdapter", "Entro");
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }



    public View getView (int position, View convertView, ViewGroup parent){
        View row = convertView;
        ProductoHolder holder = null;
        Log.e("getView", "entro");
        if(row == null){
            LayoutInflater inflater = ((FragmentActivity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            Log.e("null", "entro");
            holder = new ProductoHolder();
            holder.textViewNombre = (TextView) row.findViewById(R.id.nombreListObject);
            holder.getTextViewPrecio = (TextView) row.findViewById(R.id.precioListObject);
            row.setTag(holder);
        }else{
            holder = (ProductoHolder)row.getTag();
            Log.e("distinto null", "entro");
        }

        Producto producto = data[position];
        holder.textViewNombre.setText(producto.getNombre());
        holder.getTextViewPrecio.setText(producto.getPrecio());

        return row;
    }

    static class ProductoHolder{
        TextView textViewNombre, getTextViewPrecio;
        Button button;

    }


}
