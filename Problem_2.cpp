979. Distribute Coins in Binary Tree

TC O(n)
SC O(n)

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
    int giveCoin(TreeNode * root,int &ans)
    {
        if(root==NULL)
        {
            return 0;
        }
        else
        {
            int temp1 = giveCoin(root->left,ans);
            int temp2 = giveCoin(root->right,ans);
            ans += abs(temp1);
            ans += abs(temp2);
            return (temp1 + temp2 + root->val - 1);
        }
    }
    int distributeCoins(TreeNode* root) {
        int ans=0;
        int temp = giveCoin(root,ans);
        cout<<temp<<endl;
        return ans;
    }
};
