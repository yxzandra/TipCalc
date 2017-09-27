package com.prueba.yxzandra.ticcalc;

import android.app.Application;

/**
 * Created by Yxzandra Cordero on 14/7/2016.
 */
public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "https://about.me/adriancatalan";

    public  String getAboutUrl() {
        return ABOUT_URL;
    }
}
