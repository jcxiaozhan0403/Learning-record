/**
 * @author John.Cena
 * @date 2022/6/22 15:24
 * @Description:
 */
public class Son{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // append()追加
        sb.append("Hello World");
        System.out.println(sb);

        // delete()删除
        sb.delete(0,3);
        System.out.println(sb);
    }
}