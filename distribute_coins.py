# Time - O(N)
# Space - O(H)
class Solution:
    def distributeCoins(self, root: TreeNode) -> int:

        if not root:
            return 0
        
        self.result = 0
        self.dfs(root)

        return self.result


    def dfs(self, root):
        # int function


        # base case
        if not root:
            return 0

        # logic
        # calc extra coins at the parent level, then move to children
        # if coin is < 0 it needs that many coins
        # if > surplus

        extra_coins = root.val - 1
        extra_coins += self.dfs(root.left)
        extra_coins += self.dfs(root.right)

        self.result += abs(extra_coins)

        return extra_coins

    

            