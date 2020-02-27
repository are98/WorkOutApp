package com.example.hiitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int ADD_NEW_PART_INTENT_ID = 1234;

    ArrayList<WorkoutClass> fullWorkout = new ArrayList<>();

    private int seconds;
    private String secondsStr;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.newButton).setOnClickListener(this);
        findViewById(R.id.startButton).setOnClickListener(this);

        Intent objectIntent = getIntent();
        int returnedSeconds = objectIntent.getIntExtra("returnedSeconds", 0);
        String returnedType = objectIntent.getStringExtra("returnedType");

        seconds = returnedSeconds;

        tulostaKaikki();


        //näyttää palautetut arvot, Workout/rest, seconds
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(returnedSeconds + "   " + returnedType);

        ////////////////////////////////////////////////////////////////////////////////

        if(returnedType != null && returnedSeconds != 0)
        {
            secondsStr = String.valueOf(seconds);

            type = returnedType;
            //kun ollaan asetettu tyyppi ja aika, siitä tehdään osio listaan
            // fullWorkout.add(new WorkoutClass(seconds, type));

            tulostaKaikki();
        }

        if(returnedType == null)
        {

        }


    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.newButton)
        {
            Intent intent = new Intent(this, AddNewPart.class);
            startActivityForResult(intent, ADD_NEW_PART_INTENT_ID);
        }

        else if (view.getId() == R.id.startButton)
        {

        }


    }

    public void tulostaKaikki()
    {

        for (int i = 1; (i - 1) < fullWorkout.size(); i++)
        {

        }
    }
}