# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
# class NestedInteger:
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
# TC:O(m+n) where n is the number of integers and m is the depth of List
# SC:O(m+n)

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        if nestedList is None:
            return 0

        stack = []
        numStack = []
        result = 0
        stack.append(nestedList)
        numStack.append(1)

        while stack:
            li = stack.pop()
            num = numStack.pop()

            for el in li:
                if el.isInteger():
                    result += num * el.getInteger()
                else:
                    stack.append(el.getList())
                    numStack.append(num + 1)

        return result


