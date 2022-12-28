#Time: O(n)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:

    def brokenCalc(self, startValue: int, target: int) -> int:
        steps = 0

        if startValue == target:
            return steps

        while target > startValue:
            steps += 1
            if target % 2 == 1:
                target += 1
            else:
                target = int(target / 2)

        return steps + startValue - target