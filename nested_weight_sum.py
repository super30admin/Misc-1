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
"""
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        """
        Since we deal with the depth, we can go with the DFS approach where we iterate over the list and for each nested list type,we recurse with the depth + 1, else we add the sum to the result
        """
        final_sum = 0
        def dfs(nlist,depth):
            nonlocal final_sum
            #no base case
            
            #logic
            for ele in nlist:
                if ele.isInteger():
                    #add the value to the sum
                    final_sum += ele.getInteger() * depth
                else:
                    dfs(ele.getList(),depth+1)
        dfs(nestedList,1)
        return final_sum