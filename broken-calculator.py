# TIME COMPLEXITY: O(log Y)
# SPACE COMPLEXITY: O(1)
class Solution(object):
    def brokenCalc(self, X, Y):
        """
        :type X: int
        :type Y: int
        :rtype: int
        """
        count = 0
        # Invert the problem, try /2 and +1 operations
        # We are essentially pruning the options greedily by half at every step
        while Y > X:
            if Y % 2 == 0:
                Y = Y / 2
            else:
                Y += 1
            count += 1
        return count + X - Y