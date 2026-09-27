# Problem2: Coin distribution(https://leetcode.com/problems/distribute-coins-in-binary-tree/)
# Time Complexity: O(n),Every node in the tree is visited exactly once during the recursion. At each node we do O(1) work (subtraction, addition, abs), so total work is O(n).
# Space Complexity: O(h),h = height of the tree (this is NOT extra data structures, it's the recursion call stack). Worst case (skewed tree, like a linked list): h = n, so O(n).Best case (balanced tree): h = log(n).
# Approach:
# Every node needs exactly 1 coin. Compute "extras" = root.val - 1 for each node (positive = node has spare coins, negative = node is short coins).
# Recursively solve the left and right subtrees first (post-order traversal).
# Each recursive call returns the NET surplus/deficit of that entire subtree, which gets passed up to the parent.
# At each node, the number of coin-moves needed across its two child edges equals abs(left_net + right_net + extras). Add this to a running total (self.count).
# Return (left_net + right_net + extras) up to the parent, so the parent can do the same calculation one level up.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: TreeNode | None) -> int:
        self.count = 0        # running total of moves across the whole tree
        self.helper(root)     # kick off recursion; we don't need its return value here
        return self.count     # final answer: total moves needed

    def helper(self, root):
        if root is None:
            return 0          # empty spot: 0 coins, needs 0 coins, contributes 0 net

        extras = root.val - 1  # how many coins this node has beyond the 1 it needs
                                # positive = spare coins, negative = coins needed

        left = self.helper(root.left)    # net surplus/deficit coming up from left subtree
        right = self.helper(root.right)  # net surplus/deficit coming up from right subtree

        # moves needed across this node's two child-edges to balance things out
        self.count += abs(left + right + extras)

        # pass this subtree's net surplus/deficit up to the parent
        return left + right + extras

        