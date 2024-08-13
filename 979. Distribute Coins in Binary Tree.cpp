/*
Time: O(n)
Space: O(h) [stack space]

DFS:
 Transfer needed in each subtree = transfer in left subtree + transfer in right subtree + difference between this subtree size and coins in this subtree
*/
class Solution {
public:

    //returns {subtree_sz, coins_in_subtree, coins_change_neeeded}
    vector<int> dfs(TreeNode* node){
        if(node == nullptr)  return {0, 0, 0};

        int subtree = 0, coins = 0, transfer = 0;
        auto l = dfs(node->left);
        auto r = dfs(node->right);

        subtree = l[0] + r[0] + 1; //1 for this node
        coins = l[1] + r[1] + node->val;  //coins in left subtree, right subtree and this node 
        transfer = l[2] + r[2] + abs(coins - subtree); //transfer needed = transfer in left subtree + transfer in right subtree + difference between subtree size and coins in subtree

        return {subtree, coins, transfer};
    }

    int distributeCoins(TreeNode* root) {
        return dfs(root)[2];
    }
};
