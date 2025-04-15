class Solution(object):
    def brokenCalc(self, startValue, target):
        """
        :type startValue: int
        :type target: int
        :rtype: int
        """
        if startValue == target:
            return 0
        if  startValue > target:
            return startValue - target
        # clarifying question can be what happens if 0
        count = 0
        while  target > startValue:
            if target % 2 == 0:
                target = target/2
            else:
                target = target +1
            count += 1
        return count + (startValue - target)

        # TC : O(logn)
        # SC : O(1)
     