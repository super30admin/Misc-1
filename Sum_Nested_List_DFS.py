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

# Time complexity : O(n) --> n - elements in flattened list
# Space complexity : O(d) --> d - max depth
# Leetcode : Solved and submitted

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        # declare a res variable as 0
        self.res = 0
        
        # call the dfs function with the nested List and depth as 1
        self.dfs(nestedList, 1)
        
        # return the final output as res
        return self.res
    
    def dfs(self, nestedList, depth):
      
        # traverse over each element in the nested List
        for el in nestedList:
            # if the element is an integer
            if el.isInteger():
                # multiply the element with the depth and add to the result
                self.res += depth * el.getInteger()
            else:
                # if we have a list, then recursively call dfs on the list with depth + 1
                self.dfs(el.getList(), depth + 1)
