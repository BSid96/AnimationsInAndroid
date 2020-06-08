package com.example.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtHelloWorld;
    private TextView txtHiWorld;
    private ImageView lion;
    private ImageView tiger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHelloWorld = findViewById(R.id.txtHelloWorld);
        txtHiWorld = findViewById(R.id.txtHiWorld);
        lion = findViewById(R.id.lion);
        tiger = findViewById(R.id.tiger);


        txtHelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                txtHelloWorld.animate().alpha(0).setDuration(2000);
//                txtHelloWorld.setText("Hi World!!");
//                txtHelloWorld.animate().alpha(1).setDuration(2000);

                if (txtHelloWorld.getAlpha() == 1){

                    txtHelloWorld.animate().alpha(0).setDuration(2000);
                    txtHiWorld.animate().alpha(1).setDuration(2000);
                    }else {
                    txtHelloWorld.animate().alpha(1).setDuration(2000);
                    txtHiWorld.animate().alpha(0).setDuration(2000);
                }

            }
        });

        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lion.getAlpha() == 1){
                    lion.animate().alpha(0).setDuration(2000);
                    tiger.animate().alpha(1).setDuration(2000);
                }else {
                    lion.animate().alpha(1).setDuration(2000);
                    tiger.animate().alpha(0).setDuration(2000);
                }
            }
        });
    };

}