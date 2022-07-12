import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(5);
        list.add(12);
        list.add(30);
        list.add(6);

        System.out.println("原集合" + list.toString());

        // list转数组,如果数组大小小于集合大小，则会直接存入，如果数组大小大于集合大小，多余部分会用默认值填充
        Integer[] arr = list.toArray(new Integer[4]);
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));

        // 数组转集合
        String[] names = {"张三","李四","王五"};
        // 得到的是一个受限集合，不能增删
        List<String> list2 = Arrays.asList(names);
        System.out.println(list2);
    }
}