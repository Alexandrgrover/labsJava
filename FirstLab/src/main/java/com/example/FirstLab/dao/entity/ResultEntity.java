package com.example.FirstLab.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "lab", name = "results")
public class ResultEntity {
    @Id
    @Column(name = "word")
    private String word;
    @Column(name = "is_polinom")
    private boolean polinom;

    public ResultEntity() {
    }

    public ResultEntity(String word, boolean is_polinom) {
        this.word = word;
        this.polinom = is_polinom;
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
