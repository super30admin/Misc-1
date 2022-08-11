'''
time complexity: O(log target)
space complexity: o(1)
'''
class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        if startValue == target: return 0
        count = 0
        while(startValue < target):
            if(target%2==0):
                target = target//2
            else:
                target+=1
            count+=1
            print(count,startValue,target)
        return count + startValue - target