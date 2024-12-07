package com.example.JuniTensho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JuniTensho.dao.MeishikiDaoMeishikiImp;
import com.example.JuniTensho.entity.Meishiki;
import com.example.JuniTensho.repositories.MeishikiRepository;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class TenshoApiController {
    @Autowired
    MeishikiRepository repository;

    @Autowired
    MeishikiDaoMeishikiImp dao;

    @RequestMapping(value = "/meishiki", method=RequestMethod.GET)
    public Mono<Meishiki> meishiki() {
        Meishiki res = dao.find("甲子", 3);
        return Mono.just(res);
    }

    @PostConstruct
    public void init(){
        Meishiki m1 = new Meishiki();
        m1.setKanshi("甲子");
        m1.setKyoku(1);
        m1.setSymbol("桜満開の象");
        m1.setDescription("若い内から周囲の羨望を独占し、限りない喜びに溢れた日々が約束されています。");
        Meishiki m2 = new Meishiki();
        m2.setKanshi("甲子");
        m2.setKyoku(2);
        m2.setSymbol("干潮満潮の象");
        m2.setDescription("一生を通じ、幸不幸の振幅が激しのがあなたの人生。");
        Meishiki m3 = new Meishiki();
        m3.setKanshi("甲子");
        m3.setKyoku(3);
        m3.setSymbol("小川集りて大河となるの象");
        m3.setDescription("苦労の多い幼少期を経て、人生は急激に開花します。");
        repository.saveAndFlush(m1);
        repository.saveAndFlush(m2);
        repository.saveAndFlush(m3);
    }
}
