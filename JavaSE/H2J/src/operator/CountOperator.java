package operator;

public class CountOperator {
    int a = 5;
    long b = 6;

    //如果有任何运算单元的长度超过int,那么运算结果就按照最长的长度计算
    //a+b的运算结果是long型，所以要进行强制转换
    int c = (int) (a+b);
    long d = a+b;

    byte e = 1;
    byte f= 2;

    //如果任何运算单元的长度都不超过int,那么运算结果就按照int来计算
    //虽然e f都是byte类型，但是运算结果是int类型，需要进行强制转换
    byte g = (byte) (e+f);
    int h = e+f;
}
