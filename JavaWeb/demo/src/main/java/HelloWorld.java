import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author John.Cena
 * @date 2022/8/9 18:38
 * @Description:
 */
public class HelloWorld {
    public static void main(String[] args) {
        int year = 2020;

        //直接打印数字
        System.out.format("%d",year);
        //总长度是8,默认右对齐
        System.out.format("%8d%n",year);
        //总长度是8,左对齐
        System.out.format("%-8d%n",year);
        //总长度是8,不够补0
        System.out.format("%08d%n",year);
        //千位分隔符
        System.out.format("%,8d%n",year*10000);

        //小数点位数
        System.out.format("%.2f%n",Math.PI);

        //不同国家的千位分隔符
        System.out.format(Locale.FRANCE,"%,.2f%n",Math.PI*10000);
        System.out.format(Locale.US,"%,.2f%n",Math.PI*10000);
        System.out.format(Locale.UK,"%,.2f%n",Math.PI*10000);
    }
}