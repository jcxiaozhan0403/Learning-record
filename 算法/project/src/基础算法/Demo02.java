package 基础算法;

import java.util.Arrays;

/**
 * @author John.Cena
 * @date 2023/3/27 22:35
 * @Description: ArrayList动态数组
 */
public class Demo02 {
    //当前元素个数
    int size = 0;
    //容器大小
    int capacity = 8;
    //初始数组
    int[] arr = null;


    public static void main(String[] args) {

    }

    //插入
    public void add(int element){
        checkAndIncr();
        add(element,size);
    }

    //插入
    public void add(int element,int index){
        //移动数组位置
        System.arraycopy(arr,index,arr,size+1,size-index+1);
        //放入元素
        arr[index] = element;
        //元素数量++
        size++;
    }

    //遍历
    public void forEach(){

    }


    //删除
    public void deleElement(int index){
        //
    }
    

    //删除
    public void deleElement(){
        //
    }

    //扩容
    public void checkAndIncr(){
        //首次进入，初始化数组
        if (arr == null){
            arr = new int[capacity];
        }

        if (arr.length == size){
            capacity += (capacity >> 1);
            int[] newArr = new int[capacity];
            //扩容操作
            System.arraycopy(arr,0,newArr,0,size);
        }
    }
}
