package test5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author John.Cena
 * @date 2022/12/22 15:13
 * @Description:
 */
public class IVRProgram {
    //初始化数组
    static int[] arr = {2,5,7,6,3,8,1,9};


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=====================");
            System.out.println("1. 插入数据");
            System.out.println("2. 删除数据");
            System.out.println("3. 修改数据");
            System.out.println("4. 显示数据");
            System.out.println("5. 求表长");
            System.out.println("6. 退出程序");
            System.out.println("=====================");
            System.out.print("请选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    select();
                    break;
                case 5:
                    length();
                    break;
                case 6:
                    System.out.println("退出程序");
                    return;
            }
        }
    }

    // 插入数据
    static void add() {
        System.out.println("请输入新数据：");
        Scanner scanner = new Scanner(System.in);

        //数组copy
        arr = Arrays.copyOf(arr,arr.length+1);

    }

    // 删除数据
    static void delete() {

    }

    // 修改数据
    static void update() {
        System.out.println("请输入需要替换的数组下标位置以及替换元素：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
    }

    // 显示数据
    static void select() {
        System.out.print("当前数组：");
        System.out.println(Arrays.toString(arr));
    }

    // 求表长
    static void length() {
        System.out.println(arr.length);
    }
}

