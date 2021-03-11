//Time - O(n)
//space - O(n)

class Solution {
public:
    int moves = 0;
    int distributeCoins(TreeNode* root) {
        if(root == NULL) return 0;
        dfs(root);
        return moves;
    }
    
    int dfs(TreeNode* root){
        if(root == NULL) return 0;
        
        int spareCoins = root->val - 1;
        spareCoins += dfs(root->left);
        spareCoins += dfs(root->right);
        moves += abs(spareCoins);
        return spareCoins;
    }
};