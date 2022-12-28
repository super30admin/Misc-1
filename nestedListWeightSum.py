#Time: O(n)
#Space: O(h)
#Program ran on leetcode successfully


class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        return self.dfs(nestedList, 1)      


    def DFS(self, nestedList, depth):
                temp_sum = 0
                for elem in nestedList:
                    if elem.isInteger():
                        temp_sum += elem.getInteger() * depth
                    else:
                        temp_sum += self.DFS(elem.getList(),depth+1)
                return temp_sum