package com.example.JuniTensho;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JuniTensho.entity.Meishiki;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class TenshoApiController {
    @RequestMapping(value = "/meishiki", method=RequestMethod.GET)
    public Mono<Meishiki> meishiki() {
        Meishiki m1 = new Meishiki();
        m1.setKanshi("甲子");
        m1.setKyoku(1);
        m1.setSymbol("桜満開の象");
        m1.setDescription("若い内から周囲の羨望を独占し、限りない喜びに溢れた日々が約束されています。");
        return Mono.just(m1);
    }
}
