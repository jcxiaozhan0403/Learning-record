import java.util.Arrays;

import static java.lang.System.arraycopy;

public class Demo {
    public static void main(String[] args) {
        int a[][] = new int[5][8];
        int b[] = new int[40];

        for (int i = 0;i<5;i++){
            for (int j = 0;j<8;j++){
                a[i][j] = (int) (Math.random()*100);
            }
        }

        arraycopy(a, 0, b, 0, 40);
        Arrays.sort(b);
        arraycopy(b, 0, a, 0, 40);

        for (int j = 0 ;j<5;j++){
            for(int i = 0;i<8;i++){
                System.out.print(a[j][i] + "\t");
            }
        }
    }
}