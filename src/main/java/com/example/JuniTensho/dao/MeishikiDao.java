package com.example.JuniTensho.dao;

import java.io.Serializable;

public interface MeishikiDao<T> extends Serializable {
    public T find(String kanshi,int kyoku);
}
