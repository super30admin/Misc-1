'''
Time Complexity: 0(2^n)
Space Complexity: 0(2^n)
Run on LeetCode: Time Limit Exceed
'''
from collections import deque
class Solution:
    
    def __init__(self):
        self.queue = deque([])
    
    def brokenCalc(self, startValue: int, target: int) -> int:
        
        # add startVal to the queue
        self.queue.append(startValue)
        
        # maintain lvl
        lvl = 0
        
        # iterate the queue 
        while len(self.queue) != 0:
            
            # maintain size
            size = len(self.queue)
            
            # iterate till count breeches size
            for count in range(0,size):
                
                # pop the element from the queue
                ele = self.queue.popleft()
                
                if ele == target:
                    return lvl    
                
                # just chk for multiplication
                elif ele < target:
                    self.queue.append(ele*2)
                
                # just chk for subtraction
                self.queue.append(ele-1)
            
            '''end of for loop'''
            
            # update the lvl
            lvl += 1
        
        '''end of while loop'''
        
        return None