# Problem2: Coin distribution
# // Time Complexity : O(N)
# // Space Complexity :O(H)- height of the tree
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.moves=0
        def dfs(root):
            if root==None:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            self.moves += abs(left)+abs(right)
            return root.val+left+right-1
        dfs(root)
        return self.moves