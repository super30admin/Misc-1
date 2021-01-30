# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        count = 0
        def dfs(node):
            nonlocal count
            if not node:
                return 0
            L, R = dfs(node.left), dfs(node.right)
            count += abs(L) + abs(R) 
            return L + R + node.val - 1
        dfs(root)
        return count
    

Time : O(N)
Space: O(Height)
