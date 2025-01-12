#Approach
#Since the tree will have balanced nodes find the extra or deficit for each nodes and claculte the balance


#Time: O(n)
#SpaceO(n)

# Definition for a binary tree node.


from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.moves = 0
        self.dfs(root)
        return self.moves

    def dfs(self, root):
        if root == None:
            return 0

        left = self.dfs(root.left)
        right = self.dfs(root.right)

        self.moves += abs(left + right + root.val - 1)
        return left + right + root.val - 1