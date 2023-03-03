import java.util.Random;

/**
 * @author John.Cena
 * @date 2023/1/18 22:44
 * @Description:
 */
public class Demo07 {
    char[] levelTable = {'差', '中', '良', '优'};
    int[] scoreCeilTable = {60, 80, 90, 100};

    public static void main(String[] args) {
        char level = new Demo07().getLevel(70);
        System.out.println(level);

    }

    public char getLevel(int score){
        int len = scoreCeilTable.length;
        for (int i = 0; i < len; i++) {
            int scoreCeil = scoreCeilTable[i];
            if (score <= scoreCeil){
                return levelTable[i];
            }
        }

        return levelTable[len - 1];
    }
}
