package com.example.omerrom.portabelo_june;

import android.media.AudioManager;
import android.media.AudioTrack;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by omerrom on 12/07/16.
 */
public class Meitar_A extends AppCompatActivity implements Meitar {
    float phone_velocity_X;
    float phone_velocity_Y;
    float phone_position_X;
    float phone_position_Y;

    public Meitar_A(float phone_velocity_X, float phone_velocity_Y, float phone_position_X, float phone_position_Y) {
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
    public void pitchShifter(int neck_position_X, int neck_position_Y) {
        track.setPlaybackRate(44100 * neck_position_X * neck_position_Y);
    }

    @Override
    public void volume() {
        track.setVolume(this.phone_velocity_X);
    }

    @Override
    public void play() {
    }
}