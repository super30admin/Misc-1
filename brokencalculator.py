class Solution:
    # greedy approach
    # TC : O(log n)
    # SC : O(1)
    def brokenCalc(self, startValue: int, target: int) -> int:
        if startValue > target:
            return startValue-target
        ct = 0
        while target > startValue:
            if target % 2 == 0:
                target = target // 2
            else:
                target = target+1
            ct += 1
        return ct + (startValue-target)