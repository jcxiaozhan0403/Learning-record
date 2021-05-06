package com.example.demo;

public class BMI {
    public static String bmi(double weight,double height) {
        double BMI = weight/(height*height);
        String str = null;

        if (BMI>=0 && BMI<18.5) {
            str = "偏瘦";
        }else if (BMI>=18.5 && BMI<24) {
            str = "正常";
        }else if (BMI>=24 && BMI<28) {
            str = "偏胖";
        }else if (BMI>=28) {
            str = "肥胖";
        }

        return str;
    }
}
