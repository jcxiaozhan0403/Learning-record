package string_;

public class TheString {
    public static void main(String[] args) {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";

        //用下标获取字符串对应字符
        char c = sentence.charAt(0);

        //获取对应的字符数组
        char[] cs = sentence.toCharArray();

        //截取从第3个开始的字符串 （基0）
        String subString1 = sentence.substring(3);

        //截取从第3个开始的字符串 （基0）
        //到5-1的位置的字符串
        //左闭右开
        String subString2 = sentence.substring(3,5);

        //根据,进行分割，得到3个子字符串
        String subSentences[] = sentence.split(",");
        for (String sub : subSentences) {
            System.out.println(sub);
        }

        //去掉首尾空格
        System.out.println(sentence.trim());

        //全部变成小写
        System.out.println(sentence.toLowerCase());
        //全部变成大写
        System.out.println(sentence.toUpperCase());

        //字符串定位
        System.out.println(sentence.indexOf('8')); //字符第一次出现的位置

        System.out.println(sentence.indexOf("超神")); //字符串第一次出现的位置

        System.out.println(sentence.lastIndexOf("了")); //字符串最后出现的位置

        System.out.println(sentence.indexOf(',',5)); //从位置5开始，出现的第一次,的位置

        System.out.println(sentence.contains("击杀")); //是否包含字符串"击杀"

        String str1 = "the light";

        String start = "the";
        String end = "Ight";

        System.out.println(str1.startsWith(start));//以...开始
        System.out.println(str1.endsWith(end));//以...结束

        System.out.println(c);
    }
}
