package com.example.finaltest_ayushsingh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String question = intent.getStringExtra("question");
        String answer = intent.getStringExtra("answer");

        TextView textViewQstn = findViewById(R.id.entrQuestion);
        TextView textViewAns = findViewById(R.id.entrAnswer);

        textViewQstn.setTextSize(45);
        textViewQstn.setText(question);

        textViewAns.setTextSize(45);
        textViewAns.setText(answer);

        setContentView(textViewQstn);
    }

}