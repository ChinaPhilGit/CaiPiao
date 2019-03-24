package com.phil.colson.CaiPiao.data;

import java.util.Date;

public class RandomFactory {


    public static Integer generateNumber() {
//        Double slat = 188.2%10;
        Double random = ((Math.random() * 9 + 1) * 100000)%10;
//        Long dateTimeLong = dateTime.getTime()%10;
//        Double result = slat * dateTimeLong + random * dateTimeLong;
        return random.intValue();
    }

    public static void main(String[] args) {
        Runnable run = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(generateNumber());
            }
        };
        run.run();
    }
}
