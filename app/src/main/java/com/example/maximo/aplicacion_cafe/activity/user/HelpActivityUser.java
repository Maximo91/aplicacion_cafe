package com.example.maximo.aplicacion_cafe.activity.user;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import com.example.maximo.aplicacion_cafe.R;
import com.vlonjatg.android.apptourlibrary.AppTour;
import com.vlonjatg.android.apptourlibrary.MaterialSlide;

public class HelpActivityUser extends AppTour {

    @Override
    public void init(Bundle saveInstanceState){
        //Oculta la barra superior
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int firstColor = Color.parseColor("#0097A7");
        int secondColor = Color.parseColor("#FFA000");
        int threeColor = Color.parseColor("#0000FF");
        int fourColor = Color.parseColor("#8258FA");


        Fragment firstSlide = MaterialSlide.newInstance(R.drawable.cafe_logo, "Presentacion del cafe", "Minions ipsum para tú potatoooo baboiii potatoooo uuuhhh bee do bee do bee do chasy hana dul sae tatata bala tu.", Color.WHITE, Color.WHITE);
        Fragment seoondtSlide = MaterialSlide.newInstance(R.drawable.cafe_logo, "Para saber", "Bappleees belloo! Daa wiiiii bee do bee do bee do daa butt pepete wiiiii jeje bappleees.", Color.WHITE, Color.WHITE);
        Fragment threeSlide = MaterialSlide.newInstance(R.drawable.cafe_logo, "Para saber", "Me want bananaaa! uuuhhh belloo! Wiiiii jiji me want bananaaa! Para tú baboiii wiiiii.", Color.WHITE, Color.WHITE);
        Fragment fourSlide = MaterialSlide.newInstance(R.drawable.cafe_logo, "Finalizando", "Bananaaa! Baboiii gelatooo me want bananaaa! Me want bananaaa! bananaaaa.", Color.WHITE, Color.WHITE);

        addSlide(firstSlide,firstColor);
        addSlide(seoondtSlide, secondColor);
        addSlide(threeSlide, threeColor);
        addSlide(fourSlide, fourColor);

        //addSlide(new CustomSlide(), customSlideColor);

        setSkipButtonTextColor(Color.WHITE);
        setNextButtonColorToWhite();
        setDoneButtonTextColor(Color.WHITE);

    }

    @Override
    public void onSkipPressed() {
        setCurrentSlide(4);
    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(getApplicationContext(), MenuPrincipalUser.class));
    }

}
