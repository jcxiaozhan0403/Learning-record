import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/9/27 17:31
 * @Description:
 */

// 14.用结构化编程完成任务1的程序，输出两套习题
// 思路：将重复代码片段进行提取和封装
public class Demo14 {
    static String[] equs = new String[50];   //存储算式集合的数组
    static int[] results = new int[50];  // 存储计算结果的数组

    public static void main(String[] args) {
        System.out.println("======================第一套习题==============");
        totlePrint();
        System.out.println("======================第二套习题==============");
        totlePrint();
    }

    /**
     * 总输出
     */
    public static void totlePrint(){
        //生成题目
        generateEquations();
        //打印习题集
        printExercise();
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
