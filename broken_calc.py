# Time Complexity: O(log(target))
# Space Complxty: O(target/2)

class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        count = 0
        while target > startValue:
            if target % 2 == 0:
                target = target//2
            else:
                target += 1
            count += 1
        return count + (startValue - target)

        # q = deque()
        # if startValue == target: return 0
        # q.append(startValue - 1)
        # q.append(startValue*2)
        # count = 1
        # while q:
        #     size = len(q)
        #     for i in range(size):
        #         x = q.popleft()
        #         if x == target: return count
        #         q.append(x-1)
        #         if x < target:q.append(x*2)
        #     count += 1
        # return count
