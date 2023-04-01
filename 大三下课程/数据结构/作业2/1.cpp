//io库 
#include <iostream>
//输入输出的命名空间 
using namespace std;
//常量 
const int MaxSize = 100;
//模板类(Java泛型) 
template <class DataType>
class SeqList
{
//公共方法 
public:
	//无参构造函数，建立空的顺序表
    SeqList();
    //有参构造函数，建立长度为n的顺序表
    SeqList(DataType a[ ], int n);
    //析构函数
    //它在对象销毁时被自动调用，用于释放对象占用的资源（例如堆内存、文件句柄等）。
	//一个类可以定义一个或多个析构函数，在对象销毁时执行所需的清理任务。
	~SeqList();
	//求线性表的长度
    int Length();
    //判断线性表是否为空，1代表空、0代表非空 
    int Empety();
    //按位查找，查找第i个元素的值
    DataType Get(int i);
    //按值查找，查找值为x的元素序号
    int Locate(DataType x);
    //插入操作，在第i个位置插入值为x的元素
    void Insert(int i, DataType x);
    //删除操作，删除第i个元素
    DataType Delete(int i);
    //遍历打印，按序号依次输出各元素
   	void PrintList( );
//私有方法 
private:
	//存放数据元素的数组
    DataType data[MaxSize];
    //线性表的长度
    int length;
};

template<class DataType>
SeqList<DataType> :: ~SeqList()
{

}

template <class DataType>
SeqList<DataType> :: SeqList()
{
    length = 0;
}

template <class DataType>
int SeqList<DataType> :: Empety()
{
    if(length == 0){
    	return 1;
	}else{
		return 0;
	}
}

template <class DataType>
int SeqList<DataType> :: Length()
{
    return length;
}

template <class DataType>
SeqList<DataType> :: SeqList(DataType a[ ], int n)
{
    if (n > MaxSize)
     throw "参数非法";
     for (int i = 0; i < n; i++)
     data[i] = a[i];
     length = n;
}

template <class DataType>
void SeqList<DataType> :: PrintList()
{
    for (int i = 0; i < length; i++){
		//依次输出线性表的元素值
		cout << data[i];
	} 
}

template <class DataType>
int SeqList<DataType> :: Locate(DataType x)
{
    for (int i = 0; i < length; i++){
		if (data[i] == x){
			//返回其序号i+1
			return i+1;
		}
	}
	//退出循环，说明查找失败
	return 0;
}

template <class DataType>
DataType SeqList<DataType> :: Get(int i)
{
    if (i < 1 && i > length){
    	throw "查找位置非法";
	}else{
		return data[i - 1];
	}
}

template <class DataType>
DataType SeqList<DataType> :: Delete(int i)
{
//    if (length == 0)
//     throw "下溢";
//     if (i < 1 || i > length)
//     throw "位置";
//     int x = data[i - 1]; //取出位置i的元素
//     for (int j = i; j < length; j++)
//     data[j - 1] = data[j];  //此处j已经是元素所在的数组下标
//     length--;
//     return x;
	if (length == 0){ 
		throw "下溢"; 
	}
	
	if (i < 1 || i > length){ 
		throw "位置错误"; 
	}
	
	//取出位置i的元素 
	int x = data[i-1]; 
	
	for (int j=i; j<length; j++){
		//此处j已经是元素所在的数组下标 
		data[j-1] = data[j];
	}
	length--;
	return x; 
}

template <class DataType>
void SeqList<DataType> :: Insert(int i, DataType x)
{
	if (length >= MaxSize){
		throw "上溢";
	}
	
	if (i < 1 || i > length + 1){
		throw "位置错误";
	}
     
	for (int j = length; j >= i; j--){
		//第j个元素存在数组下标为j-1处
		data[j] = data[j - 1];
		data[i - 1] = x;	
	}
	length++;
}

int main() {
	//定义线性表 
    int data[MaxSize];
    //使用变量n来存储输入的长度值 
    int n;
    cout << "请输入线性表长度: ";
    cin >> n;
    cout << "请输入线性表元素: ";
    for(int i=0; i<n; i++) {
        cin >> data[i];
    }
    
    //初始化线性表 
    SeqList<int> L(data, n);
    
    cout << "当前线性表的数据为：";
    //输出当前线性表
	L.PrintList( );
    
    try {
        int i, x;
        cout << endl << "请输入插入的位置和元素值：";
        cin >> i >> x;
        //在第i个位置插入值为x的元素
        L.Insert(i, x);
        cout << "执行插入操作后数据为：";
        //输出插入后的线性表
        L.PrintList();
        cout << endl;
    } catch(char* str) {
        cout << str << "插入操作错误！" << endl;
    }

	//输出线性表的长度
    cout << "当前线性表的长度为：" << L.Length( );
    cout << endl;
    
    try {
        cout << "请输入查找的元素值：";
        int x;
        cin >> x;
        int i = L.Locate(x);
        if (0 == i) cout << "查找失败" << endl;
        else cout << "元素" << x << "的位置为：" << i << endl;
    } catch(char* str) {
        cout << str << "查找操作错误！" << endl;
    }

    try {
        cout << "请输入要删除的元素位置: ";
        int i;
        cin >> i;
        int x = L.Delete(i);
        cout << "删除元素" << x << "后线性表的数据为：";
        L.PrintList();
        cout << endl;
    } catch(char* str) {
        cout << str << "删除操作错误！" << endl;
    }

    return 0;
}
