package com.example.JuniTensho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JuniTensho.entity.Meishiki;

@Repository
public interface MeishikiRepository extends JpaRepository<Meishiki,Integer>{
    public Meishiki findById(int id);
}
