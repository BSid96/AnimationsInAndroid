package com.example.animationsinandroid;


import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    int turn = 1;
    String bodyPart;
    int[] status = new int[9];
    int[][] winCondition = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    String result;
    Button f;
    GridLayout g;
    ImageView hp, bp;
    int chances = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f = findViewById(R.id.button);
        g = findViewById(R.id.gridLayout);
        hp = findViewById(R.id.heartPlayer);
        bp = findViewById(R.id.brainPlayer);

        hp.animate().translationXBy(500).scaleX(0.5f).scaleY(0.5f).setDuration(250);
    }

    public void tapped(View view) {
        ImageView v = (ImageView) view;
        if (result != "done" && chances != 9 && status[Integer.parseInt(v.getTag().toString()) - 1] == 0 ) {

            if (turn == 1 ) {
                v.setImageResource(R.drawable.brain);
                int a = Integer.parseInt(v.getTag().toString());
                status[a - 1] = 1;
                turn = 2;
                hp.setAlpha(1f);
                bp.setAlpha(0.5f);
                hp.animate().translationXBy(-500).scaleX(1f).scaleY(1f).setDuration(250);
                bp.animate().translationXBy(-500).scaleX(0.5f).scaleY(0.5f).setDuration(250);
            } else if (turn == 2) {
                v.setImageResource(R.drawable.heart);
                int a = Integer.parseInt(v.getTag().toString());
                status[a - 1] = 2;
                turn = 1;
                hp.setAlpha(0.5f);
                bp.setAlpha(1f);
                hp.animate().translationXBy(500).scaleX(0.5f).scaleY(0.5f).setDuration(250);
                bp.animate().translationXBy(500).scaleX(1f).scaleY(1f).setDuration(250);
            }

            chances++;
            for (int[] state : winCondition) {
                if (status[state[0] - 1] == status[state[1] - 1] && status[state[1] - 1] == status[state[2] - 1] && status[state[0] - 1] != 0) {
                    if (turn == 1){
                        bodyPart = "Heart";
                    }else {
                        bodyPart = "Brain";
                    }
                    Toast.makeText(this, bodyPart + " won", Toast.LENGTH_SHORT).show();
                    result = "done";
                    f.setVisibility(View.VISIBLE);

                }
            }
        }



        if(chances == 9 && result != "done"){
            Toast.makeText(this, "It's a Tie", Toast.LENGTH_SHORT).show();
            hp.setAlpha(0.5f);
            bp.setAlpha(0.5f);
            chances = 0;
            if (turn == 1){
                bodyPart = "Heart";
            }else {
                bodyPart = "Brain";
            }
            f.setVisibility(View.VISIBLE);
        }
    }

    public void restart(View view){
        turn = 1;
        status = new int[9];
        result = "";
        for (int i = 0 ; i < g.getChildCount(); i++){
            ImageView image = (ImageView) g.getChildAt(i);
            image.setImageResource(R.color.colorPrimary);
        }
        f.setVisibility(View.GONE);
        chances = 0;
        if (bodyPart == "Brain"){
            hp.animate().translationXBy(500).scaleX(0.5f).scaleY(0.5f).setDuration(250);
            bp.animate().translationXBy(500).scaleX(1f).scaleY(1f).setDuration(250);
            bp.setAlpha(1f);
            hp.setAlpha(0.5f);
        }

    }

}