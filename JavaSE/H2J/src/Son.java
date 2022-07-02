/**
 * @author John.Cena
 * @date 2022/6/22 15:24
 * @Description:
 */
public class Son{
    private String name;
    public static void main(String[] args) {
        Integer integer1 = Integer.valueOf(100);
        Integer integer2 = Integer.valueOf(100);
        System.out.println(integer1 == integer2);

        Integer integer3 = Integer.valueOf(200);
        Integer integer4 = Integer.valueOf(200);
        System.out.println(integer3 == integer4);
    }
}