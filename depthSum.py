class Solution:
    '''
    BFS 
    T = O(N)
    S = O(N)
    '''
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        q = deque(nestedList)
        ans = 0 
        depth = 1 
        while q:
            for i in range(len(q)):
                curr = q.pop()
                if curr.isInteger():
                    ans += curr.getInteger() * depth
                else:
                    q.extendleft(curr.getList())
            depth += 1 
        return ans
        
        
        
