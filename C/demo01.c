#include <stdio.h>
#include <string.h>

int main()
{	
	char a[] = "aaaaHelloxxxxhellohdasldhasld";
	
	char *p = strstr(a,"hello");
	
	printf("%s",p);
	
	return 0;
}
