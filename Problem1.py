# Problem 1 : Broken Calculator
# Time Complexity : O(log target)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        # define count variable which store the number of operation to get value less than startValue from target
        count = 0
        # loop till target is greater than startValue
        while target > startValue:
            # check if target can be divided by 2 and if it is divide the target by 2 and get new target
            if target % 2 == 0:
                target = target // 2
            else:
                # else add 1 to target and get new target
                target += 1
            # increment the value of count
            count += 1
        # return the sum of count and difference between startValue and new target(ie number of subtraction operation required)
        return count + (startValue - target)
