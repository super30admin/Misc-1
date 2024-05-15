'''
TC: O(log(target)) - Using idea of Binary Search by dividing the target by 
                    half each time it is even else just incrementing by 1 to make it even
SC: O(1) - No additional space used
'''
class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        count = 0
        while target > startValue:
            target = target//2 if target%2==0 else target+1
            count += 1
        return count+startValue-target
s = Solution()
print(s.brokenCalc(2, 3))
print(s.brokenCalc(5, 8))
print(s.brokenCalc(3, 10))
print(s.brokenCalc(1, 1000000000))