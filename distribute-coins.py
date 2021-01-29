# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(h) -> height of tree
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def distributeCoins(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        moves = [0]
        
        # Bottom Up DFS
        def dfs(node):
            # For any arbitrary node, we need one coin per node
            # The spare coins is node.val - 1
            # If this is positive -> node has spare coins too give other nodes
            # If this is negative -> node has a deficit and needs a coin
            spareCoins = node.val - 1
            
            # Ask the left and the right subtrees how many spare coins they have
            if node.left:
                spareCoins_left = dfs(node.left)
                spareCoins += spareCoins_left
            if node.right:
                spareCoins_right = dfs(node.right)
                spareCoins += spareCoins_right
            # The absolute value of spare coins represents the number of moves
            moves[0] += abs(spareCoins)
            return spareCoins
        
        if not root:
            return 0
        dfs(root)
        return moves[0]