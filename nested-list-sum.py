# BFS APPROACH
# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(N)
class Solution(object):
    def depthSum(self, nestedList):
        """
        :type nestedList: List[NestedInteger]
        :rtype: int
        """
        total = 0
        q = deque(nestedList)
        depth = 1
        while q:
            size = len(q)
            for _ in range(size):
                ele = q.popleft()
                if ele.isInteger():
                    total += depth*ele.getInteger()
                else:
                    q.extend(ele.getList())
            depth += 1
        return total
