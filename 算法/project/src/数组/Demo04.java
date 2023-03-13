package 数组;

/**
 * @author John.Cena
 * @date 2023/3/13 14:29
 * @Description:
 */
public class Demo04 {
    /*
     * 长度最小的子数组
     * https://www.programmercarl.com/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.html#%E6%9A%B4%E5%8A%9B%E8%A7%A3%E6%B3%95
     *
     * 给定一个含有n个正整数的数组和一个正整数target。在数组中查找和大于等于target的连续子数组，要求子数组的长度最小
     */

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int i = new Demo04().minSubArrayLen(7, arr);
        int i1 = new Demo04().test(7, arr);
        System.out.println(i);
        System.out.println(i1);
    }

    //暴力解
    //思路：双重for，外层控制累加起始位置，内层控制算术累加，每次内层遍历完，外层又位置又+1
    //时间复杂度：O(n²)
    public int test(int target, int[] nums){
        //子数组长度
        int subLen = Integer.MAX_VALUE;
        //算数和
        int sum = 0;
        //外层循环，控制累加起始位置
        for (int i = 0; i < nums.length; i++) {
            //清空算术和
            sum = 0;
            //内层循环控制累加
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                //满足题目条件
                if (sum >= target) {
                    //当前子列长度
                    int subLength = j - i + 1;
                    subLen = Math.min(subLen,subLength);
                    //跳出内循环，继续进行下一个位置的累加判断
                    break;
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return subLen == Integer.MAX_VALUE ? 0 : subLen;
    }

    //双重指针，滑动窗口
    //思路：两个指针，构成窗口，在找到符合题目的子列后，逐步缩小窗口，最终返回最小长度
    //时间复杂度：O(n)
    public int minSubArrayLen(int target, int[] nums) {
        //用于记录算数和
        int sum = 0;
        //子数组长度，因为找的是最小长度，所以这里设置为最大值，在for里面进行改变
        int len = Integer.MAX_VALUE;
        //滑动窗口起始位置
        int left = 0;
        //遍历集合
        for(int right = 0;right < nums.length;right++){
            //累加
            sum += nums[right];
            //满足题目条件，进行记录
            //因为窗口要逐步向后移动，所以判断时使用while而不是if
            while(sum >= target){
                //获取当前子数组长度
                int subLen = right - left + 1;
                //获取最小长度
                len = Math.min(len,subLen);
                sum = sum - nums[left++];
            }
        }
        //如果没有找到，那么len会是初始值
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
