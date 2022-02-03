# 991. Broken Calculator
# https://leetcode.com/problems/broken-calculator/

# Logic: 

# Brute Force: We can do brute force where at every step we have 2 choices. 
# We dont multiply if the number already goes more than the target.

# Efficient: We start from the target and work our way back. In place of * we 
# do / and in place of - we do +. If the target is even we divide until it 
# becomes less than the start value. If it is odd we add 1 to make it even 
# and follow the operation we decided for even numbers. As it goes below the 
# start value, the only possible way to reach is to do addition. So we add 
# the difference between current target and start value as that many +1 would 
# be needed.

# Time Complexity: O(log(target))
# Space Complexity: O(1)

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        if startValue == target:
            return 0
        
        count = 0

        while target > startValue:
            if target % 2 == 0:
                target = target // 2
            else:
                target = target + 1
            count += 1
        return count + startValue - target