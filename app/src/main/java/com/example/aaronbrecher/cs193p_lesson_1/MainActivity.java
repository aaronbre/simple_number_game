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
        //call function which will set the button text to 2 random numbers bet 1-10
        setRandomNumbers();
    }

    /*  Event handler for clicking on one of the number buttons checks which number has been
     *   selected and then compares the INT value to the other button if larger get a point smaller
     *   lose a point
     */
    public void checkAnswer(View view) {
        //get the point display textview
        TextView pointsDisplay = (TextView)findViewById(R.id.points_display);
        Button lButton = (Button) findViewById(R.id.l_Button);
        Button rButton = (Button) findViewById(R.id.r_Button);
        //create variables to see which button is selected
        Button selected;
        Button notSelected;
        //assign the selected button and unselected button
        if(view == lButton){
            selected = lButton;
            notSelected = rButton;
        } else{
            selected = rButton;
            notSelected = lButton;
        }
        //Get the integer values of the buttons
        int selectedNum = Integer.parseInt(selected.getText().toString());
        int notSelectedNum = Integer.parseInt(notSelected.getText().toString());
        //check if answer is correct or not and add points and a TOAST
        if(selectedNum > notSelectedNum){
            pointsDisplay.setText("points :" + ++points);
            Toast.makeText(this, "You are Brilliant", Toast.LENGTH_SHORT).show();
        }
        else{
            pointsDisplay.setText("points :" + --points);
            Toast.makeText(this, "You are an Idiot :) !", Toast.LENGTH_SHORT).show();
        }
        //reset the buttons to new numbers
        setRandomNumbers();
    }
    /*  Function to set the button numbers makes use of the Random java.util class
     *  assigns number to the buttons on the UI
     */
    public void setRandomNumbers(){
        Random rand = new Random();
        Button lButton = (Button) findViewById(R.id.l_Button);
        Button rButton = (Button) findViewById(R.id.r_Button);
        int numRight = rand.nextInt(10);
        int numLeft;
        //Makes sure the number is not the same, we wouldn't Want that :)
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
