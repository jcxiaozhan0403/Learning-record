package 线性结构;

import java.util.Scanner;

/**
 * @author John.Cena
 * @date 2023/5/3 13:29
 * @Description: 数组实现队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //接收用户输入
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("show：显示队列");
            System.out.println("exit：退出程序");
            System.out.println("add：添加元素到队列");
            System.out.println("get：从队列取出数据");
            System.out.println("head：查看队头元素");
            //接收一个字符
            key = scanner.nextLine();
            switch (key){
                case "show":
                    try{
                        arrayQueue.showQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop = false;
                    scanner.close();
                    break;
                case "add":
                    try{
                        System.out.print("请输入一个数字：");
                        int i = scanner.nextInt();
                        scanner.nextLine(); //读取空字符并清除它
                        arrayQueue.addQueue(i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "get":
                    try{
                        System.out.println(arrayQueue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "head":
                    try{
                        System.out.println("队头元素：" + arrayQueue.headQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("请输入正确指令！");
                    break;
            }
        }
        System.out.println("程序已退出！");
    }
}

class ArrayQueue {
    //数组最大容量
    private int maxSize;
    //头指针，存储索引
    private int front;
    //尾指针，存储索引
    private int rear;
    //数组容器
    private int[] arr;

    //构造方法
    public ArrayQueue(int maxSize){
        //构建容器
        this.maxSize = maxSize;
        arr = new int[maxSize];

        //头指针指向队头元素的前一个位置
        front = -1;
        //尾指针指向队尾元素的位置
        rear = -1;
    }

    //判断队列是否已满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //入队
    public void addQueue(int n){
        if (isFull()){
            throw new RuntimeException("队列已满!");
        }
        arr[++rear] = n;
    }

    //出队
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        return arr[++front];
    }

    //打印队列元素
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    //打印队头元素
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        return arr[front + 1];
    }
}
