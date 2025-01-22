package com.example.JuniTensho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.JuniTensho.service.NijushiSekkiFactory;
import com.example.JuniTensho.service.Sekki;

@SpringBootTest
class NijushiSekkiFactoryTest {
    private final NijushiSekkiFactory nijushiSekkiFactory;

    @Autowired
    public NijushiSekkiFactoryTest(NijushiSekkiFactory nijushiSekkiFactory){
        this.nijushiSekkiFactory = nijushiSekkiFactory;
    }
    
    @ParameterizedTest
    @CsvSource({"1987, 2, '立春,1987,2,4'",})
    void その年の二十四節季を求める(int year, int index, String fields){
        String[] parts = fields.split(",");
        Sekki expected = new Sekki(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));

        Sekki result = nijushiSekkiFactory.create(index, year);

        assertEquals(expected.getName(), result.getName());
        assertEquals(expected.getYear(), result.getYear());
        assertEquals(expected.getMonth(), result.getMonth());
        assertEquals(expected.getDay(), result.getDay());
    }
}
