# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity - O(n)
# Space complexity - O(h)
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        # dfs tells the extra coins at each node
        def helper(root):
            nonlocal moves
            if not root:
                return 0

            extra = root.val - 1 + helper(root.left) + helper(root.right)
            moves += abs(extra)
            return extra

        moves = 0
        helper(root)
        return moves

        
