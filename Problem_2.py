class Solution(object):
    def distributeCoins(self, root):
        self.moves = 0
        if root == None:
            return self.moves
        self.dfs(root)
        return self.moves
    
    def dfs(self, root):
        if root == None:
            return 0
        extra = root.val - 1
        extra += self.dfs(root.left)
        extra += self.dfs(root.right)
        self.moves += abs(extra)
        return extra

# Time Complexity: O(n)
# Space Complexity: O(n)