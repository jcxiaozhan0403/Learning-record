## 基本结构
```c
#include <stdio.h>

int main()
{
	return 0;
}
```

## 格式化输入
```
%d 整数类型
%f 单精度浮点数
%lf 双精度浮点数
```

## 格式化输出
```
%d 整数类型
%f 单精度浮点数
%f 双精度浮点数
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