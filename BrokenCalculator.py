# Time Complexity : O(logY)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Greedy Approach


class Solution:
    def brokenCalc(self, X: int, Y: int) -> int:
        count = 0
        while Y > X:
            if Y % 2 == 0:
                Y = Y // 2
            else:
                Y = Y + 1
            count += 1
        return count + X - Y