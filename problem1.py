#Broken Calculator
# // Time Complexity : O(log N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        count=0
        while(startValue<target):       #keep doing this as long as the target is greater than the starting value
            if(target%2)==0:
                target=target//2        #if target is divisible by 2, then divide it
            else:
                target+=1               #else add 1
            count+=1                       #increment count
        return count + (startValue-target)      #return count, plus the difference between start and target (if target was smaller than start)
        