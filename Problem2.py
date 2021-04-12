"""
Time Complexity : O(n) 
Space Complexity : O(n)  worst case as recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
This is a bottom up recursive approach. WE START FROM THE bottom and keep on telling the parent the number of spare coins that
we have and keep counting them side by side.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        self.moves = 0
        self.dfs(root)
        return self.moves
      
    def dfs(self,root):
        # base
        if root == None:
            return 0
    
        # logic
        extra = root.val - 1
        extra += self.dfs(root.left)
        extra += self.dfs(root.right)
        self.moves += abs(extra)
        return extra
