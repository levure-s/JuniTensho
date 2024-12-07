package com.example.JuniTensho.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meishiki {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int id;

    @Column(length = 2,nullable = false)
    public String kanshi;

    @Column(nullable = false)
    public Integer kyoku;

    @Column(nullable = false)
    public String symbol;

    @Column(columnDefinition = "TEXT",nullable = false)
    public String description;

    public void setKanshi(String kanshi){
        this.kanshi = kanshi;
    }

    public void setKyoku(int kyoku){
        this.kyoku = kyoku;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
