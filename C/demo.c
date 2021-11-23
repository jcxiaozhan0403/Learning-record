#include <stdio.h>

int main()
{
	double oldHour;
	double oldMin;
	double newHour;
	double newMin;
	//	定义第一个时间
	scanf("%d %d",&oldHour,&oldMin); 
	//	定义第二个时间
	scanf("%d %d",&newHour,&newMin);
	
	double dex = newHour*60+newMin - (oldHour*60 + oldMin);
	printf("相差%d分钟",dex);
	return 0;
}
