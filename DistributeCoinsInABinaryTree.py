from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.count = 0
        self.helper(root)
        return self.count

    def helper(self,root):
        # base
        if not root : return 0

        extras = root.val-1 
        # post order
        left = self.helper(root.left)
        right = self.helper(root.right)
        self.count += abs(left+right+extras)
        return left+right+extras
        