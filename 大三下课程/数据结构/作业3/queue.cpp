#include <iostream>
#include <queue>
#include <chrono>
#include <thread>

using namespace std;

int main() {
    queue<int> patientQueue;

    // 获取病人编号并排队
    while (true) {
        cout << "请输入病人编号（输入0结束）：" << endl;
        int patientId;
        cin >> patientId;
        if (patientId == 0) {
            break;
        }
        patientQueue.push(patientId);
    }

    // 模拟看病过程
    while (!patientQueue.empty()) {
        int currentPatient = patientQueue.front();
        patientQueue.pop();

        // 呼叫当前病人看病
        cout << "请病人 " << currentPatient << " 就诊" << endl;

        if (!patientQueue.empty()) {
            // 提示下一个准备看病的病人编号
            cout << "下一个病人准备就诊，编号为：" << patientQueue.front() << endl;
        }

        // 暂停2秒钟
        this_thread::sleep_for(chrono::seconds(2));
    }

    cout << "所有病人已看完。" << endl;

    return 0;
}
