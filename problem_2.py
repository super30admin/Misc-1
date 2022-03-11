# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# TC:O(n)
# SC:O(h)
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return None

        self.result = 0

        self.dfs(root)
        return self.result

    def dfs(self, root):
        if root is None:
            return 0

        val = root.val

        val += self.dfs(root.left)
        val += self.dfs(root.right)
        val -= 1
        self.result += abs(val)

        return val



