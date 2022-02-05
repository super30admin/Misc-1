# 339. Nested List Weight Sum
# https://leetcode.com/problems/nested-list-weight-sum/

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

# DFS
# Logic: If we get an int we add to result, if we get a list we recurse.

# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def dfs(self, nestedList, depth):
        for i in range(len(nestedList)):
            if nestedList[i].isInteger():
                self.result += depth * nestedList[i].getInteger()
            else:
                self.dfs(nestedList[i].getList(), depth + 1)
        
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        self.result = 0
        self.dfs(nestedList, 1)
        
        return self.result

# BFS
# Logic: We do level order traversal. At each level we remove 
# outer most brackets and add everything in the queue.

# Time Complexity: O(n)
# Space Complexity: O(n)

from collections import deque

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        q = deque()
        lvl = 1
        result = 0
        
        for i in range(len(nestedList)):
            q.append(nestedList[i])
        
        while q:
            size = len(q)
            
            for i in range(size):
                cur = q.popleft()
                
                if cur.isInteger():
                    result += lvl * cur.getInteger()
                else:
                    for i in cur.getList():
                        q.append(i)
            lvl += 1
        return result