class Solution:
    def reverse(self, X: int, Y: int) -> int:
        
        moves = 0
        while Y>X:
            if Y%2==0:
                Y//=2
            else:
                Y+=1
            moves+=1
        
        return moves+(X-Y)
Time: Log(Y)  
Space: O(1)

                
    def bfs(self, X: int, Y: int) -> int:
        moves = 0
        queue = deque([X])
        
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                if curr == Y:
                    return moves  
                queue.append(curr-1)
                if curr<Y:
                    queue.append(curr*2)
            moves+=1
            
        return moves
