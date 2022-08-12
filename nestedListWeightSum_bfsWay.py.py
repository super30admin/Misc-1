'''
Time Complexity: 0(n)
Space Complexity: 0(n) -- queue
Run on LeetCode: Yes
'''
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
from collections import deque

class Solution:
    def __init__(self):
        self.queue = deque([])
        self.nestedSum = 0
    
    def bfsTraversal(self):
        
        # maintain lvl 
        lvl = 1
        
        # iterate the queue
        while len(self.queue)!= 0:
            
            # get the size of the queue
            size = len(self.queue)
            
            # iterate till count breeches size
            for count in range(0,size):
                # pop the pair from the queue
                pair = self.queue.popleft()
                
                # chk if pair is an integer or a list
                if pair.isInteger():
                    self.nestedSum += pair.getInteger()*lvl
                    continue
                
                '''if its a list, update accordingly'''
                for ele in pair.getList():
                    self.queue.append(ele)
            '''end of inner for loop'''
            
            # update the lvl
            lvl += 1
        '''end of while loop'''
        
        # update the lvl
        lvl -= 1
    
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        
        # add all the nestedList objects to the queue
        for pair in nestedList:
            self.queue.append(pair)
        
        # perform bfsTraversal
        self.bfsTraversal()
        
        # return the result
        # print(self.nestedSum)
        return self.nestedSum