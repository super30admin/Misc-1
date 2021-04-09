# Time Complexity : O(log)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def brokenCalc(self, X: int, Y: int) -> int:
        #go backwards.. if able to divide by 2 then do it otherwise add 1
        count = 0

        while Y > X:
            if Y % 2 == 0:
                Y //= 2
            else:
                Y += 1
            count += 1
            
        return count + X - Y