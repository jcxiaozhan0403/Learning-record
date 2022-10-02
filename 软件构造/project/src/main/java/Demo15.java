import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/9/27 17:37
 * @Description:
 */
// 15.使用结构化编程完成任务2的程序，分别为加法、减法输出两套练习题，完成测试
public class Demo15 {
    static String[] equs = new String[50];   //存储算式集合的数组
    static int[] results = new int[50];  // 存储计算结果的数组

    public static void main(String[] args) {
        System.out.println("==============加法练习：第一套=============");
        totlePrint(0);
        System.out.println("==============加法练习：第二套=============");
        totlePrint(0);
        System.out.println("==============减法练习：第一套=============");
        totlePrint(1);
        System.out.println("==============减法练习：第一套=============");
        totlePrint(1);
    }

    /**
     * 总输出
     * @param addOrSub 判断生成加法还是减法，0：加法 1：减法
     */
    public static void totlePrint(int addOrSub){
        if (addOrSub == 0){
            generateEquationsAdd();
            printExercise();
            printCalculations();
        }else if (addOrSub == 1){
            generateEquationsSub();
            printExercise();
            printCalculations();
        }
    }

    /**
     * 生成加减法习题集
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
     * 生成加法习题集
     */
    public static void generateEquationsAdd(){
        int m = 0, n = 0, value = 0;
        char o = '+';
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            do {
                m = random.nextInt(101);
                n = random.nextInt(101);
                value = m + n;
            }while(value > 100);

            equs[i] = "" + m + o + n + " = ";
            results[i] = value;
        };
    }

    /**
     * 生成减法习题集
     */
    public static void generateEquationsSub(){
        int m = 0, n = 0, value = 0;
        char o = '-';
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            do {
                m = random.nextInt(101);
                n = random.nextInt(101);
                value = m - n;
            }while(value < 0);

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
