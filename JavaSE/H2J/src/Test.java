import java.util.*;

public class Test {
    public static void main(String[] args) {
        // 创建集合
        List list = new ArrayList<>();

        // 添加元素
        list.add("苹果");
        list.add("梨子");
        list.add("香蕉");

        // 删除元素
        list.remove("梨子");
        // 使用索引删除
        list.remove(0);

        // 遍历
        // 使用for循环
        for (int i= 0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 使用增强for循环
        for(Object obj : list) {
            System.out.println(obj);
        }
        // 使用迭代器遍历
        //remove(); 删除当前元素
        Iterator it = list.iterator();
        //haNext(); 判断有没有下一个元素
        while(it.hasNext()){
            //next(); 获取元素
            Object obj = it.next();
            //移除当前元素
            // list.remove()会报并发修改异常
            it.remove();
        }
        // 使用列表迭代器，列表迭代器可以从前向后遍历，也可以从后向前遍历
        // 创建迭代器
        // 从前向后遍历
        ListIterator it1 = list.listIterator();
        while(it1.hasNext()){
            System.out.println();
        }
        // 从后向前遍历(因为是同一个迭代器，在上一次遍历之后，迭代器已经指向了集合末尾，所以这里可以直接开始向前遍历)
        while(it1.hasNext()){
            System.out.println();
        }

        // 获取元素出现位置
        System.out.println(list.indexOf("香蕉"));

        // List集合添加整数元素(自动装箱)
        list.add(10);
        list.add(20);

        // 删除List中的整数元素
        list.remove(list.indexOf(10));

        // 返回子集合，取头不取尾
        List subList = list.subList(0,2);
    }
}
