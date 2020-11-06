package randomNumber;

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        //法一
        Random x = new Random();

        for (int i = 0;i<5;i++){
            System.out.println("法一" + x.nextInt(100));
        }

        //法二,而第二种方法返回的数值是[0.0,1.0）的double型数值
        int a[] = new int[5];
        for(int i = 0;i<5;i++){
            a[i] = (int) (Math.random()*100);
            System.out.println("法二" + a[i]);
        }
    }
}
