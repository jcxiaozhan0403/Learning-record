#include <iostream>
#include <cstring>
using namespace std;

const int MAXN = 100;
// 邻接矩阵存储图
bool graph[MAXN][MAXN];
// 标记节点是否被访问过
bool visited[MAXN];
// n 表示节点数，m 表示边数
int n, m;

// 深度优先遍历
void dfs(int u) {
	// 标记当前节点已被访问
    visited[u] = true;
    // 输出当前节点
    cout << u << " ";
    // 枚举与当前节点相邻的节点
    for (int v = 0; v < n; v++) {
    	// 如果与当前节点相邻的节点未被访问过
        if (graph[u][v] && !visited[v]) {
        	// 继续深度优先遍历该节点
            dfs(v); 
        }
    }
}

// 不使用 queue 的广度优先遍历
void bfs(int u) {
	// 定义一个队列 q
    int q[MAXN];
    // head 和 tail 分别指向队首和队尾
    int head = 0, tail = 0;
    // 标记起始节点已被访问
    visited[u] = true;
    // 将起始节点加入队列
    q[tail++] = u;
    // 当队列非空时
    while (head < tail) {
    	// 取出队首元素
        int x = q[head++];
        // 输出当前节点
        cout << x << " ";
        // 枚举与当前节点相邻的节点
        for (int v = 0; v < n; v++) {
        	// 如果与当前节点相邻的节点未被访问过
            if (graph[x][v] && !visited[v]) {
            	// 标记该节点已被访问
                visited[v] = true;
                // 将该节点加入队列
                q[tail++] = v;
            }
        }
    }
}

int main() {
	// 输入节点数和边数
    cin >> n >> m;

    // 初始化邻接矩阵和标记数组
    memset(graph, false, sizeof(graph)); 
    memset(visited, false, sizeof(visited)); 

    // 输入边的信息，并在邻接矩阵中添加边
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v; 
        graph[u][v] = graph[v][u] = true;
    }

    // 深度优先遍历
    cout << "DFS: ";
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i);
        }
    }
    cout << endl;

    // 广度优先遍历
    // 重置标记数组
    memset(visited, false, sizeof(visited));
    cout << "BFS: ";
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            bfs(i);
        }
    }
    cout << endl;

    return 0;
}
