package 线性结构;

import java.util.Scanner;

/**
 * @author John.Cena
 * @date 2023/5/3 13:29
 * @Description:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("s：显示队列");
            System.out.println("e：退出程序");
            System.out.println("a：添加元素到队列");
            System.out.println("g：从队列取出数据");
            System.out.println("h：查看队头元素");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    try{
                        arrayQueue.showQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                    break;
                case 'a':
                    try{
                        System.out.print("请输入一个数字：");
                        int i = scanner.nextInt();
                        arrayQueue.addQueue(i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try{
                        System.out.println(arrayQueue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        System.out.println("队头元素：" + arrayQueue.headQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出！");
    }
}

class ArrayQueue {
    //数组最大容量
    private int maxSize;
    //队头
    private int front;
    //队尾
    private int rear;
    //数组容器
    private int[] arr;

    //构造方法
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队头元素的前一个位置
        front = -1;
        //指向队尾元素的位置
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

    //添加元素到队列
    public void addQueue(int n){
        if (isFull()){
            throw new RuntimeException("队列已满!");
        }
        arr[++rear] = n;
    }

    //移除队列元素
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
