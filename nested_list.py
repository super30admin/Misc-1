
class Solution:
    # Time complexity - O(n)
    # Space Complexity - O(h) - depth of the tree
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        

        def dfs(nestedList, depth):
            nonlocal result
            for each in nestedList:
                if each.getInteger():
                    result += depth * each.getInteger()
                else:
                    newList = each.getList()
                    dfs(newList, depth+1)
        result = 0
        dfs(nestedList, 1)
        return result

