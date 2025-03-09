# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    '''
    Accepted on leetcode(979)
    time - O(N), no. of nodes in the tree
    space - O(1)
    Approach: Using recursion
    1. Start from leaf and count the extra coins(coins at node - 1) on each node and move upwards.
    2. Add extra coins to moves and at the end return moves.

    '''

    def __init__(self):
        self.moves = 0

    def distributeCoins(self, root: TreeNode) -> int:
        self.recursion(root)
        return self.moves

    def recursion(self, root):
        if root == None:
            return 0

        GiveAwayCoins = root.val - 1

        # post order traversal(root is processed at the end, recursion)
        GiveAwayCoins += self.recursion(root.left)
        GiveAwayCoins += self.recursion(root.right)

        self.moves += abs(GiveAwayCoins)

        return GiveAwayCoins