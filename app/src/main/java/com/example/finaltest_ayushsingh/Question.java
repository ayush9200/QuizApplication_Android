package com.example.finaltest_ayushsingh;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {


    private int id;
    private String question;
    private String answer;

    public Question(){

    }

    public Question(Parcel in) {
        id = in.readInt();
        question = in.readString();
        answer = in.readString();
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(question);
        parcel.writeString(answer);
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
