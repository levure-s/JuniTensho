package com.example.JuniTensho;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JuniTensho.dao.MeishikiDaoMeishikiImp;
import com.example.JuniTensho.entity.Meishiki;
import com.example.JuniTensho.repositories.MeishikiRepository;
import com.example.JuniTensho.service.KashikiFacade;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class TenshoApiController {
    @Autowired
    MeishikiRepository repository;

    @Autowired
    MeishikiDaoMeishikiImp dao;

    @Autowired
    KashikiFacade service;

    @RequestMapping(value = "/meishiki/{year}/{month}/{day}", method=RequestMethod.GET)
    public Mono<Meishiki> meishiki(@PathVariable int year,@PathVariable int month,@PathVariable int day) {
        String[] kashiki = service.meishiki(year, month, day);
        
        try {
            Meishiki res = dao.find(kashiki[0], Integer.parseInt(kashiki[1]));
            return Mono.just(res); 
        } catch (Exception e) {
            return Mono.error(new RuntimeException("データ取得に失敗しました", e));
        }
        
    }

    @PostConstruct
    public void init(){
        try {
            ClassPathResource cr = new ClassPathResource("csv/命の課式.csv");
            InputStream is = cr.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            boolean isFirst = true;

            while ((line = br.readLine()) != null) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }

                String[] fields = line.split(",");
                Meishiki meishiki = new Meishiki();
                meishiki.setKanshi(fields[0]);
                meishiki.setKyoku(Integer.parseInt(fields[1]));
                meishiki.setSymbol(fields[2]);
                meishiki.setDescription(fields[3]);
                repository.saveAndFlush(meishiki);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load CSV data", e);
        }
    }
}
