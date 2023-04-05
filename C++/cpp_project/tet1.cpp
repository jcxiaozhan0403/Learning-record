#include<iostream>
// 用于 rand() 和 srand() 函数
#include<cstdlib>
// 用于 time() 函数
#include<ctime>

using namespace std;

// 定义常量
// 顺序表的最大容量
const int MAXSIZE = 10;
// 随机生成数的最大值
const int MAXNUM = 100;

// 定义顺序表结构体
struct SeqList{
	// 存储数据元素的数组
    int data[MAXSIZE];
    // 当前顺序表中的元素个数
	int length;
};

// 初始化顺序表
void InitList(SeqList &L)
{
	// 将顺序表的长度初始化为 0
    L.length = 0;
}

// 随机生成 10 个 100 以内的整数并存储到顺序表中
void CreateList(SeqList &L)
{
	// 用系统时间作为随机数种子，确保每次运行程序时生成的随机数不同
    srand(time(NULL));
    for(int i=0;i<MAXSIZE;i++){
    	// 生成 1 ~ 100 的随机整数并存储到顺序表中
        L.data[i] = rand() % MAXNUM + 1;
    }
    // 顺序表的长度设为 MAXSIZE
    L.length = MAXSIZE;
}

// 输出顺序表中的所有元素
void DisplayList(SeqList L)
{
    cout << "当前顺序表中的元素为：";
    for(int i=0;i<L.length;i++){
        cout << L.data[i] << " ";
    }
    cout << endl;
}

// 在顺序表中查找指定元素，并返回其位置（从 0 开始计数），若找不到返回 -1
int FindElem(SeqList L, int x)
{
    for(int i=0;i<L.length;i++){
        if(L.data[i] == x){
            return i;
        }
    }
    return -1;
}

// 向顺序表的指定位置插入元素
void InsertElem(SeqList &L, int x, int pos)
{
	// 如果顺序表已满，无法插入新元素
    if(L.length == MAXSIZE){
        cout << "顺序表已满，无法插入新元素！" << endl;
        return;
    }
    // 如果插入位置不合法，无法插入新元素
    if(pos < 0 || pos > L.length){
        cout << "插入位置不合法，无法插入新元素！" << endl;
        return;
    }
    // 将 pos 及其后面的元素后移
    for(int i=L.length-1;i>=pos;i--){
        L.data[i+1] = L.data[i];
    }
    // 在 pos 处插入新元素
    L.data[pos] = x;
    // 顺序表长度加 1
    L.length++;
}

// 删除顺序表中指定位置的元素
void DeleteElem(SeqList &L, int pos)
{
	// 判断删除位置是否合法
    if(pos < 0 || pos >= L.length){
        cout << "删除位置不合法！" << endl;
        return;
    }

	// 将后面的元素向前移动
    for(int i = pos; i < L.length - 1; i++){
        L.data[i] = L.data[i + 1];
    }
    L.length--; // 顺序表长度减 1
}

// 主函数
int main()
{
	// 声明顺序表
	SeqList L;
	// 插入元素的值和插入位置
	int x, pos;
	// 查找元素的值
	int elem;
	// 初始化顺序表
	InitList(L);
	
	// 随机生成 10 个 100 以内的整数并存储到顺序表中
	CreateList(L);
	
	// 输出顺序表中的所有元素
	DisplayList(L);
	
	// 查找元素
	cout << "请输入要查找的元素值：";
	cin >> elem;
	int idx = FindElem(L, elem);
	if(idx == -1){
	    cout << "该元素不在顺序表中！" << endl;
	}else{
	    cout << "该元素在顺序表中的位置为：" << idx << endl;
	}
	
	// 删除元素
	cout << "请输入要删除的元素位置（从 0 开始计数）：";
	cin >> pos;
	DeleteElem(L, pos);
	DisplayList(L);
	
	// 插入元素
	cout << "请输入要插入的元素值和插入位置（从 0 开始计数）：";
	cin >> x >> pos;
	InsertElem(L, x, pos);
	DisplayList(L);

	return 0;
}
