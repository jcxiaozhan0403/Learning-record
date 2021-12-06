## 基本结构
```c
#include <stdio.h>

int main()
{
	return 0;
}
```

## 代码规范
1. ANSI C要求所有的变量需要在程序最开始的时候定义，才能在程序中使用
2. C99 规定，变量可以在使用时再定义

## 变量输入
```c
#include <stdio.h>

int main()
{
	int price = 0;
    char a = '';
    char b = '';
    // 输入一个数字
	scanf("%d",&price);
    // 输入多个字符
    scanf("%c %c",&a,&b);

	printf("%d",price);
	return 0;
}
```

## 常量
常量使用const来修饰，表示这个量只能有一次赋值，一般常量都用大写字母表示
```c
const DEMO = 100;
```

## 猜数游戏
```c
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	int count = 0;
	int a = 0;
    // 将时间作为随机数生成
	srand(time(0));
    // 随机数对100取余，得到100以内的随机数
	int number = rand() % 100;
	
	printf("%d",number);
	
	while(a != number){
		scanf("%d",&a);
		if(a>number) {
			printf("大\n");
		}else if(number>a) {
			printf("小\n");
		} 
		count++; 
	}
	
	printf("恭喜您，猜了%d次，猜中了！！！",count);
	return 0;
} 
```

## 最大公约数
```c
#include <stdio.h>

int main()
{
	int a = 0;
	int b = 0;
	int t = 0;
	
	scanf("%d %d",&a,&b);

	while(b != 0){
		t = a%b;
		a = b;
		b = t;	
		printf("a=%d,b=%d,t=%d\n",a,b,t);	
	}
	printf("最大公约数：%d",a);
	return 0;
} 
```

## 给定条件的整数集
给定不超过6的正整数A，考虑从A开始的连续4个数字。请输出所有由他们组成的无重复数字的三位数。
```c
#include <stdio.h>

int main()
{
    int a;
    int i,j,k;
    int cnt=0;
    scanf("%d",&a);

    for(i=a;i<=a+3;i++){
        for(j=a;j<=a+3;j++){
            for(k=a;k<=a+3;k++){
                if((i!=j)&&(i!=k)&&(j!=k)){
                    cnt++;
                    printf("%d%d%d",i,j,k);
                    if(cnt==6){
                        printf("\n");
                        cnt=0;
                    }
                    else{
                        printf(" ");
                    }
                }
            }
        }
    }
    return 0;
}
```

## 水仙花数
```c
#include <stdio.h>

int main()
{
	int i;
	int a,b,c;
	
	for(i = 100; i<=999; i++){
		
		//个位 
		a = i%10;
		
		//十位 
		b = i/10%10;
		
		//百位
		c = i/10/10;
		
		if(i == a*a*a + b*b*b + c*c*c) {
			printf("%d\n",i);
		} 
	} 
	
	return 0;
}
```

## 九九乘法表
```c
#include <stdio.h>

int main()
{
	int i,j;
	
	/*
	1*1 = 1
	1*2 = 2 2*2 = 4
	1*3 = 3 2*3 = 6 3*3 = 9	
	*/
	for(i = 1; i<=9; i++) {
		for(j = 1; j<=i; j++){
			printf("%d*%d=%d ",j,i,j*i);
			if(i == j) {
				printf("\n");
			} 
		}
	}
	
	return 0;
}
```

## 数据结构
- 整数：char、short、int、long、long long
- 浮点数：float、double、long double
- 逻辑：bool
- 指针
- 自定义类型

用以0开始的数字字面量表示8进制
用以0x开始的数字面量表示16进制

sizeof：给出某个类型或变量在内存中所占据的字节数
```c
double i;
sizeof(int);
sizeof(i);
```

补码计算：原码取反+1

unsigned 将字面量以纯二进制进行计算，主要是后面位运算会使用到
```c
unsigned char c;
```

## 格式化输入
```
%u unsigned
%lu unsigned long long
%hd short
%d 整数类型
%ld long long
%f 单精度浮点数
%lf 双精度浮点数
%o 以8进制的方式进行读取
%x 以16进制的方式进行读取
%s 读取字符串
%7s 数字规定了，能够读取到的最多字符数量
```

## 格式化输出
```
%d 整数类型
%f 单精度浮点数
%f 双精度浮点数
%o 以8进制输出
%x 以16进制输出
%p 输出内存地址
%e 以科学计数方式输出浮点数
%c 整型数的参数会被转成unsigned char 型打印出
%s 指向字符串的参数会被逐字输出，直到出现NULL 字符为止
```

## 函数
```c
#include <stdio.h>

//函数原型 
void sum(int a,int b);

int main()
{	
	//函数调用
	sum(99,88);	
	return 0; 
}

void sum(int a,int b){
	printf("%d",a+b);
}
```

## 数组
数组的定义
```c
// 只定义，不赋值，在使用前需要用for循环给数组的每个元素赋值
int a[10];

// 定义并赋值
int b[] = {1,2,5,7,3,22,4,6,7,8,3};
```
搜索函数
```c
/**
@param key 要查找的数字
@param a 需要找寻的数组

*/
int search(int key,int a[],int length);
```

二维数组可以没有行，但是必须要有列
```c
int demo[][3] = {{1,2,3},{5,6,7}};
```

## 指针
取变量地址
```c
int i = 0;
printf("%p",&i);
```

函数参表中的数组实质上就是指针，数组变量本身表达地址，所以
- int a[10];int*p = a //无需用&取地址
- 但是数组的单元表达的是变量，需要用&取地址
- a == &a[0]

### 指针与const
- 指针本身是const
```c
int i = 99;
int* const q = &i;
q++; //error
*p = 200; //ok
```
- 指针指向的值为const
```c
int i = 99;
const int *q = &i;
*p++; //error
q++;  //ok
i = 22; //ok
```

判断类型：如果const在`*`的前面为`指针指向的值为const`类型，const在`*`后面为`指针本身是const`类型

### 指针之间的类型转换
不同类型的指针不能直接相互赋值，可以转换类型赋值，实际上并没有改变指针的类型，只是用void的眼光去看待这个指针
```c
int i = 22;
int *p = &i;
void*q = (void*)p;
```

### 0地址
- 内存中存在一个0地址，0通常是一个不能操作的地址
- 指针不应该具有0值
- 在指针初始化时，通常赋予0值
- NULL是一个预定定义的符号，表示0地址

### 动态内存分配
在C99以前，没有数组的概念，就需要手动分配一段连续地内存地址
```c
// 向malloc申请的空间的大小是以字节位单位的
// 返回的结果是void*，需要类型转换为自己需要的类型
void* malloc(size_t size);
```
```c
#include <stdlib.h>
int *a = (int*)malloc(n*sizeof(int));

// 归还内存空间
free(a);
```
如果空间用完了，则申请失败，返回0
```c
#include <stdlib.h>
int *a = (int*)malloc(n*sizeof(int));

// 归还内存空间
free(a);
```
ANSIC标准下归还的内存空间需要跟分配出来的一致，不然会报错，C99不会
```c
void *p = malloc(10*1024*1024);

printf("%p\n",p); 

p++;
printf("%p",p);

free(p);
```
free可以归还一个0地址,函数会判断参数为NULL的时候，不做事情
```c
free(0);
free(NULL);
```

## 字符串
- 字符串是以数组的形式来定义的
- 两个相邻的字符串如果中间没有任何符号，就会被自动拼接成一个字符串
- 用遍历数组的方式可以遍历字符串
- 不能用运算符对字符串进行操作

### putchar和getchar
putchar写入单个字符
getchar读取单个字符
本应是单个写入读取的，但是在我们终端输入时，输入内容会先存在终端shell缓冲区，在我们按下回车时，才会发送到程序
在windows下CTRL+Z终止写入，系统会自动在末尾补-1代表输入结束，在Linux为CTRL+D
```c
int main()
{	
	int ch;
	
	while((ch = getchar()) != EOF) {
		putchar(ch);
	}
	
	printf("EOF");
	return 0;
}
```

## string.h函数库
strlen：返回数组长度(不包括`/0`)
```c
#include <stdio.h>
#include <string.h>

int main()
{	
	char str[] = "Hello World";
	
	printf("%d",strlen(str));
	
	return 0;
}
```
strcmp：比较两个字符串，如果字符串a和b相等，返回0，如果字符串`a>b`返回1，如果字符串`a<b`返回-1，
```c
#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "abc";
	char b[] = "Abc";
	
	printf("%d",strcmp(a,b));
	
	return 0;
}
```
strcpy：字符串复制，参数一为目标数组，参数二为原数组
```c
#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "abcgggg";
	char b[] = "avc";
	
	printf("%s",strcpy(b,a));
	
	return 0;
}
```
strcat：字符串拼接，a字符串拼接到b字符串后面，返回b
```c
#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "abc";
	char b[] = "xxabc";
	
	printf("b长度=%d\n",strlen(b));
	
	printf("%s\n",strcat(b,a));
	
	printf("b长度=%d\n",strlen(b));
	
	printf("%s\n",b);
	
	return 0;
}
```
因为字符串的拼接和复制都存在安全问题，所以有了以下三个衍生函数
- strncpy：字符串复制，参数一为目标数组，参数二为原数组,参数三为复制的位数，多余部分截断
- strncat：字符串拼接，参数一为拼接字符串的头部，参数二为拼接字符串的尾部，参数三为拼接后字符串的位数，多余部分截断
- strncmp：字符串比较，参数一为第一个字符串，参数二为第二个字符串，参数三为比较前几位

### 字符串查找
strchr：在字符串中从左往右查找字符，参数一为字符串，参数二为要查找的字符，返回字符第一次出现的位置的指针
```c
#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "bcxxxaxxxxsnks";
	
	char *p = strchr(a,'a');
	
	printf("%s",p);
	
	return 0;
}
```
strrchr：在字符串中从右往左查找字符，参数一为字符串，参数二为要查找的字符，返回字符第一次出现的位置的指针，找不到则返回NULL
```c
#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "bcxxxaxxxxsnks";
	
	char *p = strchr(a,'x');
	
	printf("%s",p);
	
	return 0;
}
```
strstr：在字符串中查找另一个字符串，返回第一次出现位置的指针，找不到则返回NULL
```c
#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "aaaahelloxxxxhellohdasldhasld";
	
	char *p = strstr(a,"hello");
	
	printf("%s",p);
	
	return 0;
}
```
strcasestr：忽略大小写，在字符串中查找另一个字符串，返回第一次出现位置的指针，找不到则返回NULL
```c
#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "aaaaHelloxxxxHELLOhdasldhasld";
	
	char *p = strstr(a,"hello");
	
	printf("%s",p);
	
	return 0;
}
```

## 枚举
在实际编程中，有些数据的取值往往是有限的，只能是非常少量的整数，并且最好为每个值都取一个名字，以方便在后续代码中使用，比如一个星期只有七天，一年只有十二个月，一个班每周有六门课程等。
```c
#include <stdio.h>

int main()
{	
	int myColor; 
	
	enum COLOR { RED, YELLOW, GREEN };
	
	scanf("%d",&myColor);
	
	switch(myColor) {
		case RED: printf("红色"); break;
		case YELLOW: printf("黄色"); break;
		case GREEN: printf("绿色"); break;
	}
	
	return 0;
}
```
声明枚举量的时候可以指定值
```c
// 这里RED被赋值为1，YELLOW因为没有手动赋值，就会被系统定义为2，BULE会被系统定义为6
enum COLOR { RED=1, YELLOW, GREEN=5, BULE};
```

## 结构类型
结构体是一种集合，它里面包含了多个变量或数组，它们的类型可以相同，也可以不同，每个这样的变量或数组都称为结构体的成员
简单来说，类似于Java的类，定义一个模板，可以创造多个实例出来，每一个实例都是不同的
```c
#include <stdio.h>

int main()
{	
	struct demo{
		int x;
		int y;
	}; 
	
	struct demo myeg1;
	struct demo test = {1,2};
	
	myeg1.x = 5;
	myeg1.y = 2;
	
	int *t = &myeg1;
	
	printf("%d",t[1]);
	
	return 0;
}
```
可以用`->`来表示指针所指的结构变量中的成员
```c
#include <stdio.h>

int main()
{	
	struct date {
		int month;
		int day;
		int year;
	} myday;
	
	struct date *p = &myday;
	
	(*p).month = 12;
	p -> month = 56;
	
	printf("%d",myday.month);
	
	return 0;
}
```

## 联合
联合的使用，类似于结构体，只是所有的实例共享一块空间，所以，先定义的变量会被后定义的变量覆盖
```c

```

## 数据类型别名
c语言提供了一个叫typedef的功能来为一个数据类型定义一个别名
```c
#include <stdio.h>

int main()
{	
	typedef int Demo;
	
	Demo a=0,b;
	Demo numbers[11];
	
	printf("%d",a); 
	
	return 0;
}
```
简化结构体的使用
```c
#include <stdio.h>

int main()
{	
	typedef struct date {
		int month;
		int day;
		int year;
	} Date;
	
	Date test;
	test.month = 12;
	test.day = 6;
	test.year = 2021;
	
	
	printf("%d",test.month); 
	
	return 0;
}
```
