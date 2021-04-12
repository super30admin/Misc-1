
"""
Time Complexity : O(n)- for both DFS and BFS solutions
Space Complexity : O(n) for BFS and O(1)for DFS if excluding recursive stack space  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
I have done both BFS and DFS here. We just keep on appending the new list onto a queue and keep incrementing the depth.
"""

# BFS Solution
class Solution(object):
    def depthSum(self, nestedList):
        if not nestedList or len(nestedList) == 0:
            return 0
        
        queue = deque()
        depth = 1
        total = 0
        
        for element in nestedList:
            queue.append(element)
            
        while queue:
            for i in range(len(queue)):
                element = queue.popleft()
                
                if element.isInteger():
                    total += depth * element.getInteger()
                    
                else:
                    for num in element.getList():
                        queue.append(num)
            depth += 1
        return total    
      
# DFS Solution

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        if not nestedList or len(nestedList) == 0:
            return 0
        
        self.sum = 0
        self.dfs(nestedList, 1)
        return self.sum
    
    def dfs(self, nestedList, depth):
        for n in nestedList:
            #print(n)
            if n.isInteger():
                self.sum += n.getInteger() * depth
            else:
                self.dfs(n.getList(), depth + 1)
