# Approach - DFS 
# Time - O(N)
# Space - O(H) - height/depth of tree

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        
        return self.dfs(nestedList, depth=1)
        
        
    def dfs(self, nestedList, depth):
        total = 0
        
        for element in nestedList:
            if element.isInteger():
                total += element.getInteger() * depth
                
            else:
                total += self.dfs(element.getList(), depth + 1)
                
        return total



# BFS Approach
# O(N) Time and O(N) space

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:

        if not nestedList:
            return 0

        queue = deque()
        total = 0
        depth = 1

        for element in nestedList:
            queue.append(element)

        while queue:
            size = len(queue)
            
            for i in range(size):
                element = queue.popleft()

                if element.isInteger():
                    total += element.getInteger() * depth

                else:
                    for elem in element.getList():
                        queue.append(elem)

            depth += 1

        return total

