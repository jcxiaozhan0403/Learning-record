import java.util.HashSet;
import java.util.Iterator;

public class Test01 {
    public static void main(String[] args) {
        // 创建集合
        HashSet<String> hashSet = new HashSet<String>();

        // 添加元素
        hashSet.add("苹果");
        hashSet.add("梨子");
        hashSet.add("香蕉");

        // 删除元素
        hashSet.remove("梨子");

        // 遍历
        // 使用增强for循环
        for(Object obj : hashSet) {
            System.out.println(obj);
        }
        // 使用迭代器遍历
        //remove(); 删除当前元素
        Iterator it = hashSet.iterator();
        //haNext(); 判断有没有下一个元素
        while(it.hasNext()){
            //next(); 获取元素
            System.out.println(it.next());
            //移除当前元素
            // list.remove()会报并发修改异常
            it.remove();
        }

        System.out.println(hashSet.toString());
    }
}
