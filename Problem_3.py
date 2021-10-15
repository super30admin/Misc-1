
# DFS Approach
class Solution(object):
    def depthSum(self, nestedList):
        self.sum = 0
        if nestedList == None or len(nestedList) == 0:
            return self.sum
        
        self.helper(nestedList, 1)
        return self.sum
    
    def helper(self, nestedList, depth):
        for ni in nestedList:
            if ni.isInteger():
                self.sum += depth * ni.getInteger()
            else:
                li = ni.getList()
                self.helper(li, depth + 1)

# Time Complexity: O(n)
# Space Complexity: O(n)



# BFS Approach
# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
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

class Solution(object):
    def depthSum(self, nestedList):
        sum = 0
        if nestedList == None or len(nestedList) == 0:
            return self.sum
        queue = deque()
        depth = deque()
        for e in nestedList:
            queue.append(e)
            depth.append(1)
        while len(queue) != 0:
            li = queue.popleft()
            de = depth.popleft()
            if li.isInteger():
                sum += li.getInteger() * de
            else:
                newList = li.getList()
                for e in newList:
                    queue.append(e)
                    depth.append(de + 1)
        return sum

# Time Complexity: O(n)
# Space Complexity: O(n)
    
    
                
        