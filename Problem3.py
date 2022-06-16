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

#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        stack = []
        depth = []
        ans = 0
        
        for i in nestedList:
            stack.append(i)
            depth.append(1)
            
        while stack:
            curr = stack.pop()
            dep = depth.pop()
            if curr.isInteger():
                ans += curr.getInteger() * dep
            else:
                for i in curr.getList():
                    stack.append(i)
                    depth.append(dep+1)
                    
        return ans
        
        
        
        
        
        
        
        
        
        
        