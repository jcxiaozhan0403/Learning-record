package 数组;

import java.util.Arrays;

/**
 * @author John.Cena
 * @date 2023/3/8 17:50
 * @Description:
 */
public class Demo03 {
    /*
     * 有序数组的平方
     * https://www.programmercarl.com/0977.%E6%9C%89%E5%BA%8F%E6%95%B0%E7%BB%84%E7%9A%84%E5%B9%B3%E6%96%B9.html
     *
     * 将数组中的数全部平方后，生成的新数组按照升序排列
     */

    public static void main(String[] args) {
        int arr[] = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(new Demo03().test2(arr)));
    }

    //暴力解：先平方，直接排序
    //时间复杂度： O(n + nlogn)
    public int[] test1(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    //双指针
    //思路：因为一个指针在头部，一个数组在尾部
    //时间复杂度：O(n)
    public int[] test2(int[] arr){
        int[] result = new int[arr.length];
        int k = arr.length - 1;
        for (int i = 0,j = arr.length-1; i <= j; ) {
            if (arr[i]*arr[i] < arr[j]*arr[j]){
                result[k--] = arr[j]*arr[j];
                j--;
            }else {
                result[k--] = arr[i]*arr[i];
                i++;
            }
        }
        return result;
    }
}
