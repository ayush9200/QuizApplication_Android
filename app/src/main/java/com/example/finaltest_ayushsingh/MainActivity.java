package com.example.finaltest_ayushsingh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText question;
    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.entrQuestion);
        answer = findViewById(R.id.entrAnswer);

        Button buttonAddQuestion = findViewById(R.id.addQuestion);
        buttonAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuestion();
            }
        });


        Button buttonUpdateQuestion = findViewById(R.id.updateQuestion);
        buttonUpdateQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        Button buttonPreview = findViewById(R.id.previewBtn);
        buttonPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previewQuestion();
            }
        });
    }

        private void addQuestion() {
            Intent intent = new Intent(MainActivity.this, AddQuestionActivity.class);
            startActivity(intent);
        }

        private void updateQuestion() {
            Intent intent = new Intent(MainActivity.this, UpdateQuestionActivity.class);
            startActivity(intent);
        }

        private void previewQuestion() {
            Intent intent = new Intent(MainActivity.this, PreviewActivity.class);
            String questionString = question.getText().toString();
            String answerString = answer.getText().toString();
            intent.putExtra("question",questionString);
            intent.putExtra("answer",answerString);
            startActivity(intent);
        }

}