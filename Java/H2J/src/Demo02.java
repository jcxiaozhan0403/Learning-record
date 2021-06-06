import java.util.Scanner;
public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            char[] array = String.valueOf(i).toCharArray();
            int flag = 1;

            for (char j : array) {
                if (j == '2') {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}