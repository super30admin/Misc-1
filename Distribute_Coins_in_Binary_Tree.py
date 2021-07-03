# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        if not root :
            return 0
        
        self.result =0
        self.dfs(root)
        return self.result
    
    def dfs(self,root):
        
        #base
        if not root:
            return 0
        #logic
        sparecoin = root.val-1
        sparecoin += self.dfs(root.left)
        sparecoin += self.dfs(root.right)
        self.result += abs(sparecoin)
        return sparecoin
