# 979. Distribute Coins in Binary Tree
# https://leetcode.com/problems/distribute-coins-in-binary-tree/

# Logic: We need to calculate the coins flowing through each node at any 
# given time. We take absolute because -ve indicates coins are needed. 
# Similarly +ve indicates coins are to be given.

# Time Complexity: O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, root):
        # Base Case
        if not root:
            return 0
        
        flow = root.val - 1 + self.dfs(root.left) + self.dfs(root.right)
        self.moves += abs(flow)
        
        return flow
        
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.moves = 0
        self.dfs(root)
        
        return self.moves