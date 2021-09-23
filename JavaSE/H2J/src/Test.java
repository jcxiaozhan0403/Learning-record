import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(5);
        list.add(12);
        list.add(30);
        list.add(6);

        // sort排序(由小到大)
        System.out.println("排序前：" + list.toString());
        Collections.sort(list);
        System.out.println("排序后：" + list.toString());

        // binarySearch二分查找
        int i = Collections.binarySearch(list,12);
        System.out.println(i);

        // copy复制
        List<Integer> dest = new ArrayList<>();
        for (int k = 0;k < list.size();i++) {
            dest.add(0);
        }
        Collections.copy(dest,list);
        System.out.println(dest.toString());

        // reverse反转
        Collections.reverse(list);
        System.out.println("反转后：" + list);

        // shuffle 打乱
        Collections.shuffle(list);
        System.out.println("打乱后：" + list);

        // list转数组,如果数组大小小于集合大小，则会直接存入，如果数组大小大于集合大小，多余部分会用默认值填充
        Integer[] arr = list.toArray(new Integer[10]);
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));

        // 数组转集合
        String[] names = {"张三","李四","王五"};
        // 得到的是一个受限集合，不能增删
        List<String> list2 = Arrays.asList(names);
        System.out.println(list2);
    }
}
