class Solution:
    def brokenCalc(self, x: int, y: int) -> int:
        if not y :
             return 0
        
        count = 0
        while y > x:
            if y % 2 == 0:
                y = y //2 
            else:
                y = y +1
            count +=1
        
        return count + x -y
