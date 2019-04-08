package com.example.practicaradio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

public class Musica extends Service {

    String data;
    MediaPlayer reproductor;



    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onCreate(){
        reproductor = new MediaPlayer();

        Toast.makeText(this,"El servicio ha Empezado",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this,"Disfrute lo Mejor de la Musica",
                Toast.LENGTH_SHORT).show();
        reproductor.start();

        data=(String) intent.getExtras().get("urlradio");
        try {
            reproductor.setDataSource(data);
            reproductor.prepareAsync();
            reproductor.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this,"El Servicio ha Parado",Toast.LENGTH_SHORT).show();
        reproductor.stop();
    }
}
