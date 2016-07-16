package com.example.omerrom.portabelo_june;

import android.view.GestureDetector;
import android.view.MotionEvent;
import static java.lang.System.*;

/**
 * Created by omerrom on 12/07/16.
 */
public class GestureListener extends GestureDetector.SimpleOnGestureListener {
    Meitar_E_LOW meitarE_LOW = new Meitar_E_LOW(1f,1f,1f,1f);
    Meitar_A meitarA = new Meitar_A(1f,1f,1f,1f);
    Meitar_D meitarD = new Meitar_D(1f,1f,1f,1f);
    Meitar_G meitarG = new Meitar_G(1f,1f,1f,1f);
    Meitar_B meitarB = new Meitar_B(1f,1f,1f,1f);
    Meitar_E_HIGH meitarE_HIGH = new Meitar_E_HIGH(1f,1f,1f,1f);


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getSource() == 1) {
            meitarE_LOW.phone_position_X = e1.getX();
            meitarE_LOW.phone_position_Y = e1.getY();
            meitarE_LOW.phone_velocity_X = velocityX;
            meitarE_LOW.phone_velocity_Y = velocityY;
            meitarE_LOW.pitchShifter(1, 1);
            meitarE_LOW.volume();
            out.println("E_LOW");
            //meitarE_LOW.play();
        }
        if (e1.getSource() == 2) {
            meitarA.phone_position_X = e1.getX();
            meitarA.phone_position_Y = e1.getY();
            meitarA.phone_velocity_X = velocityX;
            meitarA.phone_velocity_Y = velocityY;
            meitarA.pitchShifter(1, 1);
            meitarA.volume();
            out.println("A");
            //meitarA.play();
        }
        if (e1.getSource() == 3) {
            meitarD.phone_position_X = e1.getX();
            meitarD.phone_position_Y = e1.getY();
            meitarD.phone_velocity_X = velocityX;
            meitarD.phone_velocity_Y = velocityY;
            meitarD.pitchShifter(1, 1);
            meitarD.volume();
            out.println("D");
            //meitarD.play();
        }
        if (e1.getSource() == 4){
            meitarG.phone_position_X = e1.getX();
            meitarG.phone_position_Y = e1.getY();
            meitarG.phone_velocity_X = velocityX;
            meitarG.phone_velocity_Y = velocityY;
            meitarG.pitchShifter(1, 1);
            meitarG.volume();
            out.println("G");
            //meitarG.play();
        }
        if (e1.getSource() == 5){
            meitarB.phone_position_X = e1.getX();
            meitarB.phone_position_Y = e1.getY();
            meitarB.phone_velocity_X = velocityX;
            meitarB.phone_velocity_Y = velocityY;
            meitarB.pitchShifter(1, 1);
            meitarB.volume();
            out.println("B");
            //meitarB.play();
        }
        if (e1.getSource() == 6){
            meitarE_HIGH.phone_position_X = e1.getX();
            meitarE_HIGH.phone_position_Y = e1.getY();
            meitarE_HIGH.phone_velocity_X = velocityX;
            meitarE_HIGH.phone_velocity_Y = velocityY;
            meitarE_HIGH.pitchShifter(1, 1);
            meitarE_HIGH.volume();
            out.println("E_HIGH");
            //meitarE_HIGH.play();
        }
        return true;
    }
}