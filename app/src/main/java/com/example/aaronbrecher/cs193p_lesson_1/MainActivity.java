package com.example.aaronbrecher.cs193p_lesson_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int points = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRandomNumbers();
    }

    public void checkAnswer(View view) {
        TextView pointsDisplay = (TextView)findViewById(R.id.points_display);
        Button lButton = (Button) findViewById(R.id.l_Button);
        Button rButton = (Button) findViewById(R.id.r_Button);
        Button selected;
        Button notSelected;
        if(view == lButton){
            selected = lButton;
            notSelected = rButton;
        } else{
            selected = rButton;
            notSelected = lButton;
        }
                        
        int selectedNum = Integer.parseInt(selected.getText().toString());
        int notSelectedNum = Integer.parseInt(notSelected.getText().toString());
        if(selectedNum > notSelectedNum){
            pointsDisplay.setText("points :" + ++points);
            Toast.makeText(this, "You are Brilliant", Toast.LENGTH_SHORT).show();
        }
        else{
            pointsDisplay.setText("points :" + --points);
            Toast.makeText(this, "You are an Idiot!", Toast.LENGTH_SHORT).show();
        }
        setRandomNumbers();
    }

    public void setRandomNumbers(){
        Random rand = new Random();
        Button lButton = (Button) findViewById(R.id.l_Button);
        Button rButton = (Button) findViewById(R.id.r_Button);
        int numRight = rand.nextInt(10);
        int numLeft;
        while (true)
        {
            numLeft = rand.nextInt(10);
            if (numLeft != numRight)
                break;
        }
        lButton.setText(Integer.toString(numLeft));
        rButton.setText(Integer.toString(numRight));
    }
}
