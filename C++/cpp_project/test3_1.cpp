//用于输入输出
#include <iostream>
// 包含 rand() 函数的头文件
#include <cstdlib>
//命名空间
using namespace std;

// 定义链表节点结构体
struct Node {
	// 数据域
    int data;
    // 指针域，指向下一个节点
    Node* next;
};

// 定义栈类
class Stack {
private:
	// 栈顶指针
    Node* top;
    // 栈的大小
    int size;
public:
	// 构造函数，初始化空栈
    Stack() {
        top = NULL;
        size = 0;
    }

	// 析构函数，释放栈中所有节点的内存
    ~Stack() {
        while (top != NULL) {
            Node* temp = top;
            top = top->next;
            delete temp;
        }
    }

	// 入栈函数
    void push(int value) {
		// 判断上溢   
        if (size >= 10) {
            cout << "错误：栈上溢。" << endl;
            return;
        }
		//定义一个新节点 
        Node* newNode = new Node;
        newNode->data = value;
        newNode->next = top;
        //将栈顶元素指向新节点 
        top = newNode;
        //栈大小+1 
        size++;
    }

	// 出栈函数
    void pop(int n) {
		// 参数非法   
        if (n <= 0) {
            cout << "错误：无效的参数。" << endl;
            return;
        }

		// 判断下溢
        if (size < n) {
            cout << "错误：栈下溢。" << endl;
            return;
        }

        cout << "从栈中弹出 " << n << " 个元素：" << endl;
        for (int i = 0; i < n; i++) {
            Node* temp = top;
            //逐个显示弹出元素 
            cout << temp->data << " ";
            top = top->next;
            delete temp;
            //栈大小-1 
            size--;
        }
        cout << endl;
    }

	// 取栈顶元素函数
    void getTop() {  
		// 判断栈空   
        if (size == 0) {
            cout << "错误：栈为空。" << endl;
            return;
        }

        cout << "栈顶元素为：" << top->data << endl;
    }
    
    //我添加了一个函数，来打印栈中元素信息
	//方便观察栈中元素 
    void printStack() {
    // 判断栈空
    if (size == 0) {
        cout << "当前栈为空。" << endl;
        return;
    }

    cout << "当前栈中元素为（从栈顶到栈底）：" << endl;
    Node* temp = top;
    while (temp != NULL) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}
};

int main() {
    Stack s;

    // 入栈
    for (int i = 0; i < 10; i++) {
        int value = rand() % 100;
        s.push(value);
    }
    
    s.printStack(); 

    // 出栈
    int n;
    cout << "请输入您想从栈中弹出的元素个数（小于10）：";
    cin >> n;
    s.pop(n);
    
    s.printStack();

    // 取栈顶元素
    s.getTop();

    return 0;
}
