#Time complexity: O(N)
#Space complexity: O(N)
#BFS

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        depth = 1
        res = 0
        q = deque()
        depthQ = deque()
        q.append(nestedList)
        depthQ.append(1)
        
        while q:
            currEle = q.popleft()
            currDepth = depthQ.popleft()
            for ele in currEle:
                if ele.isInteger():
                    res += ele.getInteger()*currDepth
                else:
                    q.append(ele.getList())
                    depthQ.append(currDepth+1)
        return res
    
#Iterative DFS
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        depth = 1
        res = 0
        st = []
        depthSt = []
        st.append(nestedList)
        depthSt.append(1)
        
        while st:
            currEle = st.pop()
            currDepth = depthSt.pop()
            for ele in currEle:
                if ele.isInteger():
                    res += ele.getInteger()*currDepth
                else:
                    st.append(ele.getList())
                    depthSt.append(currDepth+1)
        return res
 #DFS
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        depth = 1
        self.res = 0
        self.dfs(nestedList, depth)
        return self.res
    def dfs(self, nestedList, depth):
        for ele in nestedList:
            if ele.isInteger():
                self.res += ele.getInteger()*depth
            else:
                self.dfs(ele.getList(), depth+1)
      
                
        
