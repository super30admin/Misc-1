import collections

# class Solution:
#     def brokenCalc(self, startValue: int, target: int) -> int:
#         q = collections.deque([startValue])
#         visited = set([startValue])
#         level = 0
#         while q :
#             size = len(q)
#             for i in range(size):
#                 curr = q.popleft()
#                 if curr == target:
#                     return level
#                 if curr<target:
#                     newnum = curr*2
#                     if newnum not in visited:
#                         q.append(newnum)
#                         visited.add(newnum)
#                 if curr>1:
#                     newnum = curr-1
#                     if newnum not in visited:
#                         q.append(newnum)
#                         visited.add(newnum)
#             level+=1
#         return -1

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        steps = 0
        
        while target>startValue:
            if target%2 == 0:
                target=target//2
            else:
                target+=1
            steps+=1
        return steps+startValue-target


        