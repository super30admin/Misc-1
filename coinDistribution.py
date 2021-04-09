# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        self.res = 0
        
        self.dfs(root)
        
        return self.res
    
    def dfs(self, root):
        #base
        if not root:
            return 0
        #extra shouldnt be 0
        extra = root.val - 1    #extra = 0
        #logic
        extra += self.dfs(root.left)
        extra += self.dfs(root.right)
        self.res += abs(extra)
        return extra