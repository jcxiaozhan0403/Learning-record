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
