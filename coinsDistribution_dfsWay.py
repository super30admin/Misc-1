'''
Time Complexity: 0(n)
Space Complexity: 0(n)
Run on LeetCode: Yes
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.moves = 0
    
    def __dfsTraversal(self,currentNode):
        # base-case
        if currentNode == None:
            return 0
        
        # logic-case
        # extraCoins my currentNode has/need
        extraCoins = currentNode.val-1
        
        # coins my lhs has/to give
        lhsMoves = self.__dfsTraversal(currentNode.left)
        
        # coins my rhs has/to give
        rhsMoves = self.__dfsTraversal(currentNode.right)
        
        # update the moves
        self.moves += abs(lhsMoves) + abs(rhsMoves)
        
        # total coins this subNode needs/has extra to give
        return (lhsMoves+extraCoins+rhsMoves)
        
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.__dfsTraversal(root)
        return self.moves