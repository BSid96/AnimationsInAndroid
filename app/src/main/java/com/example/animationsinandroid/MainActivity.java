package com.example.animationsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int turn = 1;
    int turn2;
    int[] status = new int[9];
    int[][] winCondition = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void tapped(View view) {
        if (result != "done") {
            ImageView v = (ImageView) view;
            if (turn == 1 && status[Integer.parseInt(v.getTag().toString()) - 1] == 0) {
                v.setImageResource(R.drawable.brain);
                int a = Integer.parseInt(v.getTag().toString());
                status[a - 1] = 1;
                turn = 2;
                turn2 = 1;

            } else if (turn == 2 && status[Integer.parseInt(v.getTag().toString()) - 1] == 0) {
                v.setImageResource(R.drawable.heart);
                int a = Integer.parseInt(v.getTag().toString());
                status[a - 1] = 2;
                turn = 1;
                turn2 = 2;
            }

            for (int[] state : winCondition) {
                if (status[state[0] - 1] == status[state[1] - 1] && status[state[1] - 1] == status[state[2] - 1] && status[state[0] - 1] != 0) {

                    Toast.makeText(this, "Player " + turn2 + " won", Toast.LENGTH_SHORT).show();
                    result = "done";

                }
            }


        }
    }

}