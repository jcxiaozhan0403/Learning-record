#include <stdio.h>

int main()
{	
	printf("%s\t%d\n",__FILE__,__LINE__);
	printf("%s\t%s\t%d\n",__DATE__,__TIME__,__STDC__);
	
	return 0;
}
