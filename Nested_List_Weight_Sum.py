#space:O(depth)
#time:O(n)
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        self.ans = 0
        def dfs(iterable,depth):
            
            for val in iterable:
                if val.isInteger():
                    self.ans+=depth*val.getInteger()
                else:
                    dfs(val.getList(),depth+1)
        dfs(nestedList,1)
        return self.ans