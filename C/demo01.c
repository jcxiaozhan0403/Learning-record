#include <stdio.h>

int main()
{	
	int i = 99;
	int j = 100;
	int* const q = &i;
	q++; 
	
	printf("%d",*q);
	printf("---------------------");
	printf("%x",&j);
	
	
	return 0; 
}
