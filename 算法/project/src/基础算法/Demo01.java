package 基础算法;

/**
 * @author John.Cena
 * @date 2023/3/27 19:55
 * @Description: 二分查找算法：在有序数组中快速查找目标值
 * 时间复杂度O(logN)
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,9,11,55,76};
        System.out.println(Demo01.test1(nums, 4));
        System.out.println(Demo01.test1(nums, 4));
    }

    //思路一：
    //1.使用两个指针，指针a指向数组首元素位置，指针b指向数组末尾元素位置
    //2.(a+b)/2得到中间位置(向下取整)，查看此位置的元素是否为目标值，如果为目标值就返回
    //3.不为目标值的话，缩小指针范围，继续查找
    //4.缩小规则：目标值 < 当前值，令 b = m-1; 因为m位置在第一次查找时就查找过了，所以不需要再继续包含它
    //          目标值 > 当前值，令 a = m+1;
    //5.当b <= a时，查找结束
    public static int test1(int[] nums, int target) {
        //判断查找元素是否在数组内
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        //定义两个指针
        int first = 0,last = nums.length - 1;
        //当first与last相等时，也需要比较
        while (first <= last){
            //防止内存溢出，等价于(first+last)/2
            int middle = (first + last) >>> 1;
            if (nums[middle] == target){
                return middle;
            }else if (target < nums[middle]){
                last = middle - 1;
            }else {
                first = middle + 1;
            }
        }
        return -1;
    }

    //思路二：
    //1.使用两个指针，指针a指向数组首元素位置，指针b指向数组末尾元素位置的下一位，也意味着指针b所指向的元素是不参与比较的，指针b只作为一个判断的边界
    //2.(a+b)/2得到中间位置(向下取整)，查看此位置的元素是否为目标值，如果为目标值就返回
    //3.不为目标值的话，缩小指针范围，继续查找
    //4.缩小规则：目标值 < 当前值，令 b = m; m不再参与比较，b也不参与比较，正好将m赋值给b，充当边界值
    //          目标值 > 当前值，令 a = m+1; a所指向的值是需要参与比较的，所以我们要调整到一个有意义的值上
    //5.当b < a时，查找结束
    public static int test2(int[] nums, int target) {
        //判断查找元素是否在数组内
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        //定义两个指针
        int first = 0,last = nums.length;
        //当first与last相等时，也需要比较
        while (first < last){
            //防止内存溢出，等价于(first+last)/2
            int middle = (first + last) >>> 1;
            if (nums[middle] == target){
                return middle;
            }else if (target < nums[middle]){
                last = middle;
            }else {
                first = middle + 1;
            }
        }
        return -1;
    }
}
