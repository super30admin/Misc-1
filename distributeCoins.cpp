/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int moves;
    int helper (TreeNode* root) {
        if (root==NULL) return 0;
        int extra=(root->val)-1;
        
        extra+=helper(root->left);
        extra+=helper(root->right);
        moves+=abs(extra);
        
        return extra;
    }
    int distributeCoins(TreeNode* root) {
        moves=0;
        helper(root);
        return moves;
    }
};