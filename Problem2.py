#Time Complexity: O(N)
#Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        
        self.extra = 0
        self.moves = 0
        self.helper(root)
        return self.moves
    def helper(self,root):
        if not root:
            return 0
        self.extra = root.val - 1
        self.extra += self.helper(root.left)
        self.extra += self.helper(root.right)
        self.moves += abs(self.extra)    
        return self.extra
        