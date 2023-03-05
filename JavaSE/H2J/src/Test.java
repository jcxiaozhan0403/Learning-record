import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author John.Cena
 * @date 2023/3/5 20:27
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(51,451,62,36,84);

        List<Integer> collect1 = list.stream()
                //倒序排列
                .sorted()
                .collect(Collectors.toList());
        System.out.println("正序排列：" + collect1);

        List<Integer> collect2 = list.stream()
                //倒序排列
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("倒序排列：" + collect2);

        int max = list.stream()
                //获取最大值
                .max(Integer::compareTo)
                .get();
        System.out.println("最大值：" + max);

        int min = list.stream()
                //获取最大值
                .min(Integer::compareTo)
                .get();
        System.out.println("最小值：" + min);

        long count = list.stream().count();
        System.out.println("元素数量：" + count);
    }
}
