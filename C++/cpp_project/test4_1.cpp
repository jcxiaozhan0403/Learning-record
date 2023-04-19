#include <iostream>
#include <cstring>

using namespace std;

// 求字符串长度
int getLength(const char* str) {
    int length = 0;
    //遍历获取长度 
    while (*str != '\0') {
        length++;
        str++;
    }
    return length;
}

// 字符串拼接
void concatenate(char* str1, char* str2) {
    strcat(str1, str2);
    cout << "拼接结果：" << str1 << endl;
}

// 比较大小
void compare(char* str1, char* str2) {
    int result = strcmp(str1, str2);
    if (result == 0) {
        cout << "两个字符串相等" << endl;
    }
    else if (result > 0) {
        cout << "第一个字符串大于第二个字符串" << endl;
    }
    else {
        cout << "第一个字符串小于第二个字符串" << endl;
    }
}

int main() {
    // 系统定义的字符串
    char str1[] = "Hello, world!";
    cout << "系统定义的字符串是：" << str1 << endl;

    // 用户输入的字符串
    cout << "请输入另一个字符串：";
    char str2[100];
    cin >> str2;
    cout << "您输入的字符串是：" << str2 << endl;

    // 求字符串长度
    int length1 = getLength(str1);
    int length2 = getLength(str2);
    cout << "系统定义的字符串长度为：" << length1 << endl;
    cout << "您输入的字符串长度为：" << length2 << endl;

    // 字符串拼接
    char str3[200];
    strcpy(str3, str1);
    concatenate(str3, str2);

    // 比较大小
    compare(str1, str2);

    return 0;
}
