"""
Time Complexity : O(n)- for both DFS and BFS solutions
Space Complexity : O(n) for BFS and O(1)for DFS if excluding recursive stack space  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

I have done both BFS and DFS here. We just keep on appending the new list onto a queue and keep incrementing the depth.
"""


from collections import deque


class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        if not nestedList:
            return 0
        self.sum = 0
        self.helper(nestedList, 1)
        return self.sum

    def helper(self, nestedList, level):
        for n in nestedList:
            if n.isInteger():
                self.sum += n.getInteger()*level
            else:
                self.helper(n.getList(), level+1)


class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        q = deque(nestedList)
        depth, total = 1, 0

        while q:
            size = len(q)
            for i in range(size):
                nested = q.popleft()
                if nested.isInteger():
                    total += nested.getInteger() * depth
                else:
                    q.extend(nested.getList())
            depth += 1

        return total
