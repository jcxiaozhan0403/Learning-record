package test;

/**
 * @author John.Cena
 * @date 2023/3/22 19:09
 * @Description:
 */
//LeetCode很多链表题目中用到的节点类
public class ListNode {
    public int val;
    public ListNode next;
    private ListNode head;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("[");
        ListNode p = this;
        while (p != null) {
            stringBuilder.append(p.val);
            if (p.next != null) {
                stringBuilder.append(",");

            }
            p = p.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    public ListNode findLast() {
        if (head == null) {
            return null;
        }

        ListNode p;
        p = head; //数据初始化
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public ListNode of(int[] value) {
        int length = value.length;
        head = new ListNode(-1, null);
        ListNode temp = head;  //中间临时节点
        ListNode endNode = null;

        ListNode s;


        for (int i = 0; i < length-1; i++) {
            endNode = new ListNode(value[i+1]);
            s = new ListNode(value[i],endNode);
            System.out.println(s+" "+s.next);
            temp.next = s;
            temp = temp.next;
        }
        temp.next = null;
        return temp;




        /*Node h = this.head.next; // 获取到哨兵节点的下个节点(除哨兵节点外的第一个节点)
         *//**
         * 设置哨兵节点的下个节点(头部节点)为新创建的节点， 将原先哨兵节点的下个节点设置为新节点的下个节点
         * 哨兵-> 0   哨兵-> 新-> 0
         *//*
        this.head.next = new Node(v, h);*/
    }

    public ListNode addFirst(int value) {
        //2.链表不为空
        head = new ListNode(value, head);
        return head;

    }

    /*向后添加*/
    public ListNode addLast(int[] value) {
        ListNode last = findLast();
        for (int elements : value) {
            if (last == null) {
                addFirst(elements);
            }
            last.next = new ListNode(elements, null);
        }
        return last.next;

    }

    public ListNode toLinked(int [] arr){
        //进入创建一个tem节点
        ListNode tmp = new ListNode(-1);

        //循环
        for (int i = 0; i < arr.length; i++) {
            ListNode old = new ListNode(arr[i]);

        }

        //返回

        return null;
    }
}

