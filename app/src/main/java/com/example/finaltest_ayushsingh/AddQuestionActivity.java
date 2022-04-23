package com.example.finaltest_ayushsingh;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionActivity extends AppCompatActivity {
    private EditText question;
    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.entrQuestion);
        answer = findViewById(R.id.entrAnswer);

        Button buttonSubmit = findViewById(R.id.submitBtn);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuestion();
            }
        });
    }



    private void addQuestion() {
        String questionString = question.getText().toString();
        String answerString = answer.getText().toString();

        boolean filled = true;
        if (!checkLength(questionString))
            filled = false;
        if (!checkLength(answerString))
            filled = false;

        if (filled) {
            Question newQuestion = new Question(questionString, answerString);
            DBConfig dbHelper = DBConfig.getInstance(this);
            dbHelper.addQuestion(newQuestion);

            clearFields();

            Toast.makeText(this, "Question added!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Please, fill every field.", Toast.LENGTH_SHORT).show();
    }

    private void clearFields() {
        question.setText("");
        answer.setText("");
    }

    private boolean checkLength(String string) {
        if (string.length() > 0)
            return true;
        else
            return false;
    }
}
