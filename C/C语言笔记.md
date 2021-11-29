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