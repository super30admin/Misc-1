# Time complexity : O(log n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        # initialize the count variable as 0
        count = 0
        
        # we will be reducing the target until we reach startValue
        while startValue < target:
            # if the target value is divisible by 2, then divide the number by 2 and increment the count by 1
            if target % 2 == 0:
                target = target // 2
                count += 1
            else:
                # else other thing we can do is increment the target and count both by 1
                target += 1
                count += 1
        
        # at the end return the sum of count and startValue and subtract target
        # at time it could be we have the Target going above StartValue, so we need to subtract that value
        return count + startValue - target
