# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        ## T.C = O(n)
        ## S.C = O(h)

        moves = 0

        def dfs(root):
            nonlocal moves

            if root is None:
                return 0

            extras = root.val - 1
            extras += dfs(root.left)
            extras += dfs(root.right)
            moves += abs(extras)

            return extras
        
        dfs(root)
        return moves