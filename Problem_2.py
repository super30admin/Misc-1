# Distribute Coins in Binary Tree

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes with Runtime 36 ms and Memory is 14.2 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using dfs approach which helps in establishing parent child relationship. 
Spare coins are maintained at that moment so root coins-1 and than absolute 
value is calculated.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: TreeNode) -> int:  
        self.moves=0
        
        def dfs(node):
            if node==None:
                return 0
            #spareCoins=node.val-1
            spareCoinsl =dfs(node.left) # left node
            spareCoinsr =dfs(node.right) # right node
            self.moves += abs(spareCoinsl)+abs(spareCoinsr)
            return node.val+spareCoinsl+spareCoinsr-1
    
        dfs(root)
        return self.moves