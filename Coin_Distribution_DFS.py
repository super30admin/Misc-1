# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        # make a global variable as moves
        self.moves = 0
        
        # call the dfs function on root
        self.dfs(root)
        
        # return the final number of moves
        return self.moves
    
    def dfs(self, root):
       # if we encounter a null node, then return 0, as we are return the number of extra coins a node has
        if not root:
            return 0
        
        # extra at the root is the root.val - 1, as a node needs only one, rest is extra
        extra = root.val - 1
        
        # find the extra in the left child of the root
        extra += self.dfs(root.left)
        
        # fetch the extra on the right child of the root
        extra += self.dfs(root.right)
        
        # total moves made at the current node is the total of all the extras
        self.moves += abs(extra)
        
        # return the extra, it would always sum upto 0 at the root node
        return extra
