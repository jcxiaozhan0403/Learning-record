import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/9/26 23:07
 * @Description:
 */

// 10.完成代码2.2的编写，并输出一套50道100以内的加减法口算习题
// 思路：代码2.2，使用结构化编程，将重复的代码片段进行提取封装
public class Demo10 {
    static String[] equs = new String[50];   //存储算式集合的数组
    static int[] results = new int[50];  // 存储计算结果的数组

    public static void main(String[] args) {
        printHeader();
        generateEquations();
        printExercise();
        printCalculations();
    }

    /**
     * 打印提示信息
     */
    public static void printHeader(){
        System.out.println("-------------------------------------");
        System.out.println("- 程序输出50道100以内的加减法算式的习题 -");
        System.out.println("- 每次运行程序可以得到一套50道题的习题及答案 -");
        System.out.println("-------------------------------------");
    }

    /**
     * 生成题目
     */
    public static void generateEquations(){
        int m = 0, n = 0, value = 0;
        char o = '+';
        Random random = new Random();
        int ov = random.nextInt(2); // 0：加号； 1：减号
        for (int i = 0; i < 50; i++) {
            if(ov == 0) {
                o = '+';
                do {
                    m = random.nextInt(101);
                    n = random.nextInt(101);
                    value = m + n;
                }while(value > 100);
            }else {
                o = '-';
                do {
                    m = random.nextInt(101);
                    n = random.nextInt(101);
                    value = m - n;
                }while(value < 0);
            }
            ov = random.nextInt(2);
            equs[i] = "" + m + o + n + " = ";
            results[i] = value;
        };
    }

    /**
     * 打印题目
     */
    public static void printExercise(){
        for(int i = 0; i < equs.length; i++) {
            System.out.println((i+1) + ":\t" + equs[i]);
        }
    }

    /**
     * 打印答案
     */
    public static void printCalculations(){
        System.out.println("\n-----以下是习题的答案-------");
        for(int i = 0; i < results.length; i++) {
            System.out.println((i+1) + ":\t" + results[i]);
        }
    }
}
