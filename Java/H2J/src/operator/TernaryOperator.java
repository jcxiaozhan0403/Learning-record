package operator;

public class TernaryOperator {
    public static void main(String[] args) {
        int i = 5;
        int j = 6;

        /*
        表达式?值1:值2
        如果表达式为真 返回值1
        如果表达式为假 返回值2
         */

        int k = i < j ? 99 : 88;

        // 相当于
        if (i < j) {
            k = 99;
        } else {
            k = 88;
        }

        System.out.println(k);
    }
}
