'''
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
Do PostOrder Traversal and traverse till the leaf nodes, if the node is None return 0. For every node the number of coins
to be returned to the parent is the value of the node + left subtree val + right subtree val- 1. The number of steps is
calculated as the absolute value of the left subtree val + right subtree val.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.res = 0

    def postOrder(self, root):
        if root == None:
            return 0
        left = self.postOrder(root.left)
        right = self.postOrder(root.right)

        self.res += abs(left) + abs(right)

        return root.val + left + right - 1

    def distributeCoins(self, root: TreeNode) -> int:
        if root == None:
            return 0

        self.postOrder(root)

        return self.res