package com.day01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* Collection  接口
* List
*  list 接口的特性1，存进去的顺序，跟遍历时相同。
*    特性2 ： 可以存相同的元素
*    list 有两个实现类： 一个ArrayList   数组集合。底层存储数据的数据结构是数组
*                          LinkedList    底层存储数据的方式是链表。
*
* Set  特性1： 存进去的顺序，跟遍历时书序不同，
*      特性 ： 不可以存相同的元素
* */
public class Test02 {
    public static void main(String[] args) {
        List c1 = new ArrayList(); // c1 能够装载数据
        c1.add("11");
        c1.add("11");
        c1.add("22");
        c1.add("33");

        // 取
        Object o = c1.get(2);


        // 如果说要遍历集合中的元素？
        System.out.println(c1);



        Iterator it1 = c1.iterator();
        while (it1.hasNext()){
            Object next = it1.next();
        }

        // 集合中遍历元素，要通过迭代器

        // 1. 得到迭代器
    /*

        // 2. 利用迭代器的next() 取得元素
        Object o1 = it1.next(); // 获取的是第一个元素  11

        System.out.println(o1);

        Object o2 = it1.next(); //

        Object next = it1.next();

         next = it1.next();*/


       //  it1.hasNext() // 判断迭代器往下指还有没有值，有值返回true，没有返回false。





    }
}
