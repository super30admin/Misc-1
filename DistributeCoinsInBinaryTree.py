'''
TC: O(n) - Iterating through every node in the tree
SC: O(h) - The stack space used during DFS - height of the tree
'''
# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.moves = 0

        def dfs(root):
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            tot = left+right+root.val-1
            self.moves += abs(tot)
            return tot
        
        dfs(root)
        return self.moves
