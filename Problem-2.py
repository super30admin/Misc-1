# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.total=0
        
        def postOrder(node):
            if not node:
                return 0
            
            left=postOrder(node.left)
            right=postOrder(node.right)
            
            self.total+=abs(left)+abs(right)
            
            return node.val + left + right -1
        
        postOrder(root)
        return self.total
        
        
        
        
        
        
        