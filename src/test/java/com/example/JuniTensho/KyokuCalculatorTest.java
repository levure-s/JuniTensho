package com.example.JuniTensho;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.JuniTensho.service.KyokuCalculator;

@SpringBootTest
class KyokuCalculatorTest {
    private final KyokuCalculator kyokuCalculator;
    
    @Autowired
    public KyokuCalculatorTest(KyokuCalculator kyokuCalculator){
        this.kyokuCalculator = kyokuCalculator;
    }

    @ParameterizedTest
    @CsvSource({
        "子,子,'1,昼'","寅,寅,'1,夜'",
        "寅,丑,'2,昼'","辰,卯,'2,夜'",
        "戌,申,'3,昼'","午,辰,'3,夜'",
        "子,酉,'4,昼'","申,巳,'4,夜'",
        "寅,戌,'5,昼'","戌,午,'5,夜'",
        "辰,亥,'6,昼'","子,未,'6,夜'",
        "午,子,'7,昼'","申,寅,'7,夜'",
        "申,丑,'8,昼'","戌,卯,'8,夜'",
        "辰,申,'9,昼'","子,辰,'9,夜'",
        "午,酉,'10,昼'","寅,巳,'10,夜'",
        "申,戌,'11,昼'","辰,午,'11,夜'",
        "戌,亥,'12,昼'","午,未,'12,夜'",
    })
    void 年支と月祥から局数と昼夜を決定(String nenshi,String gessho,String expected){
        String[] result = kyokuCalculator.calculateForMeishiki(nenshi, gessho);
        String[] expectedArray = expected.split(",");
        assertArrayEquals(expectedArray, result);
    }
}
