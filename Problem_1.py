
"""
Time Complexity : O(logn) 
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

One approach to solve this would be BFS where we do a level order traversal and reach from source to destination by repeatedly
doubling or decrementing by 1. As soon as we reach the target, we return the count. To optimise it a bit, when we reach a value
that is more than destination, do not double it, as it will never give an optimal answer. This approach will still give
time limit exceeded. To optimise it, we need to revcerse our approach and reach from Y to X. So instead, we divide and add now.
If a number is even, we divide by 2, else we increment by 1 and then divide by 2. This will always give an optimal answer.
"""


class Solution:
    def brokenCalc(self, X: int, Y: int) -> int:
        count = 0
        while Y > X:
            if Y % 2 == 0:
                Y //= 2
            else:
                Y += 1
            count += 1
        return count+X-Y

# from collections import deque
# class Solution:
#     def brokenCalc(self, X: int, Y: int) -> int:
#         count=0
#         q=deque([X])
#         while q:
#             size=len(q)
#             for i in range(size):
#                 curr=q.popleft()
#                 if curr==Y:
#                     return count
#                 if curr<Y:
#                     q.append(curr*2)
#                 q.append(curr-1)
#             count+=1
#         return count
