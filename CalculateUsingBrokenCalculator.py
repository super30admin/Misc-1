# Time Complexity : O(log(n))
# Space Complexity : O(1)

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        cur_val = target

        res = 0
        while cur_val > startValue:
            if cur_val % 2 == 0:
                cur_val = cur_val // 2
            else:
                cur_val = cur_val + 1
            res += 1

        if cur_val == startValue:
            return res
        else:
            return res + startValue - cur_val