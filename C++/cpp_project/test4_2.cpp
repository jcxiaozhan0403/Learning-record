#include <iostream>
#include <cstring>
using namespace std;

const int N = 31; // 定义常量N为31，用于存放幻方的大小

int a[N][N]; // 定义二维数组a存放幻方的值

int main()
{
	// 定义n存放幻方的大小
    int n;
    // 输入幻方的大小
    cout << "请输入幻方大小n（1<= n <= 30）：";
	cin >> n;

	// 将二维数组a全部置0
    memset(a, 0, sizeof a);

	// 定义初始位置为第一行的中间位置
    int x = n / 2, y = n - 1;
    // 将1填入初始位置
    a[x][y] = 1;

	// 从2开始循环填充幻方
    for (int i = 2; i <= n * n; i++) {
    	// 计算下一个位置
        int nx = (x - 1 + n) % n, ny = (y + 1) % n;
        // 如果下一个位置已经填有数
        if (a[nx][ny]) {
        	// 则填在当前位置的下面
            x = (x + 1) % n;
        } else {
        	// 否则填在计算出来的下一个位置
            x = nx, y = ny;
        }
        // 将当前数填入幻方中
        a[x][y] = i;
    }

	// 循环输出幻方
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
