package com.example.omerrom.portabelo_june;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
    GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {

    TextView textViewInfo;
    GifMovieView gifView;
    private TextView output_text;                 // This is added for Text output
    private GestureDetectorCompat DetectMe;
    private static final String DEBUG_TAG = "Velocity";
    private VelocityTracker mVelocityTracker = null;
    private double sampleRate;
    private SoundPool spp;
    private int soundID;
    boolean loaded = false;
    static float vel;
    Boolean open = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ////////////////////// check if working
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        DetectMe = new GestureDetectorCompat(this,this);
        DetectMe.setOnDoubleTapListener(this);
        gifView = new GifMovieView (this);
        gifView.bringToFront();
        if(android.os.Build.VERSION.SDK_INT >= 21){
            SoundPool.Builder sp21 = new SoundPool.Builder();
            sp21 = sp21.setAudioAttributes(new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build());
            spp = sp21.build();
        }
        else{
            spp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        }
        spp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
//                mVisualizer.setEnabled(false);
            }
        });
        soundID = spp.load(this, R.raw.a_string, 1);

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pressure = event.getPressure();
        if (event.getX() < 580 && event.getX() > 470) {
            open = true;
        }

        int action = event.getActionMasked();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (mVelocityTracker == null) {
                    // Retrieve a new VelocityTracker object to watch the velocity of a motion.
                    mVelocityTracker = VelocityTracker.obtain();
                } else {
                    // Reset the velocity tracker back to its initial state.
                    mVelocityTracker.clear();
                }
                // Add a user's movement to the tracker.
                mVelocityTracker.addMovement(event);
                break;


            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                mVelocityTracker.computeCurrentVelocity(1000);
                int index = event.getActionIndex();
                int pointerId = event.getPointerId(index);
                float veloX = VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId);
                // static var for the ability to change it
                vel = veloX;
                float veloY = VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId);

                // calc the velocity
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float currentVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float win = Math.min(currentVolume, maxVolume - currentVolume);
                float maxWin = Math.max(win, 0.3f);
                float localMin = Math.max(0, currentVolume - maxWin);
                float localMax = Math.min(maxVolume, currentVolume + maxWin);
                float dobVolume = (Math.abs(vel) / 10000f);
                ;
                float MaxMinvolume = (localMax - localMin);
                float velocityFinal = dobVolume * MaxMinvolume;
                float volume = (pressure + 1f) * velocityFinal;
                Log.i("~~~  Vol  ~~~", "" + volume);
                if (loaded) {
                    // if cross the string - play
                    if (open) {
                        open = false;
                        spp.play(soundID, (float) volume, (float) volume, 1, 0, 0.5f);
                    }
                }

                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // Return a VelocityTracker object back to be re-used by others.
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                break;
        }
        return true;
    }
}
