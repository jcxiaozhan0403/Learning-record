#include <iostream>
#include <cstring>

using namespace std;

int BF_Search(char* s, char* p) {
	//传入主串和子串，获取各自长度信息 
    int s_len = strlen(s);
    int p_len = strlen(p);

	//在主串中遍历每一个可能的起始位置，直到最后一个可能的位置为止。
	//由于子串长度不超过主串长度，因此可以保证这些起始位置是合法的
    for (int i = 0; i <= s_len - p_len; i++) {
    	//在每个起始位置上，使用循环遍历子串的每一个字符，并比较它与主串对应位置的字符是否相等。
		//如果在某个位置发现不匹配的字符，那么就退出循环。 
        int j;
        for (j = 0; j < p_len; j++) {
            if (s[i + j] != p[j]) {
                break;
            }
        }
        //如果在子串的每个位置上都找到了与主串对应位置相等的字符，则表示子串匹配成功，返回当前起始位置 i。
        if (j == p_len) {
            return i;
        }
    }
    //如果在主串中没有找到匹配的子串，则返回 -1，表示匹配失败。
    return -1;
}

int main() {
    char s[100], p[100];
    cout << "请输入主串: ";
    cin >> s;
    //忽略输入流中的回车符
    cin.ignore();
    cout << "请输入子串: ";
    cin.getline(p, 100);

    int pos = BF_Search(s, p);
    if (pos == -1) {
        cout << "无法匹配" << endl;
    }
    else {
        cout << "匹配位置: " << pos << endl;
    }

    return 0;
}
