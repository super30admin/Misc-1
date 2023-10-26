# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:

        #Method 1 - DFS, at each point keep track of extras you have, then do left and right DFS calls, then once current node is done, add absolute val to moves. -> TC - O(H)
        moves=0
        def dfs(root):
            nonlocal moves
            #base
            if not root: return 0

            #logic
            extra=root.val-1 #-1 cause we need 1 coin for current node too
            extra+=dfs(root.left) #go left and get the left trees coins
            extra+=dfs(root.right) #go right and get the left trees coins
            moves+=abs(extra) 
            return extra        
        dfs(root)
        return moves

