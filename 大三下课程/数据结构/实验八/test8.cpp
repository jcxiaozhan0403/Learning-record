#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

// 打印数组
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

// 直接插入排序
void insertionSort(int arr[], int size) {
    int i, key, j;
    for (i = 1; i < size; i++) {
        key = arr[i];
        j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

// 希尔排序
void shellSort(int arr[], int size) {
    for (int gap = size / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < size; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;
        }
    }
}

// 冒泡排序
void bubbleSort(int arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
}

// 快速排序中的分区操作
int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return (i + 1);
}

// 快速排序
void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    const int size = 500;
    int arr[size];

    srand(time(0));

    // 生成随机数组
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 2000 + 1;
    }

    cout << "原始数组：" << endl;
    printArray(arr, size);

    // 直接插入排序
    clock_t start = clock();
    insertionSort(arr, size);
    clock_t finish = clock();
    double insertionSortTime = double(finish - start) / CLOCKS_PER_SEC;
    cout << "直接插入排序时间：" << insertionSortTime << " 秒" << endl;
    printArray(arr, size);

    // 重新生成随机数组
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 2000 + 1;
    }

    // 希尔排序
    start = clock();
    shellSort(arr, size);
    shellSort(arr, size);
    finish = clock();
    double shellSortTime = double(finish - start) / CLOCKS_PER_SEC;
    cout << "希尔排序时间：" << shellSortTime << " 秒" << endl;
    printArray(arr, size);

    // 重新生成随机数组
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 2000 + 1;
    }

    // 冒泡排序
    start = clock();
    bubbleSort(arr, size);
    bubbleSort(arr, size);
    finish = clock();
    double bubbleSortTime = double(finish - start) / CLOCKS_PER_SEC;
    cout << "冒泡排序时间：" << bubbleSortTime << " 秒" << endl;
    printArray(arr, size);

    // 重新生成随机数组
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 2000 + 1;
    }

    // 快速排序
    start = clock();
    quickSort(arr, 0, size - 1);
    quickSort(arr, 0, size - 1);
    finish = clock();
    double quickSortTime = double(finish - start) / CLOCKS_PER_SEC;
    cout << "快速排序时间：" << quickSortTime << " 秒" << endl;
    printArray(arr, size);

    return 0;
}
