package com.example.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    int turn = 1;
    int[] status = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void tapped(View view) {
        ImageView v = (ImageView) view;
        if (turn == 1 && status[Integer.parseInt(v.getTag().toString())-1] == 0) {
            v.setImageResource(R.drawable.brain);
            int a = Integer.parseInt(v.getTag().toString());
            status[a-1] = 1;
            turn = 2;
        } else if (turn == 2 && status[Integer.parseInt(v.getTag().toString())-1] == 0){
            v.setImageResource(R.drawable.heart);
            int a = Integer.parseInt(v.getTag().toString());
            status[a-1] = 2;
            turn = 1;
        }

    }

}