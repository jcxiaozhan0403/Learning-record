package com.day01;
/*
*多态：
*  继承
*   重写父类的方法
*   父类引用指向子类对象
*
*  编译看左边，运行看右边
*
* */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
* Collection 接口是 集合的顶层接口
*
*
* public boolean add(Object e)：把给定的对象添加到当前集合中
*
  public boolean contains(Object e)：判断当前集合中是否包含给定的对象
  *
  *
  public boolean remove(E e)：删除出现在集合中的第一个指定的元素-Removes the first occurrence of the specified element from this list
  *
 public int size()：返回集合中元素的个数
 *
 *

public boolean isEmpty()：判断当前集合是否为空
public void clear()：清空集合中所有的元素
*
*
* public Object[] toArray()：把集合中的元素，存储到数组中
*
* */
public class Test {
    public static void main(String[] args) {
        List  c1 = new ArrayList();
        c1.add("hello1");
        c1.add("hello2");
        c1.add("hello3");
        c1.add("hello4");
        c1.add("hello5"); // 添加元素到集合当中

      /*  boolean flag = c1.contains("hello6"); // true
      //  System.out.println(flag);


        boolean f1 = c1.remove("hello7"); // false
        System.out.println(f1);

        int size = c1.size(); // 5
        System.out.println(size);


        boolean empty = c1.isEmpty();
        System.out.println(empty);

        c1.clear();
        System.out.println("=========");
         size = c1.size(); // 5
        System.out.println(size);*/

        c1.add(2,"xxx"); // list 独特方法  0 1 2
        //
        System.out.println(c1);

        Object o = c1.get(4);

        System.out.println(o);

        c1.set(0,"xxxxx");
        System.out.println(c1);


    }
}
