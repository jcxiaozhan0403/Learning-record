import java.util.regex.Pattern;

/**
 * @author John.Cena
 * @date 2023/3/1 11:11
 * @Description:
 */
public class Demo {
    public static void main(String []args) {
        boolean a = Pattern.matches("[A-Z]*\\+[0-9]+", "98");
        System.out.println(a);
    }

    public String getLevel(float score){
        String levelTable[] = {"差","一般","中","良","优"};
        int[] scoreTable = {60,70,80,90,100};

        int len = scoreTable.length;
        for(int i = 0; i < len; i++) {
            int scoreCeil = scoreTable[i];
            if(score <= scoreCeil) {
                return levelTable[i];
            }
        }
        return levelTable[len-1];
    }

    int[] categoryValues = {0,3,2,2,1,2,1,1};
    public int getCategory(int a, int b, int c){
        int key = ((a&1)<<2)||((b&1)<<1)||(c&1));
        return categoryValues[key];
    }

}
