//io库 
#include <iostream>
//输入输出的命名空间 
using namespace std;

template<typename DataType>
struct Node {
    DataType data;  //数据域
    Node<DataType> *next;  //指针域
};

template<typename DataType>
class LinkList {
public:
    LinkList(); //无参构造函数，建立只有头结点的空链表
    LinkList(DataType a[], int n);  //有参构造函数，建立有n个元素的单链表
    ~LinkList();  //析构函数
    int Length();  //求单链表的长度
    int Empety();

    DataType Get(int i);  //按位查找。查找第i个结点的元素值
    int Locate(DataType x); //按值查找。查找值为x的元素序号
    void Insert(int i, DataType x);  //插入操作，第i个位置插入值为x的结点
    DataType Delete(int i); //删除操作，删除第i个结点
    void PrintList(); //遍历操作，按序号依次输出各元素
private:
    Node<DataType> *first;  //单链表的头指针
};

template<typename DataType>
LinkList<DataType>::LinkList() {
    first = new Node<DataType>; //生成头结点
    first->next = nullptr; //头结点的指针域置空
}

template<class DataType>
LinkList<DataType>::~LinkList() {
    Node<DataType> *q = NULL;
    while (first != NULL)//释放单链表的每一个结点的存储空间
    {
        q = first;  //暂存被释放结点
        first = first->next;  // first指向被释放结点的下一个结点
        delete q;
    }
}

template<typename DataType>
int LinkList<DataType>::Empety() {
    if (first->next == nullptr)
        return 1;
    else
        return 0;
}

template<typename DataType>
void LinkList<DataType>::PrintList() {
    Node<DataType> *p = first->next; //工作指针p初始化
    while (p != nullptr) {
        cout << p->data << "\t";
        p = p->next;  //工作指针p后移，注意不能写作p++

    }
}

template<typename DataType>
int LinkList<DataType>::Length() {
    Node<DataType> *p = first->next;  //工作指针p初始化为开始接点
    int count = 0; //累加器count初始化
    while (p != nullptr) {
        p = p->next;
        count++;

    }
    return count;//注意count的初始化和返回值之间的关系
}

template<typename DataType>
DataType LinkList<DataType>::Get(int i) {
    Node<DataType> *p = first->next; //工作指针p初始化
    int count = 1;  //累加器count初始化
    while (p != nullptr && count < i) {
        p = p->next; //工作指针p后移
        count++;
    }
    if (p == nullptr) throw "位置";
    else return p->data;
}

template<typename DataType>
int LinkList<DataType>::Locate(DataType x) {
    Node<DataType> *p = first->next;  //工作指针p初始化
    int count = 1;  //累加器count初始化
    while (p != nullptr) {
        if (p->data == x) return count;  //查找成功，结束函数并返回序号
        p = p->next;
        count++;
    }
    return 0; //退出循环表明查找失败
}

template<typename DataType>
void LinkList<DataType>::Insert(int i, DataType x) {
    Node<DataType> *p = first, *s = nullptr; //工作指针p初始化
    int count = 0;
    while (p != nullptr && count < i - 1) //查找第i – 1个结点
    {
        p = p->next; //工作指针p后移
        count++;
    }
    if (p == nullptr) throw "位置";//没有找到第i – 1个结点
    else {
        s = new Node<DataType>;
        s->data = x; //申请结点s，数据域为x
        s->next = p->next;
        p->next = s;  //将结点s插入到结点p之后
    }
}

// 头插法构造?
//template <typename DataType> ?
//LinkList<DataType> :: LinkList(DataType a[ ], int n)
//{
//? ??first = new Node<DataType>; first->next = nullptr; ? ? //初始化一个空链表
//? ??for (int i = 0; i < n; i++)
//? ??{?
//? ? ? ??Node<DataType> *s;
//? ? ? ??s = new Node<DataType>; s->data = a[i]; ? ?
// ? ? ? ??s->next = first->next; first->next = s; ? ?//将结点s插入到头结点之后
//? ??}
//}

template<typename DataType>
LinkList<DataType>::LinkList(DataType a[], int n) {
    first = new Node<DataType>; //生成头结点
    Node<DataType> *r = first, *s = nullptr;  //尾指针初始化
    for (int i = 0; i < n; i++) {
        s = new Node<DataType>;
        s->data = a[i];
        r->next = s;
        r = s;  //将结点s插入到终端结点之后
    }
    r->next = nullptr; //单链表建立完毕，将终端结点的指针域置空
}

template<typename DataType>
DataType LinkList<DataType>::Delete(int i) {
    DataType x;
    Node<DataType> *p = first, *q = nullptr; //工作指针p指向头结点
    int count = 0;
    while (p != nullptr && count < i - 1)  //查找第i-1个结点
    {
        p = p->next;
        count++;
    }
    if (p == nullptr || p->next == nullptr) //结点p不存在或p的后继结点不存在
        throw "位置";
    else {
        q = p->next;
        x = q->data;  //暂存被删结点
        p->next = q->next; //摘链
        delete q;
        return x;
    }
}

int main()
{
    int a[100], n, x, i;
    cout << "请输入顺序表长度n: ";
    cin >> n;
    cout << "请输入顺序表的" << n << "个元素: ";
    for (i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    LinkList<int> L(a, n); // 用顺序表的数据构造链表

    cout << "顺序表中的元素为: ";
    L.PrintList(); // 遍历顺序表

    cout << endl << "请输入要插入的元素x和插入位置i: ";
    cin >> x >> i;
    try {
        L.Insert(i, x);
        cout << "插入元素x成功！" << endl;
        cout << "插入后的链表为: ";
        L.PrintList();
    }
    catch (const char *e) {
        cout << "插入位置错误！" << endl;
    }

    cout << endl << "请输入要删除元素的位置i: ";
    cin >> i;
    try {
        x = L.Delete(i);
        cout << "删除元素x=" << x << "成功！" << endl;
        cout << "删除后的链表为: ";
        L.PrintList();
    }
    catch (const char *e) {
        cout << "删除位置错误！" << endl;
    }

    cout << endl << "请输入要查找的元素: ";
    cin >> x;
    int pos = L.Locate(x);
    if (pos == 0) {
        cout << "未找到该元素！" << endl;
    }
    else {
        cout << "元素x=" << x << "在链表中的位置为: " << pos << endl;
    }

    return 0;
}

