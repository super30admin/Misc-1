'''
Solution:
1.  For each nested list object, perform recursion by passing the depth as a parameter and add the integers to a global
    sum.
2.  Make use of the API to check for an integer or to convert to a list.
3.  All integers in the nested list are visited once and uses recursive stack space.

Time Complexity:    O(n), where n is the number of integers in the nested list.
Space Complexity:   O(d), where d is the max depth of the nested list.

--- Passed all testcases successfully on leetcode.
'''


# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """

class NestedInteger:
   def __init__(self, value=None):
       """
       If value is not specified, initializes an empty list.
       Otherwise initializes a single integer equal to value.
       """

   def isInteger(self):
       """
       @return True if this NestedInteger holds a single integer, rather than a nested list.
       :rtype bool
       """

   def add(self, elem):
       """
       Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
       :rtype void
       """

   def setInteger(self, value):
       """
       Set this NestedInteger to hold a single integer equal to value.
       :rtype void
       """

   def getInteger(self):
       """
       @return the single integer that this NestedInteger holds, if it holds a single integer
       Return None if this NestedInteger holds a nested list
       :rtype int
       """

   def getList(self):
       """
       @return the nested list that this NestedInteger holds, if it holds a nested list
       Return None if this NestedInteger holds a single integer
       :rtype List[NestedInteger]
       """

class Solution:

    def __depthSumHelper(self, nestedList: List[NestedInteger], depth: int) -> None:

        #   for each inner nested list object
        for innerNestedList in nestedList:

            #   check for an integer
            if (innerNestedList.isInteger()):
                self.weightedSum += (depth * innerNestedList.getInteger())

            #   otherwise perform recursion with depth + 1
            else:
                self.__depthSumHelper(innerNestedList.getList(), depth + 1)

        return

    def depthSum(self, nestedList: List[NestedInteger]) -> int:

        #   initializations
        depth = 1
        self.weightedSum = 0

        self.__depthSumHelper(nestedList, depth)

        #   return the global sum
        return self.weightedSum

