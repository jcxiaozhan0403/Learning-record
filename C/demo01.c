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
