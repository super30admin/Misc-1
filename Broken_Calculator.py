#Space:O(1)
#TIme:O(log(target))
class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        if startValue == target:
            return 0
        steps = 0
        while(target>startValue):
            if target==startValue:
                return steps
            if target%2:
                target+=1 
            else:
                target=target//2
            steps+=1
        return steps + startValue-target