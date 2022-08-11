'''
time complexity: O(n)
space complexity: O(1)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.moves = 0
        self.dfs(root)
        return self.moves
    def dfs(self,root):
        if root == None: return 0
        
        left = self.dfs(root.left)
        right = self.dfs(root.right)
        extra = left + right + root.val - 1
        self.moves+=abs(extra)
        return extra
        