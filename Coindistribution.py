# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        moves = [0]

        def dfs(node):
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            moves[0] += abs(left) + abs(right)

            return (node.val - 1) + left + right

        dfs(root)

        return moves[0]