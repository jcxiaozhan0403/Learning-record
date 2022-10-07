import junit.framework.TestCase;

import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/9/29 11:36
 * @Description:
 */
// 15题测试程序
public class Demo15Test extends TestCase {
    public static void main(String[] args) {

    }

    static String[] equs = new String[50];   //存储算式集合的数组
    static int[] results = new int[50];  // 存储计算结果的数组

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
     * 生成加法算式测试
     */
    void generateEquationsAddTester(){
        //判断
        boolean equal;
        //测试数据
        String[] testData = new String[10];
        //期望数据
        String[] expected = new String[10];
        //通过测试、测试失败、未执行测试
        int succeed=0,failed=0,executed=0;


    }
}