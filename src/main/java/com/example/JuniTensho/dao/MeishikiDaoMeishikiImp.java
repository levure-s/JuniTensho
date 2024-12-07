package com.example.JuniTensho.dao;

import org.springframework.stereotype.Repository;

import com.example.JuniTensho.entity.Meishiki;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class MeishikiDaoMeishikiImp implements MeishikiDao<Meishiki>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Meishiki find(String kanshi,int kyoku){
        String qstr = "from Meishiki where kanshi = :kanshi and kyoku = :kyoku";
        Query query = entityManager.createQuery(qstr);
        query.setParameter("kanshi", kanshi);
        query.setParameter("kyoku", kyoku);
        return (Meishiki)query.getSingleResult();
    }
}
