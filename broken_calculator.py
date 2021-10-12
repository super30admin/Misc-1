#Time Complexity: O(logN) where N is targetvalue
#Space Complexity : O(1)

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        if startValue== target:
            return 0
        steps =0 
        while (target > startValue):
            if target%2==0:
                target = target//2
            else:
                target +=1
            steps+=1
        return steps+startValue-target
            
        