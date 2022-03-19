#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "abcshfjasfaslfa";
	
	printf("原数组：%s\n",a);
	strrev(a);
	printf("颠倒后：%s\n",a);
	
	return 0;
}
