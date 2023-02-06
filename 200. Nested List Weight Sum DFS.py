class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        def dfs(nestedList, depth):
            temp_sum = 0
            for elem in nestedList:
                if elem.isInteger():
                    temp_sum += elem.getInteger() * depth
                    else:
                    temp_sum += dfs(elem.getList(), depth + 1)
            return temp_sum

        return dfs(nestedList, 1)

#DFS
# Space complexity: O(depth)
# Time complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No