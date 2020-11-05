package array_;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        //选择法排序
        //第一步： 把第一位和其他所有位进行比较
        //如果发现其他位置的数据比第一位小，就进行交换
        int a [] = new int[]{18,62,68,82,65,9};

        for (int j = 0; j < a.length-1; j++) {
            for (int i = j+1; i < a.length; i++) {
                if(a[i]<a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));


    }
}
