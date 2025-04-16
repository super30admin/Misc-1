# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # TC : O(n)
    # SC : O(h)
    def dfs(self,root)->int:
        # base
        if root is None:
            return 0
        # logic
        extra = root.val - 1
        extra += self.dfs(root.left)
        extra += self.dfs(root.right)
        self.moves += abs(extra)
        return extra
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.moves = 0
        if root is None:
            return 0
        self.dfs(root)
        return self.moves
        