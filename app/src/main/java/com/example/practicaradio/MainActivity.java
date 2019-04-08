package com.example.practicaradio;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

import static android.app.Service.START_STICKY;

public class MainActivity extends AppCompatActivity {



    private ListView lv1;

    private String nombreRadio [] = {"Radio Uno","Radio Karibena","Radio Exitosa","Radio la Kalle","Radio RPP", "Radio Nuevo Tiempo","Radio Bavaria"};
    private String StreamURL [] = {"http://173.244.209.219:6012/stream","http://173.192.105.252:8000/stream","http://37.187.79.93:8248",
            "http://198.50.235.3:20020/stream","http://78.129.202.200:8040","http://104.200.142.184:80/1720_128","http://188.138.1.52:18576"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView)findViewById(R.id.lv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_radio, nombreRadio);
        lv1.setAdapter(adapter);





        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent siguiente = new Intent(getBaseContext(),Reproductor.class);
                siguiente.putExtra("radioInfo", lv1.getItemAtPosition(position).toString());
                siguiente.putExtra("URLradio", StreamURL[position].toString());
                startActivity(siguiente);

                /*
                Toast.makeText(getApplicationContext(),"Aqui mandare el nombre de la radio" +
                        ""+lv1.getItemAtPosition(position)+" el URL sera: "+ StreamURL[position],Toast.LENGTH_SHORT).show();
                        */
            }
        });


    }

}
