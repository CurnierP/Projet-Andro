package com.example.pierre.proget;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    final String color = "color";
    final String Coleur = "Coleur";
    final String entites = "entities";
    final String speed = "speed";
    final String imagebitmap = "image";
    CharSequence texte;
    Bitmap image;
    int codeCouleur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);

        final ImageView bus = (ImageView) findViewById(R.id.bus);
        final ImageView avion = (ImageView) findViewById(R.id.avion);
        final ImageView moto = (ImageView) findViewById(R.id.moto);
        final ImageView ambulance = (ImageView) findViewById(R.id.ambulance);

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bus.buildDrawingCache();
                image= bus.getDrawingCache();
            }
        });

        avion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                avion.buildDrawingCache();
                image= avion.getDrawingCache();
            }
        });

        moto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moto.buildDrawingCache();
                image= moto.getDrawingCache();
            }
        });

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ambulance.buildDrawingCache();
                image= ambulance.getDrawingCache();
            }
        });

        final TextView Rouge = (TextView) findViewById(R.id.Red);
        final TextView Orange = (TextView) findViewById(R.id.Orange);
        final TextView Jaune = (TextView) findViewById(R.id.Yellow);
        final TextView Bleu = (TextView) findViewById(R.id.Blue);
        final TextView Vert = (TextView) findViewById(R.id.Green);
        final TextView Violet = (TextView) findViewById(R.id.Purple);
        final TextView Rose = (TextView) findViewById(R.id.Pink);

        Rouge.setBackgroundColor(Color.RED);
        Rouge.setText("Rouge");
        Orange.setText("Orange");
        Jaune.setText("Jaune");
        Bleu.setText("Bleu");
        Vert.setText("Vert");
        Violet.setText("Violet");
        Rose.setText("Rose");

        Rouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texte = Rouge.getText();
            }
        });

        Orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texte = Orange.getText();
            }
        });

        Jaune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texte = Jaune.getText();
            }
        });

        Bleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texte = Bleu.getText();
            }
        });
        Vert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texte = Vert.getText();
            }
        });
        Violet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texte = Violet.getText();
            }
        });
        Rose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texte = Rose.getText();
            }
        });
        //NumberPicker
        final NumberPicker nombre = (NumberPicker) findViewById(R.id.numberPicker1);
        nombre.setMaxValue(10);
        nombre.setMinValue(1);
        nombre.setWrapSelectorWheel(false);

       //SeekBar
        final SeekBar vitesse = (SeekBar)findViewById(R.id.sbar); // make seekbar object
        vitesse.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
           }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                final TextView vite = (TextView) findViewById(R.id.vitesse);
                vite.setText("Vitesse:  "+progress + " %");
                vitesse.setMax(100);
            }
        });

        final Button playButton = (Button) findViewById(R.id.bouton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Test.class );
                Bundle extras = new Bundle();

                intent.putExtra("color", texte);
                intent.putExtra("entities", nombre.getValue());
                extras.putParcelable("imagebitmap", image);
                intent.putExtras(extras);
                intent.putExtra("speed", vitesse.getProgress());
                //intent.putExtra("Coleur",test);
                //setResult(1000, intent);
                startActivity(intent);
            }
        });
    }

}


