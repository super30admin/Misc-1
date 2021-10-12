#Time Complexity : O(N) #number of nodes
#Space Complexity : O(logN)

class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.moves = 0
        
        def dfs(node):
            #base
            if not node:
                return 0
            
            #logic
            left = dfs(node.left)
            right = dfs(node.right)
            extra = left +right + node.val-1
            self.moves += abs(extra)
            
            return extra
        
            
        
        dfs(root)
        return self.moves