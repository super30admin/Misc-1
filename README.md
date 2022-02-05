# Misc-1

## Problem1: Calculate Using Broken Calculator (https://leetcode.com/problems/broken-calculator/)
class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        count=0
        while target>startValue:
            if target%2==0:
                target=target//2
            else:
                target+=1
            count+=1
        return count+startValue-target


## Problem2: Coin distribution(https://leetcode.com/problems/distribute-coins-in-binary-tree/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        moves=0
        def dfs(node):
            nonlocal moves
            if node is None:
                return 0
            a=node.val-1+ dfs(node.left) + dfs(node.right)
            moves+=abs(a)
            return a
        dfs(root)
        return moves
            
        
        
        



## Problem 3: Weight sum of a nested List (https://leetcode.com/problems/nested-list-weight-sum/)

# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        queue = deque(nestedList)

        depth = 1
        total = 0

        while len(queue) > 0:
            for i in range(len(queue)):
                nested = queue.pop()
                if nested.isInteger():
                    total += nested.getInteger() * depth
                else:
                    queue.extendleft(nested.getList())
            depth += 1

        return total
                
        