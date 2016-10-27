package com.example.maximo.aplicacion_cafe;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vlonjatg.android.apptourlibrary.AppTour;
import com.vlonjatg.android.apptourlibrary.MaterialSlide;

public class HelpActivity extends AppTour {

    @Override
    public void init(Bundle saveInstanceState){

        int firstColor = Color.parseColor("#0097A7");
        int secondColor = Color.parseColor("#FFA000");
        int customSlideColor = Color.parseColor("#009866");

        Fragment firstSlide = MaterialSlide.newInstance(R.drawable.cafe_logo, "Presentacion del cafe", "no sé que sigue acá", Color.WHITE, Color.WHITE);

        Fragment seoondtSlide = MaterialSlide.newInstance(R.drawable.cafe_logo, "fdsfsadfadsfel cafe", "no sé que sigue acá fdsafsdafasd", Color.WHITE, Color.WHITE);

        addSlide(firstSlide,firstColor);
        addSlide(seoondtSlide, secondColor);

        //addSlide(new CustomSlide(), customSlideColor);

        setSkipButtonTextColor(Color.WHITE);
        setNextButtonColorToWhite();
        setDoneButtonTextColor(Color.WHITE);

    }

    @Override
    public void onSkipPressed() {

    }

    @Override
    public void onDonePressed() {

    }
}
