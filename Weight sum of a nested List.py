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
'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation:
Iterate through array and if we see an integer we just find the sum by adding sum + depth * the integer. If its a list
we recursively enter the list and iterate through each element and increase the depth by 1 and multiply the individual
element in list by the depth to the global sum
'''

class Solution:
    #if it is an integer go inside and find depth * value
    #if list traverse into the array and find complete sum and return back to the original function
    def __init__(self):
        self.sum = 0
    def traverse(self, nestedList, depth):
        for entry in nestedList:
            if entry.isInteger():
                self.sum += depth * entry.getInteger()
            else:
                self.traverse(entry.getList(), depth+1)
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        self.traverse(nestedList,1)
        return self.sum