#approach
#calculate the reverse operation for * divide for - plus and if the result is even then diivde else add 1


#Complexities
#Time: O(logn)+O(K)
#Space: O(1)

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        count=0
        while target > startValue:
            if target % 2 == 1:
                target += 1
            else:
                target = target // 2

            count += 1
        return count + (startValue - target)



s = Solution()

#print(s.brokenCalc(2,3))
print(s.brokenCalc(5,8))