package com.day01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * Map 是一个接口
 *
 * 存值 有一个特性  key ---value 。  存入，
 *
 * 取值 也是根据key 取值
 *
 *
 *  11----张三
 * 22 ---- 李四
 *
 *
 * */
/*
* V put(K key,V value)
V get(Object key)
*
*
V remove(Object key)
*
*
void clear()
int size() // 返回key value 的个数
*
*
boolean containsKey(Object key)
*
*
boolean containsValue(Object value)
*
*
*
boolean isEmpty()
*
*
Set<K> keySet()
Collection<V> values()
Set<Map.Entry<K,V>> entrySet()

*
* */
public class Test03 {
    public static void main(String[] args) {
/*        Map m1 = new HashMap();
        // 往m1 容器中存法元素
        m1.put(11,"张三");
        m1.put(22,"李四");

        // 从m1 容器中取值
        String s1 =(String) m1.get(11); // "张三"
        String s2 =(String) m1.get(22); // ""李四""
        System.out.println(s1);
        System.out.println(s2);*/
        Map<Integer,String> m1 = new HashMap();
        // m1.put("dd",11);
        m1.put(11,"张三");
        m1.put(22,"李四");

        String s1 = m1.get(11);
        String s2 = m1.get(22);

        System.out.println(s1);
        System.out.println(s2);

        String rm = m1.remove(333);// 如果没有333 这个key ，返回就是null ，有333 这个key，返回值就是333 对应value 值
        System.out.println(rm);

        System.out.println("m1.size()"+m1.size());


        //boolean containsKey(Object key) // 判断map 容器中，是否包含某个key 值
        boolean flag = m1.containsKey(222); // true
        System.out.println("m1.containsKey"+flag);

        //boolean containsValue(Object value)// 判断map 容器中，是否包含某个value值
        boolean b = m1.containsValue("张三");

        System.out.println(b);


    }
}
