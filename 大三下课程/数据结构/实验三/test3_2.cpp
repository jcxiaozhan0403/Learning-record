//用于输入输出
#include <iostream>
//用于生成随机数
#include <cstdlib>
//用于获取当前时间
#include <ctime>
//命名空间
using namespace std;

// 队列最大容量
const int MAX_SIZE = 10;

class Queue {
private:
	// 用于存储队列元素的数组
    int arr[MAX_SIZE];
	// 队头和队尾指针 
    int front, rear; 

public:
    Queue() {
    	// 初始化队头指针
        front = 0;
        // 初始化队尾指针
        rear = 0;
    }
	//队列是否为空 
    bool isEmpty() {
    	// 队列为空的条件是队头和队尾指针相等
        return front == rear;
    }
	//队列是否已满 
    bool isFull() {
    	// 队列已满的条件是队尾指针加 1 等于队头指针
        return (rear + 1) % MAX_SIZE == front;
    }

	//入队函数 
    void enqueue(int value) {
    	// 如果队列已满，输出提示信息并返回
        if (isFull()) {
            cout << "队列已满。" << endl;
            return;
        }
        // 将元素存储到队尾
        arr[rear] = value;
        // 队尾指针加 1
        rear = (rear + 1) % MAX_SIZE;
    }

	//出队函数 
    int dequeue(int n) {
    	// 如果队列为空，输出提示信息并返回 -1
        if (isEmpty()) {
            cout << "队列为空。" << endl;
            return -1;
        }
        // 记录出队元素的数量
        int count = 0;
        // 只要队列非空且出队元素数量不足 n，就一直循环
        while (!isEmpty() && count < n) {
        	// 取出队头元素
            int value = arr[front];
            // 队头指针加 1
            front = (front + 1) % MAX_SIZE;
            // 输出出队元素
            cout << value << " ";
			// 计数器加 1 
            count++;
        }
        // 输出换行符
        cout << endl;
        // 返回出队元素数量
        return count;
    }

	//返回对头元素 
    int peek() {
    	// 如果队列为空，输出提示信息并返回 -1
        if (isEmpty()) {
            cout << "队列为空。" << endl;
            return -1;
        }
        // 返回队头元素
        return arr[front];
    }
};

int main() {
	//创建一个队列对象 
    Queue q;
    // 初始化随机数生成器
	srand(time(NULL));
	
	// 入队10个随机数
	for (int i = 0; i < 10; i++) {
	    int value = rand() % 100;
	    q.enqueue(value);
	}
	
	// 从队列中出队n个元素
	int n;
	cout << "请输入需要出队的元素数量：";
	cin >> n;
	int count = q.dequeue(n);
	cout << "已出队 " << count << " 个元素。" << endl;
	
	// 获取队头元素
	int front = q.peek();
	if (front != -1) {
	    cout << "队头元素为：" << front << endl;
	}
	
	return 0;
}
