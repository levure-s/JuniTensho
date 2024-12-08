package com.example.JuniTensho.service;

import org.springframework.stereotype.Service;

@Service
public class KashikiFacade {
    private final KanshiCalculator kanshiCalculator = new KanshiCalculator();
    private final KyokuCalculator  kyokuCalculator = new KyokuCalculator();

    public String[] meishiki(int year,int month,int day){
        String[] kanshi= kanshiCalculator.calculateKanshi(year,month,day);
        String[] kyoku = kyokuCalculator.calculateForMeishiki(kanshi[0],kanshi[1]);
        String[] res = {kanshi[2],kyoku[0]};
        return res;
    }
}
