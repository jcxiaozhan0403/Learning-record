package 线性结构;

import java.util.Scanner;

/**
 * @author John.Cena
 * @date 2023/5/3 22:19
 * @Description: 数组实现环形队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);
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
                        circleArray.showQueue();
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
                        circleArray.addQueue(i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "get":
                    try{
                        System.out.println(circleArray.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "head":
                    try{
                        System.out.println("队头元素：" + circleArray.headQueue());
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
class CircleArray {
    //数组最大容量
    private int maxSize;

    //头指针，存储索引
    //头指针指向队头元素的位置
    //front 的初始值 = 0
    private int front = 0;

    //尾指针，存储索引
    //尾指针指向队尾元素的下一个位置，因为希望空出一个空间做为约定
    //rear 的初始值 = 0
    private int rear = 0;
    //数组容器
    private int[] arr;

    //构造方法
    public CircleArray(int arrMaxSize) {
        //构建容器
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
