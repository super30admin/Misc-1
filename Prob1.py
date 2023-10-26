class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        #Method 1 - BFS - you have 2 options, simulate it with BFS and use set to avoid repeats
        # TC log(target - startValue)
        # q=deque()
        # s=set()
        # q.append(startValue)
        # s.add(startValue)
        # count=0
        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.popleft()
        #         if curr==target: #if startval==target case
        #             return count
        #         if curr>1: #we don't want to go to negatve case, since we know target is positive
        #             newcurr=curr-1
        #             if newcurr==target:
        #                 return count+1
        #             if newcurr not in s:
        #                 s.add(newcurr)
        #                 q.append(newcurr)
        #         if curr<target: #do mul by 2 only if curr <target, else no point
        #             newcurr=curr*2
        #             if newcurr==target:
        #                 return count+1
        #             if newcurr not in s:
        #                 s.add(newcurr)
        #                 q.append(newcurr)
        #     count+=1

        #Method 2 - greedy - TC - O(log(target))
        count=0
        while target>startValue:
            if target%2==0:
                target//=2
            else:
                target+=1
            count+=1
        
        return count+(startValue-target) #this startValue-target, is present cause target can become less than startvalue by 1, in that case it will exit the while loop, since it's just 1, it's adding 1s, so just add this difference to count
        

