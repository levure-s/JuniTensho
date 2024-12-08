package com.example.JuniTensho.service;

public class Sekki {
    private String name;
    private int year;
    private int month;
    private int day;

    public Sekki(String name,int year,int month,int day){
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }
}
