# Approach - Instead of going from X to Y, the reverse gives us optimal moves

# Time -  O(log Y) search space gets reduced by half mostly, '+' operation is negligible as we do // more than that
# Space - O(1)

# class Solution:
    def brokenCalc(self, X: int, Y: int) -> int:
        
        counts = 0

        while Y > X:
            if Y % 2 == 0:
                Y = Y // 2

            else:
                Y = Y + 1
            
            counts += 1

        # when Y is no longer > X
        counts += X - Y
        return counts

        
# Brute Force
# TLE - O(2 ^ N) at each stage we make 2 moves, * and - 
# To optimise we can stop * once we reach > target, yet it gives us TLE