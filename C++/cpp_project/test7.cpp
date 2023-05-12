#include <iostream>
//rand和srand函数
#include <cstdlib>
//time函数和clock函数
#include <ctime>
//setprecision函数
#include <iomanip>
//sort函数 
#include <algorithm>

using namespace std;

//顺序查找算法
int sequentialSearch(int numbers[], int n, int k) {
    for (int i = 0; i < n; i++) {
        if (numbers[i] == k) {
            return i;
        }
    }
    return -1;
}

//折半查找算法
int binarySearch(int numbers[], int n, int k) {
    int left = 0, right = n - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (numbers[mid] == k) {
            return mid;
        } else if (numbers[mid] < k) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

int main() {
    const int n = 10000;
    int numbers[n];
    //初始化随机数种子
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
    	//生成0~99999之间的随机数
        numbers[i] = rand() % 100000;
    }
    //生成0~99999之间的随机数作为要查找的值
    int k = rand() % 100000;

    //顺序查找
    //记录查找开始时间
    clock_t start = clock();
    //定义顺序查找用时变量
    double sequentialTime = 0;
    //重复执行1000次
    for (int i = 0; i < 1000; i++) {
        sequentialSearch(numbers, n, k);
    }
    //计算顺序查找用时，单位为秒
    sequentialTime = (clock() - start) * 1000.0 / CLOCKS_PER_SEC / 1000.0;

    //折半查找
    //将数组排序
    sort(numbers, numbers + n);
    //记录查找开始时间
    start = clock();
    //定义折半查找用时变量
    double binaryTime = 0;
    //重复执行1000次
    for (int i = 0; i < 1000; i++) { 
        binarySearch(numbers, n, k);
    }
    //计算折半查找用时，单位为秒
    binaryTime = (clock() - start) * 1000.0 / CLOCKS_PER_SEC / 1000.0;

    //输出结果
    cout << setprecision(3) << fixed;//设置输出精度
    cout << "顺序查找用时：" << sequentialTime << " s" << endl;
    cout << "折半查找用时：" << binaryTime << " s" << endl;

    return 0;
}
