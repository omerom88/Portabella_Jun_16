package com.example.omerrom.portabelo_june;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ImageButton;
import java.io.InputStream;


public class GifMovieView extends ImageButton {

    private InputStream gifInputStream;
    private Movie gifMovie;
    private int movieWidth, movieHeight;
    private long movieDuration;
    private long movieStart;

    public GifMovieView(Context context) {
        super(context);
        init(context);
    }


    public GifMovieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GifMovieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setFocusable(true);
        gifInputStream = context.getResources().openRawResource(R.raw.stringstrdecayover10);
        gifMovie = Movie.decodeStream(gifInputStream);
        movieWidth = gifMovie.width();
        movieHeight = gifMovie.height();
        movieDuration = gifMovie.duration();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(movieWidth, movieHeight);
    }

    public int getMovieWidth() {
        return movieWidth;
    }

    public int getMovieHeight() {
        return movieHeight;
    }

    public long getMovieDuration() {
        return movieDuration;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        long now = SystemClock.uptimeMillis();

        if(movieStart == 0) {
            movieStart = now;
        }

        if(gifMovie != null) {

            int dur = gifMovie.duration();
            if(dur == 0) {
                dur = 1000;
            }

            int relTime = (int)((now - movieStart) % dur);
            double scaleX = (double) this.getWidth();
            double scaleY = (double) this.getHeight();
            gifMovie.setTime(relTime);
//            canvas.scale((float) scaleX, (float) scaleY);
            gifMovie.draw(canvas, 0,0);
        }
        this.invalidate();
    }
}
