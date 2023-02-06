class Solution:
    def brokenCalc(self, startValue, target):
        count = 0
        # Edge case if startValue == target, return 0
        if startValue == target:
            return count

        # Here we are trying to reach startValue from target instead of startValue to target
        # We divide the target by 2 if target is divisible by 2 or add 1 to it
        # eg:- target =17 and startValue = 5
        # 17 is not divisible by 2 we add 1 to it
        # 18 is now divisible by 2 , target becomes 9 , we do target + 1(i.e 9 +1)
        # target = 10, divisible by 2 , 10 /2 = 5, which equal to target value

        # while loop runs until target > startValue
        while target > startValue:
            if target % 2 == 0:
                target = target // 2
            else:
                target += 1

            count += 1
        # if the target value becomes less than target
        # then we add the difference of startValue and target to the count variable and return
        # eg:- target =8 and startValue = 6
        # 8/2  = 4. which is 1 step
        # so count +  startValue + target = 1 +  6 - 4 = 3
        # total 3 steps needed
        return count + startValue - target

startValue = 1
target = 100000000
if __name__ == "__main__":
    obj = Solution()
    print(obj.brokenCalc(startValue, target))

# Greedy, maths
# Time Complexity : O(logn)
# Space Complexity: O(1)

