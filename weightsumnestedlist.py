"""
time on
space on
we perform dfs on the list and iterate ovr the list is the element encounter is integer we add it total
else we again dfs on list and depth+1
"""

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        # self.total=0
        def dfs(nestedl, depth):
            total = 0
            for el in nestedl:
                if el.isInteger():
                    total += el.getInteger() * depth
                else:
                    total += dfs(el.getList(), depth + 1)
            return total

        return dfs(nestedList, 1)
