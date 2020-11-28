package equals_;

public class Equals {
    public static void main(String[] args) {

        String str1 = "the light";

        String str2 = new String(str1);

        String str3 = str1.toUpperCase();

        //==用于判断是否是同一个字符串对象
        System.out.println( str1  ==  str2);

        System.out.println(str1.equals(str2));//完全一样返回true

        System.out.println(str1.equals(str3));//大小写不一样，返回false
        System.out.println(str1.equalsIgnoreCase(str3));//忽略大小写的比较，返回true
    }
}
