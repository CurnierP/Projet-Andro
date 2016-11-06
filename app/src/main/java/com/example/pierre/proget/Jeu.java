package com.example.pierre.proget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by pierre on 06/11/2016.
 */
public class Jeu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstenceState){
        super.onCreate(savedInstenceState);
        View customView = new CustomView(this);
        setContentView(customView);
    }
}
