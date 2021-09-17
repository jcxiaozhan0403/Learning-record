import java.util.Scanner;


public class Demo02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);



        System.out.println("请输入字符串（nextLine）：");//曹老板很有钱
        String str1 = input.nextLine();
        System.out.println(str1);

        System.out.println("请输入字符串（next）：");
        String str = input.next();
        System.out.println(str);
    }
}