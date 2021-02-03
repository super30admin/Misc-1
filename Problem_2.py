"""
Time Complexity : O(n) 
Space Complexity : O(n)  worst case as recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

This is a bottom up recursive approach. WE START FROM THE bottom and keep on telling the parent the number of spare coins that
we have and keep counting them side by side.
"""


class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        self.ans = 0

        def dfs(root):
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            self.ans += abs(left) + abs(right)
            return root.val + left + right - 1

        dfs(root)
        return self.ans
