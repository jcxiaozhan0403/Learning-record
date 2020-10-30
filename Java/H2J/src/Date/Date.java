package Date;

public class Date {
    public static void main(String[] args) {
        //整型
        byte b = 1;
        short s = 200;
        int i = 300;
        long l = 400;

        //字符型
        char c = '中';

        //浮点型
        double d = 123.45;
        float f2 = 54.321f;

        //布尔型,实际是以0和1的形式存于内存中，赋值只能用true和false
        boolean b1 = true;
        boolean b2 = false;

        //字符串
        String str = "Hello Java";

        //整型字面值
        long val = 26L; //以L结尾的字面值表示long型
        int decVal = 26; //默认就是int型
        int hexVal = 0x1a; //16进制
        int oxVal = 032; //8进制
        int binVal = 0b11010; //2进制

        //浮点数字面值
        float f1 = 123.4F;// 以F结尾的字面值表示float类型
        double d1 = 123.4;// 默认就是double类型
        double d2 = 1.234e2;// 科学计数法表示double

        //字符字面值
        String name = "盖伦";
        char a= 'c';

        //以下是转义字符
        char tab = '\t'; //制表符
        char carriageReturn = '\r'; //回车
        char newLine = '\n'; //换行
        char doubleQuote = '\"'; //双引号
        char singleQuote = '\''; //单引号
        char backslash = '\\'; //反斜杠
    }
}
