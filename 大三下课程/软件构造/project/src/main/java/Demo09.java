import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/9/26 22:51
 * @Description:
 */

// 9.按照任务一的设计和输出，完成程序编写，输出加法练习和减法练习各两套
// 思路：任务一使用非结构化编程，代码冗余度高
public class Demo09 {
    public static void main(String[] args) {
        int m = 0, n = 0, value = 0;
        char o = '+';
        Random random = new Random();

        System.out.println("==============加法练习：第一套=============");
        for (int i = 0; i < 50; i++) {
            do {
                m = random.nextInt(101);
                n = random.nextInt(101);
                value = m + n;
            }while(value > 100);
            System.out.println((i+1) + ":\t" + m + o + n + "= ");
        }

        System.out.println("==============加法练习：第二套=============");
        for (int i = 0; i < 50; i++) {
            do {
                m = random.nextInt(101);
                n = random.nextInt(101);
                value = m + n;
            }while(value > 100);
            System.out.println((i+1) + ":\t" + m + o + n + "= ");
        }
        o = '-';
        System.out.println("==============减法：第一套=============");
        for (int i = 0; i < 50; i++) {
            do {
                m = random.nextInt(101);
                n = random.nextInt(101);
                value = m - n;
            }while(value < 0);
            System.out.println((i+1) + ":\t" + m + o + n + "= ");
        }

        System.out.println("==============减法练习：第二套=============");
        for (int i = 0; i < 50; i++) {
            do {
                m = random.nextInt(101);
                n = random.nextInt(101);
                value = m - n;
            }while(value < 0);
            System.out.println((i+1) + ":\t" + m + o + n + "= ");
        }
    }
}
