package com.example.practicaradio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Reproductor extends AppCompatActivity {

    private TextView tv1,tv2;
    private Button button_stop;
    private Button button_play;
    private ImageView imgv;
    //private String STREAM_URL = "http://173.192.105.252:8000/stream";
    private MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        button_stop = (Button)findViewById(R.id.button_stop);
        button_play = (Button)findViewById(R.id.button_play);
        imgv = (ImageView)findViewById(R.id.RadioImage);
        mPlayer = new MediaPlayer();


        tv1 = (TextView) findViewById(R.id.tv_radio);
        tv2 = (TextView) findViewById(R.id.tv_Stream);
        String Dato = getIntent().getStringExtra("radioInfo");
        final String Dato2 = getIntent().getStringExtra("URLradio");
        tv1.setText(Dato);
        tv2.setText(Dato2);


        if(Dato.equals("Radio Uno")){
            imgv.setImageResource(R.drawable.runo);
        }
        if(Dato.equals("Radio Karibena")){
            imgv.setImageResource(R.drawable.rkaribena);
        }
        if(Dato.equals("Radio Exitosa")){
            imgv.setImageResource(R.drawable.rexitosa);
        }
        if(Dato.equals("Radio la Kalle")){
            imgv.setImageResource(R.drawable.rlakalle);
        }
        if(Dato.equals("Radio RPP")){
            imgv.setImageResource(R.drawable.rrpp);
        } if(Dato.equals("Radio Nuevo Tiempo")){
            imgv.setImageResource(R.drawable.rnuevotiempo);
        }
        if(Dato.equals("Radio Bavaria")){
            imgv.setImageResource(R.drawable.rrpp);
        }


        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(Reproductor.this,Musica.class).putExtra("urlradio",Dato2));

            }
        });

        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(Reproductor.this,Musica.class));

            }
        });

    }
}
