import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/9/26 23:30
 * @Description:
 */

// 11.针对2.2.2节的设计1，编写完整的程序，输出一套题
// 思路：设计1将算式结构化，结构体内有左操作数、右操作数和操作符这三个元素，这里使用类来代替这个结构体
public class Demo11 {
    static Equation[] equations = new Equation[50];  //存储算式集合的数组
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
        int leftOperand = 0,rightOperand = 0,value = 0;
        char operator = '+';
        Equation equation = null;
        Random random = new Random();
        int ov = random.nextInt(2); // 0：加号； 1：减号

        for (int i = 0; i < 50; i++) {
            if(ov == 0) {
                operator = '+';
                do {
                    leftOperand = random.nextInt(101);
                    rightOperand = random.nextInt(101);
                    value = leftOperand + rightOperand;
                }while(value > 100);
            }else {
                operator = '-';
                do {
                    leftOperand = random.nextInt(101);
                    rightOperand = random.nextInt(101);
                    value = leftOperand - rightOperand;
                }while(value < 0);
            }
            ov = random.nextInt(2);
            equations[i] = equation = new Equation(leftOperand,rightOperand,operator);
            results[i] = value;
        };
    }

    /**
     * 打印题目
     */
    public static void printExercise(){
        for(int i = 0; i < equations.length; i++) {
            System.out.println(equations[i].toString());
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

// 使用面向对象的思维，将算式提取为一个类
class Equation {
    //左操作数
    public int leftOperand;
    //右操作数
    public int rightOperand;
    //操作符
    public char operator;

    public Equation() {
    }

    public Equation(int leftOperand, int rightOperand, char operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    /**
     * 重写toString方法来使用正确格式打印算式
     * @return
     */
    @Override
    public String toString() {
        return "" + leftOperand + operator + rightOperand + "=";
    }
}
