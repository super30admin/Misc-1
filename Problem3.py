# Problem 3 : Nested List Weight Sum
# Time Complexity : O(n) where n is the length of the nestedList
# Space Complexity : O(d) where d is maximum depth of the nesting
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

class Solution:
    def __init__(self):
        # define global variable sum which will store sum of all integer
        self.sum = 0

    def depth_sum(self, nestedList):
        # call helper function with nestedList and depth as 1
        self.helper(nestedList, 1)
        # return value of sum
        return self.sum

    # helper function to recursively calculate sum
    def helper(self, ns, depth):
        # loop through ns list
        for n in ns:
            # check is n is integer and if it is then calculate sum
            if n.isInteger():
                self.sum += depth * n.getInteger()
            else:
                # else call helper function with the list of the n and increment the value of depth
                self.helper(n.getList(), depth + 1)
