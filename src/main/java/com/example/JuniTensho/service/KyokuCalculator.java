package com.example.JuniTensho.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class KyokuCalculator {
    private final List<String> junishi = Arrays.asList("子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥");

    public String[] calculateForMeishiki(String nenshi,String gessho){
        int y = this.junishi.indexOf(nenshi);
        int m = this.junishi.indexOf(gessho);
        int kyoku = (12 + (y - m)) % 12 + 1;

        String chuya;
        if (m < 2 || m > 7) {
            chuya = "昼";
        }else{
            chuya = "夜";
        }

        String[] res = {String.valueOf(kyoku) ,chuya};
        return res;
    }
}
