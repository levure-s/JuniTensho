package com.example.JuniTensho.service;

import java.util.Calendar;
import java.util.TimeZone;

public class KanshiCalculator {
    private final String[] jikkan = {"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
    private final String[] junishi = {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
    public String[] calculateKanshi(int year,int month,int day){
        String[] res = {
            nenshi(year, month, day),
            gessho(year, month, day),
            nichiKnashi(year, month, day)
        };
        return res;
    }

    private String nenshi(int year,int month,int day){
        int res = (year - 4) % 12;
        if (month < 2 || (month == 2 && day < 4)) {
            res = res -1;
        }
        return this.junishi[res];
    }

    private String nichiKnashi(int year,int month,int day){
        long timestamp = dateToTimestamp(year, month, day);
        String jikkan = getJikkanDay(timestamp);
        String jyunishi = getJunishiDay(timestamp);
        return jikkan + jyunishi;
    }

    private String gessho(int year,int month,int day){
        NijushiSekkiFactory factory = new NijushiSekkiFactory();
        Sekki sekki = factory.create((month * 2) - 1, year);
        int m = month;
        if (day < sekki.getDay()) {
            m = m -1;
        }
        int index = (13 - m) % 12;
        return this.junishi[index];
    }

    private String getJikkanDay(long timestamp){
        long day = timestamp/1000/3600/24;
        int index = (int)((day-2) % 10);
        return this.jikkan[index];
    }

    private String getJunishiDay(long timestamp){
        long day = timestamp/1000/3600/24;
        int index = (int)((day-6) % 12);
        return this.junishi[index];
    }

    private long dateToTimestamp(int year,int month,int day){
        // Calendarインスタンスを作成
        Calendar calendar = Calendar.getInstance();

        // 日本標準時 (JST) に設定
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));

        calendar.set(year, month - 1, day, 0, 0, 0); // 時間を00:00:00に設定
        calendar.set(Calendar.MILLISECOND, 0); // ミリ秒を0に設定

        // タイムスタンプ（ミリ秒単位）を取得
        long timestampInMillis = calendar.getTimeInMillis();
        return timestampInMillis;
    }
}
