'''
Time Complexity: 0(logn)
Space Complexity: 0(1)
Run on LeetCode: Yes
'''

'''Greedy Approach -- Jump Game'''
class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        
        # maintain lvl
        lvl = 0
        
        # iteration
        while target > startValue:
            
            # update the lvl
            lvl += 1
            
            if target%2 != 0:
                target += 1
                continue
            
            target = target // 2
        
        # print('lvl is:\t',lvl)
        return lvl + abs(target-startValue)