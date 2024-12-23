package com.example.JuniTensho.service;

public class NijushiSekkiFactory {
    private final String[] nijushisekki = {
        "小寒", "大寒", "立春", "雨水", "啓蟄", "春分", "清明", "穀雨", "立夏", "小満", "芒種", "夏至",
        "小暑", "大暑", "立秋", "処暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"
    };
    private final double[] constant1 = {
        6.3811,21.1046,4.8693,19.7062,6.3968,21.4471,5.628,20.9375,6.3771,21.93,6.5733,22.2747,
        8.0091,23.7317,8.4102,24.0125,8.5186,23.8896,9.1414,24.2487,8.2396,23.1189,7.9152,22.6587
    };
    private final double[] constant2 = {
        0.242778,0.242765,0.242713,0.242627,0.242512,0.242377,0.242231,0.242083,0.241945,0.241825,0.241731,0.241669,
        0.241642,0.241654,0.241703,0.241786,0.241898,0.242032,0.242179,0.242328,0.242469,0.242592,0.242689,0.242752
    };
    private final int[] month = {
        1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12
    };

    public Sekki create(int index ,int year){
        int y = year;
        if (index < 4) {
            y = y - 1;
        }
        y = y - 1900;
        double const2 = this.constant2[index] * y;
        int day = (int)(this.constant1[index] + const2) - (int)(y/4);
        return new Sekki(this.nijushisekki[index], year, this.month[index], day);
    }

}
