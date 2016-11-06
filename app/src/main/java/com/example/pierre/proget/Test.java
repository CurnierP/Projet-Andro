package com.example.pierre.proget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Curnier on 27/10/2016.
 */

public class Test extends Activity {

    final Context context = this;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);


        final Intent intent = getIntent();
        if (intent != null) {
            TextView textView = (TextView) findViewById(R.id.text_view);
            TextView textView1 = (TextView) findViewById(R.id.text_view_1);
            NumberPicker nombre = (NumberPicker) findViewById(R.id.numberPicker1);

            ImageView image = (ImageView) findViewById(R.id.imageView1);

            //Numberpicker
            nombre.setMaxValue(intent.getIntExtra("entities", 1));
            nombre.setMinValue(intent.getIntExtra("entities", 1));
            nombre.setWrapSelectorWheel(false);
            nombre.setValue(intent.getIntExtra("entities", 1));

            //Seekbar
            final SeekBar v = (SeekBar) findViewById(R.id.vitesse);
            v.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    final TextView vite = (TextView) findViewById(R.id.test);
                    vite.setText("Vitesse:  " + progress + " %");
                    v.setMax(100);
                    v.setProgress(intent.getIntExtra("speed", 0));
                }
            });
            //Image
            Bundle extras = getIntent().getExtras();

            textView1.setBackgroundColor(Color.BLACK);
            textView.setText(intent.getStringExtra("color"));
            Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");
            image.setImageBitmap(bmp);

            Button acueil = (Button) findViewById(R.id.non);
            acueil.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Test.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            Button jouer = (Button) findViewById(R.id.oui);
            jouer.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Test.this, Jeu.class);
                    startActivity(intent);
                }

            });

            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

// Boite de dialogue s'ouvre quand on appuie sur le carrée noir
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dialog_box);
                    dialog.setTitle("Vous avez trouvé l'intrus BRAVO !!!");


                    Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }

            });
        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Test Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.pierre.proget/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Test Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.pierre.proget/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}





