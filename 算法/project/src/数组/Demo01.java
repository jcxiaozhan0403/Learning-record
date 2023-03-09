package 数组;

/**
 * @author John.Cena
 * @date 2023/3/8 17:30
 * @Description:
 */
public class Demo01 {
    /*
     * 二分查找
     * https://www.programmercarl.com/0704.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.html
     *
     * 查找数组中的指定元素
     *
     * 前提：二分查找有两个要求，一个是数列有序（一般为升序排列），另一个是数列使用顺序存储结构（比如数组）
     * 思路：最开始以整个数组为区间，找到区间的中间元素，与目标元素进行比对。根据对比结果调整区间边界，再次找到区间的中间元素，与目标元素进行比对，如此循环，直至找到目标元素为止。
     * 时间复杂度：O(logN)
     */
    public static void main(String[] args) {

    }

    //解一：
    //[left,right]
    public int test1(int[] nums, int target) {
        //避免当target小于nums[0]或大于nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        //因为右区间闭合，所以这里需要以数组最后一个下标值作为右边界
        int left = 0, right = nums.length - 1;
        //因为左右区间都闭合，left = right是有意义的，所以这里使用 <= 符号
        while (left <= right) {
            //此写法等同于(left+right)/2得到中间值，这里防止内存溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                //目标值位于中间值右边，所以调整区间左边界，因为左区间闭合，所以调整左边界为mid+1
                left = mid + 1;
            else if (nums[mid] > target)
                //目标值位于中间值左边，所以调整区间右边界，因为右区间闭合，所以调整右边界为mid+1
                right = mid - 1;
        }
        return -1;
    }

    //解二：
    //[left,right)
    public int test2(int[] nums, int target) {
        //因为右区间开放，所以这里直接以数组长度作为右边界
        int left = 0, right = nums.length;
        while (left < right) {
            //求取中间坐标，同左闭右闭
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                //目标值位于中间值右边，所以调整区间左边界，因为左区间闭合，所以调整左边界为mid+1
                left = mid + 1;
            else if (nums[mid] > target)
                //目标值位于中间值左边，所以调整区间右边界，因为右区间开放，所以调整右边界为mid
                right = mid;
        }
        return -1;
    }
}
