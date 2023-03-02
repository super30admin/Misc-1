# Time Complexity: O(n)
# Space Complxty: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    moves = 0

    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        def helper(root):
            # Base
            if not root:
                return 0
            # Logic
            left = helper(root.left)
            right = helper(root.right)
            x = root.val + (left + right) - 1
            self.moves += abs(x)
            return x

        helper(root)
        return self.moves
