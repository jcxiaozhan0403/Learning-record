#include <iostream>

using namespace std;

// 定义二叉树节点
struct TreeNode {
    // 节点值
	int val;
	// 左子节点
    TreeNode* left;
	// 右子节点 
    TreeNode* right;
    // 构造函数
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// 建立二叉树
TreeNode* buildTree() {
    // 创建根节点，值为1
    TreeNode* root = new TreeNode(1);

    // 创建左右子节点，值分别为2和3
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);

    // 创建左子节点的左右子节点，值分别为4和5
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);

    // 创建右子节点的左右子节点，值分别为6和7
    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(7);

	// 返回根节点指针
    return root;
}

// 前序遍历
void preOrder(TreeNode* root) {
	// 如果节点为空，直接返回
    if (root == NULL) return;
    // 输出节点值
    cout << root->val << " ";
    // 遍历左子树
    preOrder(root->left);
    // 遍历右子树
    preOrder(root->right);
}

// 中序遍历
void inOrder(TreeNode* root) {
	// 如果节点为空，直接返回
    if (root == NULL) return;
    // 遍历左子树
    inOrder(root->left);
    // 输出节点值
    cout << root->val << " ";
    // 遍历右子树
    inOrder(root->right);
}

// 后序遍历
void postOrder(TreeNode* root) {
	// 如果节点为空，直接返回
    if (root == NULL) return;
    // 遍历左子树
    postOrder(root->left);
    // 遍历右子树
    postOrder(root->right);
    // 输出节点值
    cout << root->val << " ";
}

int main() {
    // 建立二叉树
    TreeNode* root = buildTree();

    // 前序遍历
    cout << "前序遍历：";
    preOrder(root);
    cout << endl;

    // 中序遍历
    cout << "中序遍历：";
    inOrder(root);
    cout << endl;

    // 后序遍历
    cout << "后序遍历：";
    postOrder(root);
    cout << endl;

    return 0;
}
