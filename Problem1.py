#Time complexity : O(n)
#Space complexity: O(h) where h is the height of BT
#Works on leetcode : yes
#Approach : For every subtree, balance is the number of coins it has to give and recieve from parent. Example root= [1,L,R] L=[3,1,0],
# R = [0,1,1] th L balance is 1 (for giving to root) and R balance is -1 (for recieve from root). L need 2 steps to balance itself by giving
# one to root and one to 0 node. Balancing R needs 1 step as it takes 1 coin from root. We get current balance by adding left + right +
# self balance -1 (-1 as current node needs 1 coin). So we use DFS, to start calculating balance starting from leaf to node. Since
# leaf balance is leaf.val-1, we end up getting the steps to balance leaf's parent by adding abs(left leaf's balance) and abs(right
# leaf balance)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        
        self.steps = 0
        
        def dfs(root):
            if not root:
                return 0
            L, R = dfs(root.left), dfs(root.right)
            self.steps += abs(L)+abs(R)
            balance = root.val + L + R -1
            return balance
        
        dfs(root)
        return self.steps
