#include <iostream>
#include <vector>
#include <random>
#include <chrono>
using namespace std;
using namespace chrono;

// 直接插入排序
void insertionSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 1; i < n; ++i) {
    	// 选取当前元素作为插入元素
        int key = arr[i];
        int j = i - 1;
        // 向前查找插入位置并移动元素
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        // 插入元素到正确位置
        arr[j + 1] = key;
    }
}

// 希尔排序
void shellSort(vector<int>& arr) {
    int n = arr.size();
    // 根据增量进行分组
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; ++i) {
        	// 选取当前元素作为插入元素
            int temp = arr[i];
            int j;
            // 向前查找插入位置并移动元素
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            // 插入元素到正确位置
            arr[j] = temp;
        }
    }
}

// 冒泡排序
void bubbleSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n - 1; ++i) {
    	// 依次比较相邻的元素并交换
        for (int j = 0; j < n - i - 1; ++j) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
}

// 快速排序
int partition(vector<int>& arr, int low, int high) {
	// 选取最后一个元素作为基准
    int pivot = arr[high]; 
    int i = low - 1;
    for (int j = low; j <= high - 1; ++j) {
    	// 将小于基准的元素放到左边
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    // 将基准放到正确位置
    swap(arr[i + 1], arr[high]);
    return (i + 1);
}

void quickSort(vector<int>& arr, int low, int high) {
    if (low < high) {
    	// 划分数组，并获取基准的位置
        int pi = partition(arr, low, high);
        // 递归地对左半部分进行快速排序
        quickSort(arr, low, pi - 1);
        // 递归地对右半部分进行快速排序
        quickSort(arr, pi + 1, high);
    }
}

// 生成随机数
vector<int> generateRandomNumbers(int count, int minValue, int maxValue) {
    vector<int> numbers(count);
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<int> dis(minValue, maxValue);
    for (int i = 0; i < count; ++i) {
        numbers[i] = dis(gen);
    }
    return numbers;
}

int main() {
    // 生成随机数
    vector<int> numbers = generateRandomNumbers(500, 1, 2000);

    // 直接插入排序
    vector<int> numbersInsertion = numbers;
    auto startInsertion = high_resolution_clock::now();
    insertionSort(numbersInsertion);
    auto stopInsertion = high_resolution_clock::now();
    auto durationInsertion = duration_cast<microseconds>(stopInsertion - startInsertion);
    cout << "直接插入排序所用时间（微秒）: " << durationInsertion.count() << endl;

    // 希尔排序
    vector<int> numbersShell = numbers;
    auto startShell = high_resolution_clock::now();
    shellSort(numbersShell);
    auto stopShell = high_resolution_clock::now();
    auto durationShell = duration_cast<microseconds>(stopShell - startShell);
    cout << "希尔排序所用时间（微秒）: " << durationShell.count() << endl;

    // 冒泡排序
    vector<int> numbersBubble = numbers;
    auto startBubble = high_resolution_clock::now();
    bubbleSort(numbersBubble);
    auto stopBubble = high_resolution_clock::now();
    auto durationBubble = duration_cast<microseconds>(stopBubble - startBubble);
    cout << "冒泡排序所用时间（微秒）: " << durationBubble.count() << endl;

    // 快速排序
    vector<int> numbersQuick = numbers;
    auto startQuick = high_resolution_clock::now();
    quickSort(numbersQuick, 0, numbersQuick.size() - 1);
    auto stopQuick = high_resolution_clock::now();
    auto durationQuick = duration_cast<microseconds>(stopQuick - startQuick);
    cout << "快速排序所用时间（微秒）: " << durationQuick.count() << endl;

    return 0;
}

