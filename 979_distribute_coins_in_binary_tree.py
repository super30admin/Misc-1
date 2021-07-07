# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        """
            https://leetcode.com/problems/distribute-coins-in-binary-tree/
            Time Complexity - O(n)
            Space Complexity - O(h) 'Recursive Stack'
            'n' is the number of nodes
            'h' is the height of the tree
        """
        self.moves = 0
        self._dfs(root)
        return self.moves

    def _dfs(self, node):
        # base
        if not node:
            return 0
        # logic
        spare_coins = node.val - 1
        spare_coins += self._dfs(node.left)
        spare_coins += self._dfs(node.right)
        self.moves += abs(spare_coins)
        return spare_coins