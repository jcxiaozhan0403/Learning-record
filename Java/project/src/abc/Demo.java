package abc;

import java.util.Scanner;//表示导入Scanner这个类

public class Demo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);//创建Scanner对象
        int a = s.nextInt();//获取整数
        System.out.println("第一个整数："+a);
        int b = s.nextInt();
        System.out.println("第二个整数："+b);
    }
}
