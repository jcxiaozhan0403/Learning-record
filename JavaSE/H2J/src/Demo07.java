import java.util.Random;

/**
 * @author John.Cena
 * @date 2023/1/18 22:44
 * @Description:
 */
public class Demo07 {
    public static void main(String[] args) {
//        String password = getRandomPassword(3);
//        System.out.printf("密码是: %s%n", password);
//        // 穷举匹配密码
//        matchPassword(password);
        test();

    }

    private static void matchPassword(String password) {
        // 所有的可能性000-999
        for (int i = 0; i < 1000; i++) {
            String possiblePassword = String.format("%03d", i);
            System.out.println(possiblePassword);
            if (password.equals(possiblePassword)) {
                System.out.println("匹配到了密码,密码是:" + possiblePassword);
                break;
            }
        }

    }

    private static String getRandomPassword(int len) {

        String pool = "";
        for (int i = '0'; i <= '9' ; i++) {
            pool += ((char) i);
        }
        System.out.println(pool);
        // 生成长度为3的随机密码
        char[] chars = new char[len];
        // 填充字符数组
        Random random = new Random();
        for (int i = 0; i < chars.length; i++) {
            int index = random.nextInt(pool.length());
            chars[i] = pool.charAt(index);
        }
        String password = new String(chars);
        return password;
    }

    private static void test(){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
