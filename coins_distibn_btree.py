"""
// Time Complexity : O(n)
// Space Complexity : O(maxdepth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        """
        The idea is to count the number of coins that is left in spared represented by how many required to be transfered from child to parent or vice versa
        such that every node has only 1 coin
        It is required to update the moves based on the left of the root and right of the root recursively 
        """
        
        def dfs(root):
            nonlocal moves
            #base
            if not root:
                return 0
            
            #logic
            
            #decrement by 1 since that's 1 is the target value to be obtained
            spare_coins = root.val - 1
            #add the left spare coins
            spare_coins += dfs(root.left)
            #add the right spare coins
            spare_coins += dfs(root.right)
            #update moves using abs value
            moves += abs(spare_coins)
            return spare_coins
        
        
        moves = 0
        dfs(root)
        return moves