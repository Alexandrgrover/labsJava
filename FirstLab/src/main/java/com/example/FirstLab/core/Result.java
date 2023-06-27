package com.example.FirstLab.core;

public class Result{
    private String word;
    private boolean polinom;

    public Result(String word, boolean polinom) {
        this.word = word;
        this.polinom = polinom;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isPolinom() {
        return polinom;
    }

    public void setPolinom(boolean polinom) {
        this.polinom = polinom;
    }
}
