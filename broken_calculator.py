class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        ## T.C = O(logn)
        ## S.C = O(1)  

        count = 0
        while target > startValue:
            if target % 2 == 0:
                target = target / 2
            else:
                target += 1
            count += 1
        
        return count + int(startValue - target)
            

        # if startValue == target:
        #     return 0
        # q = [startValue]
        # count = 0

        # while q:
        #     for i in range(len(q)):
        #         x = q.pop(0)
        #         if x * 2 == target:
        #             return count + 1
        #         if x - 1 == target:
        #             return count + 1
                
        #         if x > target:
        #             q.append(x - 1)
        #         else:
        #             q.append(x - 1)
        #             q.append(x * 2)
            
        #     count += 1
        
        # return -1 