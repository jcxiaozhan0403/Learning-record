import java.lang.reflect.Array;

public class Demo{
    public static void main(String[] args) {
        int count = 0;

        for(int i = 2;i<10000000;i++){

            boolean result = true;
            for (int j = 2;j<Math.sqrt(i);j++){
                if (i % j == 0){
                    result = false;
                    break;
                }
            }
            if (result){
                count++;
            }
        }


        System.out.println("一共有"+count+"个质数");
    }
}
