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
不同类型的指针不能直接相互赋值，可以转换类型赋值
```c
int i = 22;
int *p = &i;
void*q = (void*)p;
```