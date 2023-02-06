# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    moves = 0

    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.moves = 0
        if root is None:
            return self.moves

        self.dfs(root)
        return self.moves

    def dfs(self, root):
        if root is None:
            return 0

        extra = root.val - 1
        extra += self.dfs(root.left)
        extra += self.dfs(root.right)
        self.moves += abs(extra)

        return extra

# Bottom Up recursion
# Time Complexity: O(n)
# Space Complexity: O(n). Size of the recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
