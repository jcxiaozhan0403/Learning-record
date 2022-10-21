/**
 * @author John.Cena
 * @date 2022/10/21 7:59
 * @Description:
 */

import java.util.Random;
import java.util.Scanner;

public class Test7 {
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("请输入每行打印得算式个数：");
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        mainMethod(number);
    }
    public static void mainMethod ( int m){//主体方法
        for (int j = 0; j < 2; j++) {
            String[] formulas = new String[50];
            System.out.println("\n加法习题"+(j+1)+"：");
            for (int i = 0; i < 50; i++) {
                Formula formula;
                formula = addition();
                formulas[i] = formula.getLeft_op()+formula.getOperator()+formula.getRight_op();//将封装好的类存入数组
            }
            printSolution(formulas, m);//打印方法
        }
        for (int j = 0; j < 2; j++) {
            String[] formulas = new String[50];
            System.out.println("\n减法习题"+(j+1)+"：");
            for (int i = 0; i < 50; i++) {
                Formula formula;
                formula = subtraction();
                formulas[i] = formula.getLeft_op()+formula.getOperator()+formula.getRight_op();//将封装好的类存入数组
            }
            printSolution(formulas, m);//打印方法
        }
    }

    public static void printSolution(String[]formulas, int m){//打印方法

        for (int i = 0; i < formulas.length; i++) {
            if ((i + 1) % m == 0) {
                System.out.println((i + 1) + "、" + formulas[i]+"=");//输出并换行
            } else System.out.printf("%-20s",(i + 1) + "、" + formulas[i] + "=");//输出不换行
        }
    }
    public static Formula subtraction (){
        /**生成减法*/
        Formula formula = new Formula();
        formula.setOperator("-");
        formula.setLeft_op(random.nextInt(99) + 2);//随机生成范围是[2,101)的整数
        formula.setRight_op(random.nextInt(formula.getLeft_op() - 1) + 2);//随机生成范围[2,left_op-1)的整数
        return formula;
    }
    public static Formula addition (){
        /**生成加法*/
        Formula formula = new Formula();
        formula.setOperator("+");
        int value = random.nextInt(99) + 2;//随机生成范围[2,101)的整数， value为算式中最大的数
        formula.setLeft_op(random.nextInt(value - 1) + 2);//随机生成范围[2,value-1)的整数
        formula.setRight_op(value - formula.getLeft_op());
        return formula;
    }
    static class Formula {
        public static int left_op;//左边的操作数
        public static int right_op;//右边的操作数
        public static String operator;//运算符

        public Formula() {
        }

        public int getLeft_op() {
            return left_op;
        }

        public void setLeft_op(int left_op) {
            this.left_op = left_op;
        }

        public int getRight_op() {
            return right_op;
        }

        public void setRight_op(int right_op) {
            this.right_op = right_op;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }
    }
}

