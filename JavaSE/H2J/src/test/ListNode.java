package com.cn.linkedlist;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2023/3/22  9:15
 * @Version 1.0
 * @Param $
 * @return $
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


    private ListNode findLast() {
        ListNode p = this;
        if (p == null) {
            return null;
        }
        //p = head; //数据初始化
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public ListNode of(int[] value) {
        ListNode head = new ListNode();
        head.next = null;
        ListNode tmp = null;
        ListNode cur = head;
        //构造单链表
        for (int i = 0; i < value.length; i++) {
            tmp = new ListNode();
            tmp.val = value[i];
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
            //System.out.println(cur);
        }


        /*Node h = this.head.next; // 获取到哨兵节点的下个节点(除哨兵节点外的第一个节点)
         *//**
         * 设置哨兵节点的下个节点(头部节点)为新创建的节点， 将原先哨兵节点的下个节点设置为新节点的下个节点
         * 哨兵-> 0   哨兵-> 新-> 0
         *//*
        this.head.next = new Node(v, h);*/
        return head.next;
    }

    public ListNode addFirst(int value) {
        //2.链表不为空
        head = new ListNode(value, head);
        return head;

    }

    /*向后添加*/
    /*public ListNode addLast(int[] value) {
        //ListNode last = findLast();
        ListNode listNode;
        for (int elements : value) {
            if (last == null) {
                listNode = addFirst(elements);
                return listNode;
            }
            last.next = new ListNode(elements, null);
        }
        return last.next;
    }*/


}
