class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            nonlocal moves
            if node == None: return 0 
            extra = node.val-1
            extra +=dfs(node.left)
            extra += dfs(node.right)
            moves = moves + abs(extra)
            return extra
        moves = 0 
        dfs(root)
        return moves

