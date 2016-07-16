package com.example.omerrom.portabelo_june;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
public class MainActivity extends Activity {
//        AppCompatActivity implements
//    GestureDetector.OnGestureListener,
//    GestureDetector.OnDoubleTapListener {

//    TextView textViewInfo;
//    GifMovieView gifView;
//    private TextView output_text;                 // This is added for Text output
//    private GestureDetectorCompat DetectMe;
//    private static final String DEBUG_TAG = "Velocity";
//    private VelocityTracker mVelocityTracker = null;
//    private double sampleRate;
//    private SoundPool spp;
//    private int soundID;
//    boolean loaded = false;
//    static float vel;
//    Boolean open = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //gifView = new GifMovieView (this);
        //gifView.bringToFront();
//        if (android.os.Build.VERSION.SDK_INT >= 21) {
//            SoundPool.Builder sp21 = new SoundPool.Builder();
//            sp21 = sp21.setAudioAttributes(new AudioAttributes.Builder()
//                    .setUsage(AudioAttributes.USAGE_MEDIA)
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .build());
//            spp = sp21.build();
//        } else {
//            spp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
//        }
//        spp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
//            @Override
//            public void onLoadComplete(SoundPool soundPool, int sampleId,
//                                       int status) {
//                loaded = true;
////                mVisualizer.setEnabled(false);
//            }
//        });
//        soundID = spp.load(this, R.raw.a_string, 1);


        
        //////////////// the gesture  /////////////////
        final GestureDetector gdt = new GestureDetector(new GestureListener());

        /////////////// string buttons  ///////////////
        ImageButton E_LOW_but = (ImageButton) findViewById(R.id.E_LOW);
        E_LOW_but.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                arg1.setSource(1);
                gdt.onTouchEvent(arg1);
                return true;
            }
        });

        ImageButton A_but = (ImageButton) findViewById(R.id.A);
        A_but.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                arg1.setSource(2);
                gdt.onTouchEvent(arg1);
                return true;
            }
        });

        ImageButton D_but = (ImageButton) findViewById(R.id.D);
        D_but.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                arg1.setSource(3);
                gdt.onTouchEvent(arg1);
                return true;
            }
        });

        ImageButton G_but = (ImageButton) findViewById(R.id.G);
        G_but.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                arg1.setSource(4);
                gdt.onTouchEvent(arg1);
                return true;
            }
        });

        ImageButton B_but = (ImageButton) findViewById(R.id.B);
        B_but.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                arg1.setSource(5);
                gdt.onTouchEvent(arg1);
                return true;
            }
        });

        ImageButton E_HIGH = (ImageButton) findViewById(R.id.E_HIGH);
        E_HIGH.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                arg1.setSource(6);
                gdt.onTouchEvent(arg1);
                return true;
            }
        });
    }
}