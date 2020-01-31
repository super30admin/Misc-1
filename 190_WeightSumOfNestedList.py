'''
Not tested on leetcode.
time - O(N)
space -O(1)
Approach: Recursive DFS approach
1. check for edge case, if the list is null.
2. Calculate depth each time we go into a new nestedList and multiply the integers at that depth with the depth at that time.
3. Finally add all outputs from each level and return the weighted sum.

'''
class Solution:
    def __init__(self):
        self.finalSum = 0

    def depthSum(self, nestedList):
        # edge case
        if nestedList == None or len(nestedList) == 0:
            return 0

        self.recursion(nestedList, 1)
        return self.finalSum

    def recursion(self, nestedList, depth):
        for nest in nestedList:
            if nest.isInteger():
                self.finalSum += nest.getInteger() * depth
            else:
                self.recursion(nest.getList(), depth+1)

sol = Solution()
print(sol.depthSum([[1,1],2,[1,1]]))
