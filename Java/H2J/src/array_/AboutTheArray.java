package array_;

import java.util.Arrays;

public class AboutTheArray {
    public static void main(String[] args) {
        //声明数组的两种形式
                int a[];
        //      int []a;

        //指定数组长度
        a = new int[5];

        //声明并指定长度
        int b[] = new int [5];

        //声明并赋值
        //int b[] = new int []{1,2,3,4,5};
        //int b[] = {1,2,3,4,5};

        System.out.println(a.length); //输出数组长度

        //随机数组找最小值
        int c[] = new int [5];
        int min = 100;

        for(int i = 0;i<5;i++){
            c[i] = (int) (Math.random() * 100);

                if (c[i]<min){
                    min = c[i];
            }

        }
        System.out.println(Arrays.toString(c));
        System.out.println(min);
    }
}
