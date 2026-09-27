# Problem1: Calculate Using Broken Calculator (https://leetcode.com/problems/broken-calculator/)
# Time Complexity: O(log(target)), because we halve target about every 2 steps
# Space Complexity: O(1), only a few variables
# Approach:
# Work backwards from target to startValue.
# Reverse of "multiply by 2" is "divide by 2". Reverse of "subtract 1" is "add 1".
# If target is even, halve it. If odd, add 1 so it becomes even.
# Stop when target <= startValue. Now only decrements can help.
# Add the remaining gap (startValue - target) to the steps.

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        steps = 0  # count of operations used

        # Only loop while target is bigger than start
        while target > startValue:
            if target % 2 == 0:
                # Even: reverse of doubling, so halve it (1 op)
                target = target // 2
            else:
                # Odd: cannot halve, so undo a decrement by adding 1 (1 op)
                target += 1
            steps += 1  # each branch above costs one operation

        # target <= startValue now, so we can only decrement startValue.
        # Gap is startValue - target, and each unit costs one op.
        return steps + (startValue - target)