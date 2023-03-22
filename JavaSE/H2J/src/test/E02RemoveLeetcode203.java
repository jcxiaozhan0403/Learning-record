package test;

/**
 * @author John.Cena
 * @date 2023/3/22 19:08
 * @Description:
 */
public class E02RemoveLeetcode203 {
    private ListNode head = new ListNode(-1,null);
    //方法1
    public ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode(-1, head);//哨兵节点，初始化
        ListNode p1 = listNode;
        ListNode p2 = listNode.next;
        while (p2 != null) {
            if (p2.val == val) {
                //删除，p2向后平移
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                // p1，p2同时向后平移
                p1 = p1.next;
                p2 = p2.next;

            }
        }
        return listNode.next;
    }

    //方法2
    public ListNode removeElements2(ListNode p,int val){
        if( p == null){
            return null;
        }
        if(p.val == val){
            return removeElements2(p.next,val);
        }else {
            p.next = removeElements2(p.next,val);
            return p;
        }
    }

    //方法3根据值递归删除对应的节点
    public void removeNthFromEnd(ListNode head,int n){
        return;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(-1,null);
        int[] array = new int[]{1,2,3,4,5};
        ListNode of = head.of(array);
        System.out.println(of);
        //System.out.println(head.addLast(array));

        //System.out.println(new E02RemoveLeetcode203().removeElements(of, 5));

    }
}
