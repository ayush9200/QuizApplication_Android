package com.example.finaltest_ayushsingh;

import android.provider.BaseColumns;

public class QuizTableSchema {
    private  QuizTableSchema() {

    }

    public static class QuestionTableSchema implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_ANSWER = "answer";
    }
}
