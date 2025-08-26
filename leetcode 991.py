"""
Time Complexity: O(log(target))
Space Complexity: O(1)
"""
class Solution:
    def brokenCalc(self, startValue, target):
        steps = 0

        while target > startValue:
            if target % 2 == 0:
                target = target // 2
            else:
                target = target + 1
            steps += 1

        return steps + startValue - target