class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        
        ## apprach 2 : bfs
        ## T.C = O(n)
        ## S.C = O(n)
        sm = 0
        q = [nestedList]
        depth = 1
        
        while q:

            for i in range(len(q)):
                elems = q.pop(0)
                for el in elems:     
                    if el.isInteger():
                        sm += el.getInteger() * depth
                    else:
                        q.append(el.getList())
            depth += 1

        return sm
        
        ## approach 1 : dfs
        ## T.C = O(n)
        ## S.C = O(depth)
        sm = 0
        def dfs(nums, depth):
            nonlocal sm

            for el in nums:
                if el.isInteger():
                    sm += el.getInteger() * depth
                else:
                    dfs(el.getList(), depth + 1)
        
        dfs(nestedList, 1)
        return sm
