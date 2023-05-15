#include <iostream>
using namespace std;

const int MaxSize = 100; //100只是示例性的数据，根据实际问题具体定义
template <class DataType> //定义模板类SeqList
class SeqList
{
//统一声明函数 
public:
    SeqList( );  //无参构造函数，建立空的顺序表
    SeqList(DataType a[ ], int n); //有参构造函数，建立长度为n的顺序表
    ~SeqList( ); //析构函数
    int Length( );  //求线性表的长度
    int Empety();
    DataType Get(int i); //按位查找，查找第i个元素的值
    int Locate(DataType x ); //按值查找，查找值为x的元素序号
    void Insert(int i, DataType x);//插入操作，在第i个位置插入值为x的元素
    DataType Delete(int i); //删除操作，删除第i个元素
   	void PrintList( ); //遍历操作，按序号依次输出各元素
private:
    DataType data[MaxSize]; //存放数据元素的数组
    int length; //线性表的长度
};

//定义函数 
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
     if(length == 0)
    return 1;
     else
     return 0;
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
void SeqList<DataType> :: PrintList( )
{
    for (int i = 0; i < length; i++)
    cout << data[i];  //依次输出线性表的元素值
}

template <class DataType>
int SeqList<DataType> :: Locate(DataType x)
{
    for (int i = 0; i < length; i++)
     if (data[i] == x) return i+1; //返回其序号i+1
   return 0;
   //退出循环，说明查找失败
}

template <class DataType>
DataType SeqList<DataType> :: Get(int i)
{
    if (i < 1 && i > length)
     throw "查找位置非法";
    else
     return data[i - 1];
}

template <class DataType>
DataType SeqList<DataType> :: Delete(int i)
{
    if (length == 0)
     throw "下溢";
     if (i < 1 || i > length)
     throw "位置";
     int x = data[i - 1]; //取出位置i的元素
     for (int j = i; j < length; j++)
     data[j - 1] = data[j];  //此处j已经是元素所在的数组下标
     length--;
     return x;
}

template <class DataType>
void SeqList<DataType> :: Insert(int i, DataType x)
{
     if (length >= MaxSize)
     throw "上溢";
     if (i < 1 || i > length + 1)
     throw "位置";
    for (int j = length; j >= i; j--)
     data[j] = data[j - 1]; //第j个元素存在数组下标为j-1处
     data[i - 1] = x;
     length++;
}

int main() {
    int data[MaxSize];
    int n;
    cout << "请输入线性表长度: ";
    cin >> n;
    cout << "请输入线性表元素: ";
    for(int i=0; i<n; i++) {
        cin >> data[i];
    }
    //实例化一个模板类 
    SeqList<int> L(data, n);
    
    cout << "当前线性表的数据为：";
    L.PrintList( ); //输出当前线性表
    
    try {
        int i, x;
        cout << endl << "请输入插入的位置和元素值：";
        cin >> i >> x;
        L.Insert(i, x); //在第i个位置插入值为x的元素
        cout << "执行插入操作后数据为：";
        L.PrintList( ); //输出插入后的线性表
        cout << endl;
    } catch(char* str) {
        cout << str << "插入操作错误！" << endl;
    }

    cout << "当前线性表的长度为：" << L.Length( );//输出线性表的长度
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
