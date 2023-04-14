//用于输入输出
#include <iostream>
//用于生成随机数
#include <cstdlib>
//用于获取当前时间
#include <ctime>
//命名空间 
using namespace std;

// 定义单链表结点
struct Node {
	//数据 
    int data;
    //指针指向下一节点 
    Node* next;
    //构造函数 
    Node(int d) : data(d), next(nullptr) {}
};

// 定义单链表类
class LinkedList {
private:
	//头结点指针 
    Node* head;
    //链表个数 
    int size;

public:
    LinkedList() : head(nullptr), size(0) {}

    // 随机生成10个100以内的整数并插入单链表中
    void generate() {
        for (int i = 0; i < 10; ++i) {
            int data = rand() % 100;
            insert(data, i);
        }
    }

    // 插入元素
    void insert(int data, int pos) {
    	//判定插入位置是否合法 
        if (pos < 0 || pos > size) {
            cout << "无效的位置" << endl;
            return;
        }
        //创建新节点 
        Node* new_node = new Node(data);
        if (pos == 0) {
        	//如果插入位置为0，将新节点插入到链表头部。新节点的 "next" 指针将指向原来的头节点，
            new_node->next = head;
            //然后将 "head" 指向新节点。
            head = new_node;
        }
        else {
        	//首先将指针 "curr" 指向头节点
            Node* curr = head;
            //然后通过迭代从头开始移动 "pos - 1" 次，以到达插入位置之前的节点。
            for (int i = 0; i < pos - 1; ++i) {
                curr = curr->next;
            }
            //将新节点的 "next" 指针指向当前节点的 "next" 指针指向的节点
            new_node->next = curr->next;
            //将当前节点的 "next" 指针指向新节点
            curr->next = new_node;
        }
        //链表大小+1 
        ++size;
    }

    // 删除元素
    void remove(int pos) {
    	//判断位置是否合法 
        if (pos < 0 || pos >= size) {
            cout << "无效的位置" << endl;
            return;
        }
        //声明一个指向链表头部的指针 "curr"。
        Node* curr = head;
        if (pos == 0) {
        	//将 "head" 指向原始头节点的下一个节点
            head = head->next;
            //删除原始头节点
            delete curr;
        }
        else {
            for (int i = 0; i < pos - 1; ++i) {
            	//将指针 "curr" 指向头节点，然后通过迭代从头开始移动 "pos - 1" 次，以到达要删除的节点之前的节点。
                curr = curr->next;
            }
            //将一个指针 "temp" 指向要删除的节点
            Node* temp = curr->next;
            //将当前节点的 "next" 指针指向要删除节点的下一个节点
            curr->next = temp->next;
            //删除节点 
            delete temp;
        }
        //链表大小-1
        --size;
    }

    // 查找元素
    int find(int data) {
    	//声明一个指向链表头部的指针 "curr"
        Node* curr = head;
        //初始化位置 "pos" 为0
        int pos = 0;
        while (curr) {
            if (curr->data == data) {
                //如果当前节点的数据值等于要查找的数据值，则返回当前位置 "pos"
				return pos;
            }
            //遍历查找 
            curr = curr->next;
            ++pos;
        }
        //未找到 
        return -1;
    }

    // 显示单链表中的元素
    void display() {
    	//声明一个指向链表头部的指针 "curr"，并将其初始化为头节点 "head"。 
        Node* curr = head;
        while (curr) {
        	//输出当前节点的数据值
            cout << curr->data << " ";
            //移动指针 
            curr = curr->next;
        } 
        cout << endl;
    }
    
    // 基于归并排序的思想实现两个有序单链表的合并
	LinkedList merge(LinkedList& L1, LinkedList& L2) {
	    // 创建新链表
	    LinkedList L;
	
	    // 获取头节点
	    Node* curr1 = L1.head;
	    Node* curr2 = L2.head;
	
	    // 遍历两个链表
	    while (curr1 && curr2) {
	        if (curr1->data <= curr2->data) {
	            // 如果L1中的元素更小，则将其插入新链表中
	            L.insert(curr1->data, L.size);
	            curr1 = curr1->next;
	        } else {
	            // 如果L2中的元素更小，则将其插入新链表中
	            L.insert(curr2->data, L.size);
	            curr2 = curr2->next;
	        }
	    }
	
	    // 将未被遍历完的链表中的剩余元素插入新链表中
	    while (curr1) {
	        L.insert(curr1->data, L.size);
	        curr1 = curr1->next;
	    }
	    while (curr2) {
	        L.insert(curr2->data, L.size);
	        curr2 = curr2->next;
	    }
	
	    return L;
	}
};

int main() {
//    srand(time(NULL));
//    LinkedList list;
//    list.generate();
//    cout << "生成的链表为：";
//    list.display();
//    int data, pos;
//    cout << "请输入要查找的整数：";
//    cin >> data;
//    pos = list.find(data);
//    if (pos != -1) {
//        cout << data << "的位置为" << pos << endl;
//    }
//    else {
//        cout << "该元素不存在" << endl;
//    }
//    cout << "请输入要插入的整数和位置：";
//    cin >> data >> pos;
//    list.insert(data, pos);
//    cout << "插入元素后的链表为：";
//    list.display();
//    cout << "请输入要删除的位置：";
//    cin >> pos;
//    list.remove(pos);
//    cout << "删除元素后的链表为：";
//	list.display();

    // 设置随机数种子
    srand(time(nullptr));

    // 创建两个有序单链表
    LinkedList L1, L2;

    // 生成随机数据并插入链表中
    L1.generate();
    L2.generate();

    // 显示原始单链表
    cout << "L1: ";
    L1.display();
    cout << "L2: ";
    L2.display();

    // 合并单链表并显示结果
    LinkedList L3 = L1.merge(L1,L2);
    cout << "合并后的单链表: ";
    L3.display();

    return 0;
}
