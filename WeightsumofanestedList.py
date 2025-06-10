# Time Complexity : O(n*d)
# Space Complexity : O(d)

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        res = [0]

        def dfs(lst, depth):
            for el in lst:
                if el.isInteger():
                    res[0] += el.getInteger() * depth
                else:
                    dfs(el.getList(), depth + 1)

        dfs(nestedList, 1)
        return res[0]