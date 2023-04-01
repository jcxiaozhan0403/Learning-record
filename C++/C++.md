## Hello World

```c++
//头文件，将一些必须的库导入到程序中
//iostream库包含了用于输入输出的标准C++对象和函数，例如std::cout和std::cin。
//在程序中包含iostream库可以使得我们能够使用这些对象和函数来实现控制台输入输出功能。
#include <iostream>
//std命名空间中包含c++系统定义的一些变量表示，比如例如cout、cin、endl等
using namespace std;

int main(){
    //打印语句
    //cout << "Hello World" << endl; 输出并换行
    //cout << "Hello World"; 输出后不换行
    cout << "Hello World" << endl;
    return 0; 
} 
```

## 编译执行程序

```shell
# 使用g++来编译程序，生成一个a.out可执行程序
g++ hello.cpp

#使用a.out来执行程序
a.out
```

## 数据类型

C++ 为程序员提供了种类丰富的内置数据类型和用户自定义的数据类型，下表列出了七种基本的 C++ 数据类型

|   类型   | 关键字  |                         描述                         |
| :------: | :-----: | :--------------------------------------------------: |
|  布尔型  |  bool   |                存储值 true 或 false。                |
|  字符型  |  char   | 通常是一个八位字节（一个字节）。这是一个字符串类型。 |
|   整型   |   int   |           对机器而言，整数的最自然的大小。           |
|  浮点型  |  float  |                    单精度浮点值。                    |
| 双浮点型 | double  |                    双精度浮点值。                    |
|  无类型  |  void   |                   表示类型的缺失。                   |
| 宽字符型 | wchar_t |                     宽字符类型。                     |

类型修饰符：

- `signed`：signed是一种有符号修饰符，可以用来修饰整型数据类型（char、short、int、long、long long），表示该变量是有符号数，即正数和负数都可以表示。
- `unsigned`：unsigned是一种无符号修饰符，同样可以用来修饰整型数据类型，表示该变量是无符号数，只能表示非负数。
- `shor`t：short是短整型修饰符，可以用来修饰整型数据类型，表示该变量只需要较小的存储空间，一般为2个字节。
- `long`：long是长整型修饰符，同样可以用来修饰整型数据类型，表示该变量需要较大的存储空间，一般为4个字节（根据编译器和操作系统可能会不同）。

## typedef 声明

您可以使用 **typedef** 为一个已有的类型取一个新的名字。

```c++
typedef int feet;
```

## 枚举类型

枚举类型声明一个可选的类型名称和一组标识符，用来作为该类型的值。其带有零个或多个标识符可以被用来作为该类型的值。每个枚举数是一个枚举类型的常数。

创建枚举，需要使用关键字 **enum**。枚举类型的一般形式为：

```c++
enum 枚举类型 { 枚举项1、枚举项2... } 枚举变量; 
```

```c++
//在这个例子中，MONDAY、TUESDAY等都是枚举项，它们的值分别为1、2、3、4、5、6和7；
//weekday变量是属于Weekday类型的，可以为枚举项中的任意一个值。
enum Weekday {
    MONDAY = 1,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
} weekday;
```

## 变量声明&函数声明

> 变量声明

变量在头部就已经被声明，但它们是在主函数内被定义和初始化的

```c++
#include <iostream>
using namespace std;

// 变量声明
extern int a, b;
extern int c;
extern float f;
  
int main ()
{
    // 变量定义
    int a, b;
    int c;
    float f;
 
    // 实际初始化
    a = 10;
    b = 20;
    c = a + b;
 
    cout << c << endl ;
    f = 70.0/3.0;
    cout << f << endl ;
    return 0;
} 
```

> 函数声明

同样的，在函数声明时，提供一个函数名，而函数的实际定义则可以在任何地方进行。

```c++
// 函数声明
int func();

int main()
{
    // 函数调用
    int i = func();
}

// 函数定义
int func()
{
    return 0;
}
```

> 跨模块

关键字extern用来声明一个变量或函数是在其他文件或模块中定义的。具体来说，可以使用extern关键字来声明一个变量或函数，而不用在当前文件或模块中定义它们。

例如，在一个源文件中定义了两个全局变量a和b

```c++
int a = 10;
int b = 20;
```

如果想在另一个源文件中引用这两个变量，可以在该文件中使用extern关键字声明这两个变量

```c++
// 在另一个源文件中声明
extern int a, b;

int main() {
    // 使用变量a和b
    int c = a + b;
    return 0;
}
```

这样，编译器就知道变量a和b在另一个文件中定义，程序在运行时会从其他文件中获取这些变量的实际值。

## 常量

> define预处理器

在程序中，每次出现PI时都会被替换成3.1415926。使用#define声明常量的优点是可以在全局范围内定义常量，缺点是不进行类型检查，容易出错。此外，由于#define是预处理器指令，因此可能会增加编译时间和程序大小。

```c++
#define PI 3.1415926
```

> const关键字

用const声明常量的优点是进行了类型检查，不容易出错，并且不会增加程序大小。缺点是常量的作用域较小，只能在声明它的块中使用。

```c++
const int MAX = 100;
```

## 存储类

存储类定义 C++ 程序中变量/函数的范围（可见性）和生命周期。这些说明符放置在它们所修饰的类型之前。

- `auto`：在C++11之前，auto被用作变量声明的关键字，表示该变量的类型将自动推断。但是从C++11开始，auto已经被重新定义为类型推断关键字，可以使用于变量声明(例如auto x = 10;)，也可以用于函数的返回值类型(例如auto func() -> int { return 42; })。
- `register`：register是一个过时的关键字，它用于向编译器建议将某些变量存储在寄存器中以加快访问速度。但是，现代编译器通常会自动优化变量的存储方式，所以register关键字已经不再具有实际意义。
- `static`：static是一个重要的存储类关键字，用于定义静态变量或函数。对于静态变量，它们只初始化一次并保留在内存中，即使在程序执行期间某些函数被多次调用也不会重新初始化。对于静态函数，它们不能被其他文件引用，只能在当前文件中使用。
- `extern`：extern是另一个重要的存储类关键字，用于在一个文件中声明并引用另一个文件中定义的全局变量或函数。extern关键字告诉编译器这个变量或函数在另一个文件中定义，这样编译器就可以正确地解析它们。
- `mutable`：mutable是一个用于修饰类的非静态成员变量的关键字。它告诉编译器即使在const成员函数中也允许修改该变量的值。通常情况下，const成员函数不能修改任何非静态成员变量，但是如果使用了mutable关键字，则可以对其进行修改。

**auto** 存储类是所有局部变量默认的存储类。

## 运算符

| 运算符               | 描述                                                         |
| -------------------- | :----------------------------------------------------------- |
| sizeof               | sizeof 运算符返回变量的大小。例如，sizeof(a) 将返回 4，其中 a 是整数。 |
| Condition ? X : Y    | 条件运算符。如果 Condition 为真 ? 则值为 X : 否则值为 Y。    |
| ,                    | 逗号运算符会顺序执行一系列运算。整个逗号表达式的值是以逗号分隔的列表中的最后一个表达式的值。 |
| .（点）和 ->（箭头） | 成员运算符用于引用类、结构和共用体的成员。                   |
| Cast                 | 强制转换运算符把一种数据类型转换为另一种数据类型。例如，int(2.2000) 将返回 2。 |
| &                    | 指针运算符 返回变量的地址。例如` &a;` 将给出变量的实际地址。 |
| *                    | 指针运算符 `*`指向一个变量。例如，`*var;` 将指向变量 var。   |

## 随机数

在许多情况下，需要生成随机数。关于随机数生成器，有两个相关的函数。一个是 **rand()**，该函数只返回一个伪随机数。生成随机数之前必须先调用 **srand()** 函数。

```c++
#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;
 
int main ()
{
    int i,j;

    // 设置种子
    srand( (unsigned)time( NULL ) );

    /* 生成 10 个随机数 */
    for( i = 0; i < 10; i++ ){
        // 生成实际的随机数
        j= rand();
        cout <<"随机数： " << j << endl;
    }
    return 0;
} 
```

## 指针&引用

引用和指针是C++中两个重要的概念，它们都可以用于间接访问变量或对象。但是它们之间有很大的不同：

1. 定义方式：引用是一个已经存在的变量或对象的别名，而指针是一个变量，存储了另一个变量或对象的地址。
2. 内存占用：引用不需要额外的内存空间，因为它只是对原有变量的一个别名；而指针需要占用额外的内存空间来存储所指向对象的地址。
3. 取址操作：引用没有自己的地址，因此不能进行取址操作(&)；而指针有自己的地址，可以进行取址操作。
4. 空值(NULL)：引用必须在定义时初始化，并且不能为NULL；而指针可以不初始化，也可以被设置为NULL。
5. 引用和指针的用途：引用主要用于函数参数传递和返回值类型，以及方便地访问数组元素；指针除了这些用途还可以动态分配内存、遍历数据结构等。

```c++
int  var = 20;    //变量
int  *ip = &var;  //定义一个指针
int &ip = var; 	  //定义一个引用
```

## 时间&日期

C++ 标准库没有提供所谓的日期类型。C++ 继承了 C 语言用于日期和时间操作的结构和函数。为了使用日期和时间相关的函数和结构，需要在 C++ 程序中引用 `<ctime>` 头文件。

有四个与时间相关的类型：**clock_t、time_t、size_t** 和 **tm**。类型 clock_t、size_t 和 time_t 能够把系统时间和日期表示为某种整数。

结构类型 **tm** 把日期和时间以 C 结构的形式保存，tm 结构的定义如下

```c++
struct tm {
    int tm_sec;   // 秒，正常范围从 0 到 59，但允许至 61
    int tm_min;   // 分，范围从 0 到 59
    int tm_hour;  // 小时，范围从 0 到 23
    int tm_mday;  // 一月中的第几天，范围从 1 到 31
    int tm_mon;   // 月，范围从 0 到 11
    int tm_year;  // 自 1900 年起的年数
    int tm_wday;  // 一周中的第几天，范围从 0 到 6，从星期日算起
    int tm_yday;  // 一年中的第几天，范围从 0 到 365，从 1 月 1 日算起
    int tm_isdst; // 夏令时
}
```

## 输入输出

> I/O库头文件

| 头文件       | 函数和描述                                                   |
| ------------ | ------------------------------------------------------------ |
| `<iostream>` | 该文件定义了 **cin、cout、cerr** 和 **clog** 对象，分别对应于标准输入流、标准输出流、非缓冲标准错误流和缓冲标准错误流。 |
| `<iomanip>`  | 该文件通过所谓的参数化的流操纵器（比如 **setw** 和 **setprecision**），来声明对执行标准化 I/O 有用的服务。 |
| `<fstream>`  | 该文件为用户控制的文件处理声明服务。我们将在文件和流的相关章节讨论它的细节。 |

> 标注输出流 cout

预定义的对象 **cout** 是 **ostream** 类的一个实例。cout 对象"连接"到标准输出设备，通常是显示屏。**cout** 是与流插入运算符 << 结合使用的，如下所示：

```c++
#include <iostream>
using namespace std;
 
int main( ){
    char str[] = "Hello C++";
    cout << "Value of str is : " << str << endl; 
} 
```

> 标注输入流 cin

预定义的对象 **cin** 是 **istream** 类的一个实例。cin 对象附属到标准输入设备，通常是键盘。**cin** 是与流提取运算符 >> 结合使用的，如下所示：

```c++
#include <iostream>
using namespace std;

int main(){
    char name[50];
    cout << "请输入您的名称： ";
    cin >> name;
    cout << "您的名称是： " << name << endl;   
} 
```

> 标准错误流

预定义的对象 **cerr** 是 **ostream** 类的一个实例。cerr 对象附属到标准错误设备，通常也是显示屏，但是 **cerr** 对象是非缓冲的，且每个流插入到 cerr 都会立即输出。

**cerr** 也是与流插入运算符 << 结合使用的，如下所示：

```c++
#include <iostream>
using namespace std;
 
int main(){
    char str[] = "Unable to read....";
    cerr << "Error message : " << str << endl; 
} 
```

> 标准日志流

预定义的对象 **clog** 是 **ostream** 类的一个实例。clog 对象附属到标准错误设备，通常也是显示屏，但是 **clog** 对象是缓冲的。这意味着每个流插入到 clog 都会先存储在缓冲区中，直到缓冲填满或者缓冲区刷新时才会输出。

**clog** 也是与流插入运算符 << 结合使用的，如下所示：

```c++
#include <iostream>
using namespace std;

int main(){
    char str[] = "Unable to read....";
    clog << "Error message : " << str << endl;
} 
```

## 结构体

结构体的定义使用与c语言中相同

### 结构作为函数参数

您可以把结构作为函数参数，传参方式与其他类型的变量或指针类似。您可以使用上面实例中的方式来访问结构变量：

```c++
#include <iostream>
#include <cstring>
 
using namespace std;
void printBook( struct Books book );

struct Books{
    char title[50];
    char author[50];
    char subject[100];
    int book_id;
};
 
int main(){
    struct Books Book1;        // 声明 Book1，类型为 Book
    struct Books Book2;        // 声明 Book2，类型为 Book
 
    // Book1 详述
    strcpy( Book1.title, "Learn C++ Programming");
    strcpy( Book1.author, "Chand Miyan"); 
    strcpy( Book1.subject, "C++ Programming");
    Book1.book_id = 6495407;

    // Book2 详述
    strcpy( Book2.title, "Telecom Billing");
    strcpy( Book2.author, "Yakit Singha");
    strcpy( Book2.subject, "Telecom");
    Book2.book_id = 6495700;
 
    // 输出 Book1 信息
    printBook( Book1 );

    // 输出 Book2 信息
    printBook( Book2 );

    return 0;
}
void printBook( struct Books book ){
    cout << "Book title : " << book.title <<endl;
    cout << "Book author : " << book.author <<endl;
    cout << "Book subject : " << book.subject <<endl;
    cout << "Book id : " << book.book_id <<endl;
}
```

### 指向结构的指针

您可以定义指向结构的指针，方式与定义指向其他类型变量的指针相似，如下所示：

```c++
//定义指针
struct Books *struct_pointer = = &Book1;

//为了使用指向该结构的指针访问结构的成员，您必须使用 -> 运算符
struct_pointer->title;
```

## 类与对象

与Java中类的定义类似，使用`.`来访问对象属性

```c++
#include <iostream>

using namespace std;

class Box
{
   //标识属性访问范围，public、private、protected
   public:
      double length;   // 长度
      double breadth;  // 宽度
      double height;   // 高度
};

int main( )
{
   Box Box1;        // 声明 Box1，类型为 Box
   Box Box2;        // 声明 Box2，类型为 Box
   double volume = 0.0;     // 用于存储体积
 
   // box 1 详述
   Box1.height = 5.0; 
   Box1.length = 6.0; 
   Box1.breadth = 7.0;

   // box 2 详述
   Box2.height = 10.0;
   Box2.length = 12.0;
   Box2.breadth = 13.0;

   // box 1 的体积
   volume = Box1.height * Box1.length * Box1.breadth;
   cout << "Box1 的体积：" << volume <<endl;

   // box 2 的体积
   volume = Box2.height * Box2.length * Box2.breadth;
   cout << "Box2 的体积：" << volume <<endl;
   return 0;
}
```

## 继承

> 单继承

```c++
class <派生类名>:<继承方式1><基类名1>
{
<派生类类体>
};
```

> 多继承

```c++
class <派生类名>:<继承方式1><基类名1>,<继承方式2><基类名2>,…
{
<派生类类体>
};
```

```c++
#include <iostream>
 
using namespace std;

// 基类
class Shape 
{
   public:
      void setWidth(int w)
      {
         width = w;
      }
      void setHeight(int h)
      {
         height = h;
      }
   protected:
      int width;
      int height;
};

// 派生类
class Rectangle: public Shape
{
   public:
      int getArea()
      { 
         return (width * height); 
      }
};

int main(void)
{
   Rectangle Rect;
 
   Rect.setWidth(5);
   Rect.setHeight(7);

   // 输出对象的面积
   cout << "Total area: " << Rect.getArea() << endl;

   return 0;
} 
```

> 继承规则

当一个类派生自基类，该基类可以被继承为 **public、protected** 或 **private** 几种类型。

我们几乎不使用 **protected** 或 **private** 继承，通常使用 **public** 继承。当使用不同类型的继承时，遵循以下几个规则：

- **公有继承（public）：**当一个类派生自**公有**基类时，基类的**公有**成员也是派生类的**公有**成员，基类的**保护**成员也是派生类的**保护**成员，基类的**私有**成员不能直接被派生类访问，但是可以通过调用基类的**公有**和**保护**成员来访问。
- **保护继承（protected）：** 当一个类派生自**保护**基类时，基类的**公有**和**保护**成员将成为派生类的**保护**成员。
- **私有继承（private）：**当一个类派生自**私有**基类时，基类的**公有**和**保护**成员将成为派生类的**私有**成员。

## 重载

> 函数重载

函数重载与Java类似

> 运算符重载

您可以重定义或重载大部分 C++ 内置的运算符。这样，您就能使用自定义类型的运算符。

重载的运算符是带有特殊名称的函数，函数名是由关键字 operator 和其后要重载的运算符符号构成的。与其他函数一样，重载运算符有一个返回类型和一个参数列表。

```c++
Box operator+(const Box&, const Box&);
```

```c++
#include <iostream>
using namespace std;

class Box
{
   public:

      double getVolume(void)
      {
         return length * breadth * height;
      }
      void setLength( double len )
      {
          length = len;
      }

      void setBreadth( double bre )
      {
          breadth = bre;
      }

      void setHeight( double hei )
      {
          height = hei;
      }
      // 重载 + 运算符，用于把两个 Box 对象相加
      Box operator+(const Box& b)
      {
         Box box;
         box.length = this->length + b.length;
         box.breadth = this->breadth + b.breadth;
         box.height = this->height + b.height;
         return box;
      }
   private:
      double length;      // 长度
      double breadth;     // 宽度
      double height;      // 高度
};
// 程序的主函数
int main( )
{
   Box Box1;                // 声明 Box1，类型为 Box
   Box Box2;                // 声明 Box2，类型为 Box
   Box Box3;                // 声明 Box3，类型为 Box
   double volume = 0.0;     // 把体积存储在该变量中
 
   // Box1 详述
   Box1.setLength(6.0); 
   Box1.setBreadth(7.0); 
   Box1.setHeight(5.0);
 
   // Box2 详述
   Box2.setLength(12.0); 
   Box2.setBreadth(13.0); 
   Box2.setHeight(10.0);
 
   // Box1 的体积
   volume = Box1.getVolume();
   cout << "Volume of Box1 : " << volume <<endl;
 
   // Box2 的体积
   volume = Box2.getVolume();
   cout << "Volume of Box2 : " << volume <<endl;

   // 把两个对象相加，得到 Box3
   Box3 = Box1 + Box2;

   // Box3 的体积
   volume = Box3.getVolume();
   cout << "Volume of Box3 : " << volume <<endl;

   return 0;
}
```

## 多态

```c++
#include <iostream> 
using namespace std;
 
class Shape {
   protected:
      int width, height;
   public:
      Shape( int a=0, int b=0)
      {
         width = a;
         height = b;
      }
      int area()
      {
         cout << "Parent class area :" <<endl;
         return 0;
      }
};
class Rectangle: public Shape{
   public:
      Rectangle( int a=0, int b=0):Shape(a, b) { }
      int area ()
      { 
         cout << "Rectangle class area :" <<endl;
         return (width * height); 
      }
};
class Triangle: public Shape{
   public:
      Triangle( int a=0, int b=0):Shape(a, b) { }
      int area ()
      { 
         cout << "Triangle class area :" <<endl;
         return (width * height / 2); 
      }
};
// 程序的主函数
int main( )
{
   Shape *shape;
   Rectangle rec(10,7);
   Triangle  tri(10,5);

   // 存储矩形的地址
   shape = &rec;
   // 调用矩形的求面积函数 area
   shape->area();

   // 存储三角形的地址
   shape = &tri;
   // 调用三角形的求面积函数 area
   shape->area();
   
   return 0;
}
```

## 命名空间

假设这样一种情况，当一个班上有两个名叫 Zara 的学生时，为了明确区分它们，我们在使用名字之外，不得不使用一些额外的信息，比如他们的家庭住址，或者他们父母的名字等等。

同样的情况也出现在 C++ 应用程序中。例如，您可能会写一个名为 xyz() 的函数，在另一个可用的库中也存在一个相同的函数 xyz()。这样，编译器就无法判断您所使用的是哪一个 xyz() 函数。

因此，引入了**命名空间**这个概念，专门用于解决上面的问题，它可作为附加信息来区分不同库中相同名称的函数、类、变量等。使用了命名空间即定义了上下文。本质上，命名空间就是定义了一个范围。

```c++
namespace namespace_name {
   // 代码声明
}

namespace_name::code;  // code 可以是变量或函数
```

```c++
#include <iostream>
using namespace std;

// 第一个命名空间
namespace first_space{
   void func(){
      cout << "Inside first_space" << endl;
   }
}
// 第二个命名空间
namespace second_space{
   void func(){
      cout << "Inside second_space" << endl;
   }
}
int main ()
{
 
   // 调用第一个命名空间中的函数
   first_space::func();
   
   // 调用第二个命名空间中的函数
   second_space::func(); 

   return 0;
}
```

> using指令

您可以使用 **using namespace** 指令，这样在使用命名空间时就可以不用在前面加上命名空间的名称。这个指令会告诉编译器，后续的代码将使用指定的命名空间中的名称。

```c++
#include <iostream>
using namespace std;

// 第一个命名空间
namespace first_space{
   void func(){
      cout << "Inside first_space" << endl;
   }
}
// 第二个命名空间
namespace second_space{
   void func(){
      cout << "Inside second_space" << endl;
   }
}
using namespace first_space;
int main ()
{
 
   // 调用第一个命名空间中的函数
   func();
   
   return 0;
}
```

using 指令也可以用来指定命名空间中的特定项目。例如，如果您只打算使用 std 命名空间中的 cout 部分，您可以使用如下的语句：

```c++
using std::cout;
```

## 模板

模板是泛型编程的基础，泛型编程即以一种独立于任何特定类型的方式编写代码。

模板是创建泛型类或函数的蓝图或公式。库容器，比如迭代器和算法，都是泛型编程的例子，它们都使用了模板的概念。

每个容器都有一个单一的定义，比如 **向量**，我们可以定义许多不同类型的向量，比如 `vector <int>` 或 `vector <string>`。

### 函数模板

- `template <typename type>`：这是定义函数模板的开始。它告诉编译器您将在函数中使用一个或多个类型参数，并为该类型参数指定一个名字“type”。其中，关键字“template”表示这是一个模板，而“typename”则表示我们要声明一个类型参数。
- `ret-type`: 这是函数的返回类型，它指定了函数将返回什么类型的值。例如，如果函数返回整数，那么ret-type应该是int。

- `func-name`: 这是函数的名称，您可以根据实际需要自定义一个名称。

- `parameter list`: 这是函数的参数列表，它描述了函数将接受哪些参数以及它们的类型。如果函数不需要任何参数，则可以将其留空。

```c++
template <typename type> ret-type func-name(parameter list)
{
   // 函数的主体
}
```

```c++
#include <iostream>
#include <string>

using namespace std;

template <typename T>
inline T const& Max (T const& a, T const& b) 
{ 
    return a < b ? b:a; 
} 
int main ()
{
 
    int i = 39;
    int j = 20;
    cout << "Max(i, j): " << Max(i, j) << endl; 

    double f1 = 13.5; 
    double f2 = 20.7; 
    cout << "Max(f1, f2): " << Max(f1, f2) << endl; 

    string s1 = "Hello"; 
    string s2 = "World"; 
    cout << "Max(s1, s2): " << Max(s1, s2) << endl; 

   return 0;
}
```

### 类模板

```c++
template <class type> class class-name {
.
.
.
}
```

```c++
#include <iostream>
#include <vector>
#include <cstdlib>
#include <string>
#include <stdexcept>

using namespace std;

template <class T>
class Stack { 
  private: 
    vector<T> elems;     // 元素 

  public: 
    void push(T const&);  // 入栈
    void pop();               // 出栈
    T top() const;            // 返回栈顶元素
    bool empty() const{       // 如果为空则返回真。
        return elems.empty(); 
    } 
}; 

template <class T>
void Stack<T>::push (T const& elem) 
{ 
    // 追加传入元素的副本
    elems.push_back(elem);    
} 

template <class T>
void Stack<T>::pop () 
{ 
    if (elems.empty()) { 
        throw out_of_range("Stack<>::pop(): empty stack"); 
    }
	// 删除最后一个元素
    elems.pop_back();         
} 

template <class T>
T Stack<T>::top () const 
{ 
    if (elems.empty()) { 
        throw out_of_range("Stack<>::top(): empty stack"); 
    }
	// 返回最后一个元素的副本 
    return elems.back();      
} 

int main() 
{ 
    try { 
        Stack<int>         intStack;  // int 类型的栈 
        Stack<string> stringStack;    // string 类型的栈 

        // 操作 int 类型的栈 
        intStack.push(7); 
        cout << intStack.top() <<endl; 

        // 操作 string 类型的栈 
        stringStack.push("hello"); 
        cout << stringStack.top() << std::endl; 
        stringStack.pop(); 
        stringStack.pop(); 
    } 
    catch (exception const& ex) { 
        cout << "Exception: " << ex.what() <<endl; 
    } 
}
```