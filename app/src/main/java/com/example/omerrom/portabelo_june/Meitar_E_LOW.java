package com.example.omerrom.portabelo_june;

import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by omerrom on 12/07/16.
 */
// extends AppCompatActivity
public class Meitar_E_LOW  extends AppCompatActivity implements Meitar {
    float phone_velocity_X;
    float phone_velocity_Y;
    float phone_position_X;
    float phone_position_Y;

    public Meitar_E_LOW(float phone_velocity_X, float phone_velocity_Y, float phone_position_X, float phone_position_Y){
        this.phone_velocity_X = phone_velocity_X;
        this.phone_velocity_Y = phone_velocity_Y;
        this.phone_position_X = phone_position_X;
        this.phone_position_Y = phone_position_Y;
    }


    final AudioTrack track = new AudioTrack(AudioManager.STREAM_MUSIC,
            44100,
            android.media.AudioFormat.CHANNEL_CONFIGURATION_MONO,
            android.media.AudioFormat.ENCODING_PCM_16BIT,

            android.media.AudioTrack.getMinBufferSize(44100,
                    android.media.AudioFormat.CHANNEL_CONFIGURATION_STEREO,
                    android.media.AudioFormat.ENCODING_PCM_16BIT),
            AudioTrack.MODE_STREAM);


    @Override
    public void pitchShifter(int neck_position_X,int neck_position_Y) {
        track.setPlaybackRate(44100 * neck_position_X * neck_position_Y);
    }

    @Override
    public void volume(){
        track.setVolume(this.phone_velocity_X);
    }

    @Override
    public void play(){
        double input = 0;
        int bufferSize = 512;
        byte[] buffer = new byte[bufferSize];
        //InputStream inputStream = getResources().openRawResource(R.raw.e_string_low);
//        try {
//            String path = "/Users/omerrom/AndroidStudioProjects/Portabelo_June/app/src/main/res/raw/e_string_low.wav";
//            FileInputStream fin = new FileInputStream(path);
//            DataInputStream dis = new DataInputStream(fin);
//            while ((input = dis.read(buffer)) != -1)
//                track.write(buffer, 0, (int) input);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        int i = 0;
        byte[] s = new byte[bufferSize];
        try {
            String filepath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String path = "/Users/omerrom/AndroidStudioProjects/Portabelo_June/app/src/main/res/raw/e_string_low.wav";
            File file=new File("e_string_low.wav");
            InputStream is = this.getResources().openRawResource(R.raw.e_string_low);
            //FileInputStream fin = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            track.play();
            while((i = dis.read(s, 0, bufferSize)) > -1){
                track.write(s, 0, i);

            }
            track.stop();
            track.release();
            dis.close();
//            fin.close();

        } catch (FileNotFoundException e) {
            // TODO
            e.printStackTrace();
        } catch (IOException e) {
            // TODO
            e.printStackTrace();
        }
    }
}
