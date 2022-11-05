# Time complexity : O(n^n)
# Space complexity : O(d):
# Leetcode : Time Limit exceeded

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
       # create a hashmap to store the values and their corresponding steps
        self.hashmap = {}
        
        # call the dfs function
        return self.dfs(startValue, target, 0)
    
    def dfs(self, start, target, currSteps):
        # if the start value is not present in the hashmap
        if start not in self.hashmap:
            # insert the value in the hashmao of startValue with its current steos
            self.hashmap[start] = currSteps
        else:
            # if it present but the current steps is less than the previous
            if self.hashmap[start] > currSteps:
               
                # update the hashmap for that value
                self.hashmap[start] = currSteps
            else:
                # else just infinity value
                return float('inf')
              
        # if we have reached the target then return the current number of steps
        if start == target:
            return currSteps
        
        # declare default value of case 1 and case2 as infinity values
        case1, case2 = float('inf'), float('inf')
        
        # case 1
        # if the start value is less than the target and target is greater than 0
        if start < target and target >= 0:
            # multiply the start val by 2 and call the dfs on the new start value
            val = start * 2
            case1 = self.dfs(val, target, currSteps + 1)
        
        # if the start value is greater than 1,, update the start by subtracting one
        if start > 1:
            val = start - 1
            
            # call the dfs function recursively
            case2 = self.dfs(val, target, currSteps + 1)
        
        # at the end, return the min number of operations from both the cases
        return min(case1, case2)
