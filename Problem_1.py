# Broken Calculator

# Time Complexity : logarithmic
# Space Complexity : Constant-O(1)
# Did this code successfully run on Leetcode : Yes with Runtime 16 ms and Memory is 13.4 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using BFS is better as output is closer to root and handled level order. 
A queue is maintained. In order to get optimal solutioin we get backwards i.e
from Y to X by inverting operations * to % and - to +.

"""
class Solution(object):
    def brokenCalc(self, X, Y):
        """
        :type X: int
        :type Y: int
        :rtype: int
        """
        count = 0
        while Y > X:
            count += 1
            if Y%2: Y += 1
            else: Y /= 2

        return count + X-Y
