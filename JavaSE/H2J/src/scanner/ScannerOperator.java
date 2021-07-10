package scanner;

import java.util.Scanner;

public class ScannerOperator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //使用Scanner读取整数
        int a = s.nextInt();
        System.out.println("第一个整数："+a);

        //使用Scanner读取浮点数
        float b = s.nextFloat();
        System.out.println("第二个整数："+b);

        //使用Scanner读取字符串
        String c = s.nextLine();
        System.out.println("读取的字符串是："+c);

        s.close(); //关闭，避免内存浪费
    }
}
