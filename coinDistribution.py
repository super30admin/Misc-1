# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        #calc. how many coins would flow through each branch
        self.res = 0

        def helper(root):
            if not root:
                return 0
            
            l = helper(root.left)
            r = helper(root.right)
            numCoins = root.val - 1
            self.res += abs(l + r + numCoins)
            return l + r + numCoins
        helper(root)
        return self.res