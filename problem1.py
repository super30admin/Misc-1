# TC:O(m+n) where n is the target
# SC:O(1)

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        if startValue == target:
            return 0

        steps = 0

        while target != startValue:
            if target < startValue:
                return steps + startValue - target
            if target % 2 == 0:
                target = target // 2
                steps += 1
            else:
                target += 1
                steps += 1

        return steps