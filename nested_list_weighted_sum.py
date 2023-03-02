# Time Complexity: O(n)
# Space Complxty: O(n)

from collections import deque


class Solution:
    res = 0

    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        self.stack = deque(nestedList)
        # for el in nestedList: self.stack.append(el)

        dep = 1
        while self.stack:
            size = len(self.stack)
            for i in range(size):
                val = self.stack.pop()
                # print(val)
                if val.isInteger():
                    self.res += (val.getInteger()*dep)
                else:
                    self.stack.extendleft(val.getList())
            dep += 1
        return self.res
#         def dfs(nestedList, depth):
#             #Logic
#             for el in nestedList:
#                 if el.isInteger():
#                     self.res += (depth*el.getInteger())
#                 else:
#                     dfs(el.getList(), depth+1)
#         dfs(nestedList, 1)
#         return self.res
