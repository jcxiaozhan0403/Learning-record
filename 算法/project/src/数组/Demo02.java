package 数组;

/**
 * @author John.Cena
 * @date 2023/3/8 17:46
 * @Description:
 */
public class Demo02 {
    /*
     * 移除数组
     * https://www.programmercarl.com/0027.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0.html
     *
     * 移除数组中的所有指定元素，要求只用一个源数组完成
     */
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,0,4,2};

        System.out.println(new Demo02().test1(arr, 2));
        //System.out.println(new Demo().test2(arr, 2));
    }

    //暴力解法：双重for循环
    //思路：外层循环找到目标值，内层循环处理目标值
    //时间复杂度：复杂度O(n²)
    public int test1(int arr[],int val){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == val){
                //将数组每一位依次向前移动一位
                for (int j = i+1; j < length; j++) {
                    arr[j-1] = arr[j];
                }
                //因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                i--;
                //减少遍历次数，同时也作为修改后的数组长度返回
                length--;
            }
        }
        return length;
    }

    //双指针
    //思路：快指针查找不是目标值的元素，赋值给慢指针，慢指针做的是创建新数组的工作
    //时间复杂度：复杂度O(n)
    public int test2(int arr[],int val){
        int fast;
        int snow = 0;
        for (fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != val){
                //赋值
                //慢指针下标+1
                arr[snow++] = arr[fast];
            }
        }
        return snow;
    }
}
