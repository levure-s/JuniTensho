package com.example.JuniTensho;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.JuniTensho.service.KanshiCalculator;

@SpringBootTest
public class KanshiCalculatorTest {
    private final KanshiCalculator kanshiCalculator;

    @Autowired
    public KanshiCalculatorTest(KanshiCalculator kanshiCalculator){
        this.kanshiCalculator = kanshiCalculator;
    }

    @Test
    void 生年月日から課式を取得(){
        String[] result = kanshiCalculator.calculateKanshi(1986, 3, 20);
        String[] test = {"寅", "亥","癸亥"};
        assertArrayEquals(test, result);
    }
}
