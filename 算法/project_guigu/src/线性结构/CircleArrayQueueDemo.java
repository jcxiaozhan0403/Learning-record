package 线性结构;

import java.util.Scanner;

/**
 * @author John.Cena
 * @date 2023/5/3 22:19
 * @Description:
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明设置 4, 其队列的有效数据最大是 3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s：显示队列");
            System.out.println("e：退出程序");
            System.out.println("a：添加元素到队列");
            System.out.println("g：从队列取出数据");
            System.out.println("h：查看队头元素");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    try{
                        queue.showQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    try{
                        System.out.print("请输入一个数字：");
                        int i = scanner.nextInt();
                        queue.addQueue(i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g': // 取出数据
                    try{
                        System.out.println(queue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try{
                        System.out.println("队头元素：" + queue.headQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                        loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出！");
    }
}
class CircleArray {
    private int maxSize; // 表示数组的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定. //rear 的初始值 = 0
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            throw new RuntimeException("队列已满!");
        }
        //直接将数据加入
        arr[rear] = n;
        //将 rear 后移, 这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里需要分析出 front 是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //打印队列元素
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        // 思路：从 front 开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + size() ; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    //打印队头元素
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        return arr[front];
    }
}
