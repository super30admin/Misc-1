# Time complexity : O(n^n)
# Space complexity : O(n)
# Leetcode : Time Limit Exceeded

from collections import deque
class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        # check if the start value is the target, then steps is 0
        if startValue == target:
            return 0
        
        # form a queue with the start value and count the number of steps until we reach the target value
        q = deque([startValue])
        count = 0
        
        # traverse until the queue is empty
        while q:
            # use the size, we have to increment the count after each level
            size = len(q)
            for i in range(size):
              
                # pop the element from the queue
                curr = q.popleft()
                
                # if the popped value is less than the target
                if curr < target:
                  
                    # check if the next operation will make it target then return current steps + 1
                    if curr*2 == target:
                        return count + 1
                    # add the next value to the queue
                    q.append(curr*2)
                
                # if the current popped value is greater than 1, then check if the next value is target, if so return current steps + 1
                if curr >= 1:
                    if curr - 1 == target:
                        return count + 1
                    
                    # append the next value to the queue
                    q.append(curr-1)
            
            # increment the steps after each level
            count += 1
        
        # return the count at the end
        return count
