# Problem 2 : Distribute Coins in Binary Tree
# Time Complexity : O(n) where n is the number of nodes in the tree
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        # define global variable moves which will store number of moves of the coin required
        self.moves = 0

    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        # helper function to recursively travel the tree and calculate extra value and moves for the tree with root as node
        def helper(node):
            # check if the node is null and if it is then return 0
            if not node:
                return 0
            
            # calculate the extra value as value of node - 1
            extra = node.val - 1
            # call the helper function for the left child of node and add the return value for the left tree to the extra 
            extra += helper(node.left)
            # call the helper function for the right child of node and add the return value for the right tree to the extra 
            extra += helper(node.right)
            # add the absolute value of extra to moves 
            self.moves += abs(extra)
            # return the extra
            return extra

        # calculcat the helper function with the root
        helper(root)
        # return the values of the moves variable
        return self.moves
