from collections import deque


class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        total = 0
        q = deque()
        depth = 1
        for nl in nestedList:
            q.append(nl)

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr.isInteger():
                    total += depth * curr.getInteger
                else:
                    for nl in curr.getList():
                        q.append(nl)

            depth += 1

        return total

# BFS
# Space complexity: O(n)
# Time complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
