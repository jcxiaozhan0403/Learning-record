#include <iostream>
#include <cstring>
#include <string.h>

using namespace std;
const int StackSize = 10;           //10鏄ず渚嬫€х殑鏁版嵁锛屾牴鎹疄闄呴棶棰樺叿浣撳畾涔�
template<typename DataType>         //瀹氫箟妯℃澘绫籗eqStack
class SeqStack {
public:
    SeqStack();                 //鏋勯€犲嚱鏁帮紝鍒濆鍖栦竴涓┖鏍�
    ~SeqStack();                //鏋愭瀯鍑芥暟
    void Push(DataType x);      //鍏ユ爤鎿嶄綔锛屽皢鍏冪礌x鍏ユ爤
    DataType Pop();             //鍑烘爤鎿嶄綔锛屽皢鏍堥《鍏冪礌寮瑰嚭
    DataType GetTop();          //鍙栨爤椤跺厓绱狅紙骞朵笉鍒犻櫎锛�
    int Empty();                //鍒ゆ柇鏍堟槸鍚︿负绌�
    int Precedence(char ch);
    int Operate(int x, char ch, int y);


private:
    DataType data[StackSize];    //瀛樻斁鏍堝厓绱犵殑鏁扮粍
    int top;                    //娓告爣锛屾爤椤舵寚閽堬紝涓烘爤椤跺厓绱犲湪鏁扮粍涓殑涓嬫爣
};

template<typename DataType>
SeqStack<DataType>::SeqStack() {
    top = -1;
}

template<typename DataType>
SeqStack<DataType>::~SeqStack() {

}

//鍏ユ爤鎿嶄綔锛屽皢鍏冪礌x鍏ユ爤
template<typename DataType>
void SeqStack<DataType>::Push(DataType x) {
    if (top == StackSize - 1) throw "涓婃孩";
    top++;
    data[top] = x;
}

//鍑烘爤鎿嶄綔锛屽皢鏍堥《鍏冪礌寮瑰嚭
template<typename DataType>
DataType SeqStack<DataType>::Pop() {
    DataType datapop;
    if (top == -1) throw "涓嬫孩";
    datapop = data[top--];
    return datapop;
}

//鍙栨爤椤跺厓绱狅紙骞朵笉鍒犻櫎锛�
template<typename DataType>
DataType SeqStack<DataType>::GetTop() {
    if (top != -1)
        return data[top];
}

template<typename DataType>
int SeqStack<DataType>::Empty() {
    if (top == -1)
        return 1;
    else
        return 0;
}

//鍒ゆ柇浼樺厛绾�
template<typename DataType>
int SeqStack<DataType>::Precedence(char ch) {
    int z = 0;
    switch (ch) {
        case '+':
            z = 1;
            break;
        case '-':
            z = 1;
            break;
        case '*':
            z = 2;
            break;
        case '/':
            z = 2;
            break;
        case '#':
            z = 0;
            break;
        case '=':
            z = 0;
            break;
        case '(':
            z = 3;
            break;
        default:
            printf("error!\n");
    }
    return z;
}

//杩涜鐩稿姞
template<typename DataType>
int SeqStack<DataType>::Operate(int x, char ch, int y) {
    int z = 0;
    switch (ch) {
        case '+':
            z = x + y;
            break;
        case '-':
            z = x - y;
            break;
        case '*':
            z = x * y;
            break;
        case '/':
            z = x / y;
            break;
        default:
            printf("error!\n");
    }
    return z;
}




int main() {
    SeqStack<int> OPTR{}, OPND{};   //瀹氫箟椤哄簭鏍堝彉閲廠  //OPTR瀛樺偍杩愮畻绗︼紝OPND瀛樺偍鎿嶄綔鏁板拰杩愮畻缁撴灉
    char w;
    int x, y, z;
    char op[9];
    strcpy_s(op,"+-*/()=#");   //op涓鸿繍绠楃闆嗗悎
    //init(OPTR);
    OPTR.Push('#');

    //init(OPND);

    //鏍堝垵濮嬪寲锛屽苟鍦ㄨ繍绠楃鏍堢殑鏍堝簳鍘嬪叆琛ㄨ揪寮忓乏杈硅櫄璁剧殑瀛楃鈥�#鈥�
    w = getchar();                 //浠庣粓绔鍏ヤ竴涓瓧绗�

    while (!((w == '#') && (OPTR.GetTop() == '#'))) {
        if (!strchr(op, w)) {
            OPND.Push(atoi(&w));
            w = getchar();        //鎿嶄綔鏁拌繘鎿嶄綔鏁版爤
        } else if (OPTR.Precedence(w) > OPTR.Precedence(OPTR.GetTop())) {   //姣旇緝浼樺厛鏁�
            OPTR.Push(w);
            w = getchar();
        } else {
            char theta;
            theta = OPTR.Pop();  //寮瑰嚭鏍堥《杩愮畻绗�
            y = OPND.Pop();
            x = OPND.Pop();   //杩炵画寮瑰嚭涓や釜鎿嶄綔鏁�
            z = OPND.Operate(x, theta, y);    //杩涜杩愮畻x胃y

            OPND.Push(z);     //灏嗚繍绠楃粨鏋滃帇鍏ユ搷浣滄暟鏍�
        }
    }
    cout << z << endl;
    return (OPND.GetTop());  //浠庢搷浣滄暟鏍堥《鍙栧嚭琛ㄨ揪寮忚繍绠楃粨鏋滆繑鍥�
}