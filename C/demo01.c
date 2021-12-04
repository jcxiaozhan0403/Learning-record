#include <stdio.h>

int main()
{	
	int month;
	
	char *months[] = {
		"January",
		"February",
		"March",
		"April",
		"May",
		"June",
		"July",
		"August",
		"September",
		"October",
		"November",
		"December"
	};
	
	scanf("%d",&month); 
	printf("%s",months[month-1]);
	return 0;
}
