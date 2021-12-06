#include <stdio.h>

int main()
{	
	union data{
	    int n;
	    char ch;
	    short m;
	} a;
	
	a.n = 0x40;
	a.ch = 'h';
    printf("%X, %c, %hX\n", a.n, a.ch, a.m);
	
	
	
	return 0;
}
