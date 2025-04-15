# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def distributeCoins(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        moves = 0
        if root == None:
            return 0
        def dfs(root):
            nonlocal moves
            if root == None:
                return 0
            extra = root.val -1
            extra += dfs(root.left)
            extra += dfs(root.right)
            moves = moves + abs(extra)
            return extra
        dfs(root)
        return moves


