package controlProcess;

import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        boolean x = true;
        int day = 5;

        if(x){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        jisuan();

        //switch可以使用byte,short,int,char,String,enum
        switch(day){
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期天");
                break;
            default:
                System.out.println("这个是什么鬼？");
        }
    }

    public static void jisuan(){
        Scanner a = new Scanner(System.in);
        System.out.print("请输入你的身高(m)：");
        float height = a.nextFloat();

        Scanner b = new Scanner(System.in);
        System.out.print("请输入体重(kg)：");
        float weight = b.nextFloat();

        float bmi = weight/(height*height);

        if(bmi<18.5){
            System.out.println("体重过轻");
            jisuan();
        }else if(bmi>=18.5 && bmi<24){
            System.out.println("正常范围");
            jisuan();
        }else if(bmi>=24 && bmi<27){
            System.out.println("体重过重");
            jisuan();
        }else if(bmi>=27 && bmi<30){
            System.out.println("轻度肥胖");
            jisuan();
        }else if(bmi>=30 && bmi<35){
            System.out.println("中度肥胖");
            jisuan();
        }else if(bmi>=35){
            System.out.println("重度肥胖");
            jisuan();
        }
    }
}