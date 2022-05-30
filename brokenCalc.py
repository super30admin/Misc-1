
class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        '''
        Do a dry run 
        strt = 5 
        target = 8 
        start = 8
        target = 3
        '''
        
        if startValue == target:
            return 0
        ops = 0
        while target > startValue :
            if target%2 == 0:
                target = target // 2
            else: target = target + 1
            ops += 1
        return ops + startValue - target


    def BruteForcebrokenCalc(self, startValue: int, target: int) -> int:
        '''
        T = O(2**N)
        '''
        if startValue == target:return 0 
        q = [] 	
        q.append(startValue)
        ops = 1 
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if curr-1 == target or 2* curr == target: return ops
                if curr > target:
                    q.append(curr-1)
                else:
                    q.append(curr-1)
                    q.append(2*curr)
            ops += 1
        return 4738642
    
    
