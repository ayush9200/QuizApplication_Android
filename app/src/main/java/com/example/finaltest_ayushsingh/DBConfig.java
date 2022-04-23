package com.example.finaltest_ayushsingh;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DBConfig extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyFinalTest.db";
    private static final int DATABASE_VERSION = 2;
    private SQLiteDatabase db;
    private static DBConfig instance;

    public DBConfig(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBConfig getInstance(Context context) {
        if (instance == null) {
            instance = new DBConfig(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = db;

        final String SQL_CREATE_Quiz_Questions_TABLE = "CREATE TABLE " +
                QuizTableSchema.QuestionTableSchema.TABLE_NAME + " ( " +
                QuizTableSchema.QuestionTableSchema._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizTableSchema.QuestionTableSchema.COLUMN_QUESTION + " TEXT, " +
                QuizTableSchema.QuestionTableSchema.COLUMN_ANSWER + " TEXT, " +
                ")";

        db.execSQL(SQL_CREATE_Quiz_Questions_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizTableSchema.QuestionTableSchema.TABLE_NAME);
        onCreate(db);
    }

   /* private void CurrentAffairs_Questions() {
        Question q1 = new Question("The worlds oldest international human rights organization is?", " amnesty international ", " freedom house ", " anti slavery ", "non of these ", 3);
        addQuestion(q1);

        Question q2 = new Question("The constitution of European union has not been ratified by?", " Italy ", "Netherlands ", " France ", "non of these ", 3);
        addQuestion(q2);

        Question q3 = new Question("After united states, the largest contributor in the united nations budget is? ", " Germany ", " France ", " UK ", " none of these", 3);
        addQuestion(q3);
    }*/

    // Method to insert data
    public void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizTableSchema.QuestionTableSchema.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizTableSchema.QuestionTableSchema.COLUMN_ANSWER, question.getAnswer());
        db.insert( QuizTableSchema.QuestionTableSchema.TABLE_NAME, null, cv);
    }

    public void updatedQuestion(Question qt) {
        ContentValues cv = new ContentValues();
        cv.put(QuizTableSchema.QuestionTableSchema.COLUMN_QUESTION, qt.getQuestion());
        cv.put(QuizTableSchema.QuestionTableSchema.COLUMN_ANSWER, qt.getAnswer());

        String selection = QuizTableSchema.QuestionTableSchema.COLUMN_QUESTION + " =' ? '";
        String[] selectionArgs = new String[]{qt.getQuestion()};
        db.update(QuizTableSchema.QuestionTableSchema.TABLE_NAME, cv, selection, selectionArgs);
    }

    @SuppressLint("Range")
    public Question getQuestions(String qt) {
        Question returnQuest = new Question();
        db = getReadableDatabase();

        String selection = QuizTableSchema.QuestionTableSchema.COLUMN_QUESTION + " =' ? '";
        String[] selectionArgs = new String[]{qt};

        Cursor c = db.query(
                QuizTableSchema.QuestionTableSchema.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (c.moveToFirst()) {
            do {
                returnQuest.setId(c.getInt(c.getColumnIndex(QuizTableSchema.QuestionTableSchema._ID)));
                returnQuest.setQuestion(c.getString(c.getColumnIndex(QuizTableSchema.QuestionTableSchema.COLUMN_QUESTION)));
                returnQuest.setAnswer(c.getString(c.getColumnIndex(QuizTableSchema.QuestionTableSchema.COLUMN_ANSWER)));
            } while (c.moveToNext());
        }

        c.close();
        return returnQuest;
    }


}
