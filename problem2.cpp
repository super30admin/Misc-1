/*
// Time Complexity : O(N) number of nodes
// Space Complexity : O(N) number of nodes
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<math.h>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode* left{};
    TreeNode* right{};
    TreeNode():val(0),left(nullptr),right(nullptr){}
    TreeNode(int x):val(x),left(nullptr),right(nullptr){}
    TreeNode(int x, TreeNode* left,TreeNode* right):val(x),left(left),right(right){}
};

class Solution {
public:
    int moves{};
    int dfs(TreeNode* node){
        if(node == NULL) return 0;
        int root_coins{},left_coins{},right_coins{},total_coins{};
        root_coins = node->val - 1;
        left_coins = dfs(node->left);
        right_coins = dfs(node->right);
        total_coins = root_coins + left_coins + right_coins;
        moves+=abs(total_coins);
        return total_coins;
        
    }
    int distributeCoins(TreeNode* root) {
        moves+=abs(dfs(root));
        return moves;
    }
};