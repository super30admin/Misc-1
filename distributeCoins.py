#Time complexity: O(N)
#Space complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        self.moves = 0
        self.helper(root)
        return self.moves
    
    def helper(self, root):
        if root == None:
            return 0
        own = root.val - 1
        left = self.helper(root.left)
        right = self.helper(root.right)
        extra = left + own + right
        self.moves += abs(extra)
        return extra
