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

# Time complexity : O(n) --> n - number of elements in the flattened list
# Space complexity : O(n)
# Leetcode : Solved and submitted

# 2 queues
from collections import deque
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        # declare a res with 0 value, and 2 queues, one to maintain the el and other to maintain the depth for each element
        res = 0
        q = deque([])
        depth = deque([])
        
        # add all the elements be it list or int in the queue with depth 1
        for el in nestedList:
            q.append(el)
            depth.append(1)
        
        # traverse over the queue
        while q:
            # fetch the first element and it's corresponding depth
            curr = q.popleft()
            d = depth.popleft()
            
            # if curr is an integerm then fetch the integer, multiply it with the depth and add to result
            if curr.isInteger():
                res += d * curr.getInteger()
            else:
               # if curr is a list, then fetch the list and add each element in the q with depth + 1 in the other queue
                for el in curr.getList():
                    q.append(el)
                    depth.append(d+1)
        # return the final result
        return res

# 1 Queue
from collections import deque
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        res = 0
        q = deque([])
        d = 1
        
        for el in nestedList:
            q.append(el)
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
            
                if curr.isInteger():
                    res += d * curr.getInteger()
                else:
                    for el in curr.getList():
                        q.append(el)
            d += 1
            
        return res
