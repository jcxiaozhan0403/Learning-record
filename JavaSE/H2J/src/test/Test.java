package test;

/**
 * @author John.Cena
 * @date 2023/3/22 19:22
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ListNode list = new ListNode(11);

        list = new ListNode(22, list);

        ListNode last = list.findLast();

        System.out.println(last.toString());

    }
}
