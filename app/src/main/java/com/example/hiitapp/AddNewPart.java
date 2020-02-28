package com.example.hiitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddNewPart extends AppCompatActivity implements View.OnClickListener{

    private String secondsStr;
    private int seconds;
    private String type; //     1 = Work out / 2 = Pause

    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_part);
        findViewById(R.id.addButton).setOnClickListener(this);
        seconds = 0;
        type = "";

    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.addButton)
        {
            EditText editText = (EditText) findViewById(R.id.editText);
            EditText workoutEditText = (EditText) findViewById(R.id.ownWorkoutEditText);

            rb1 = (RadioButton) findViewById(R.id.radioButton1);
            rb2 = (RadioButton) findViewById(R.id.radioButton2);
            rb3 = (RadioButton) findViewById(R.id.radioButton3);

            secondsStr = editText.getText().toString();
            seconds = Integer.parseInt(secondsStr);

            if(rb1.isChecked())
            {
                type = "Work out";
            }

            if(rb2.isChecked())
            {
                type = "Pause";
            }

            if(rb3.isChecked())
            {
                type = workoutEditText.getText().toString();
            }

            Intent objectIntent = new Intent(AddNewPart.this, MainActivity.class);

            objectIntent.putExtra("returnedSeconds", seconds);
            objectIntent.putExtra("returnedType", type);
            startActivity(objectIntent);

        }
    }
}