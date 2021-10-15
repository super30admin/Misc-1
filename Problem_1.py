class Solution(object):
    def brokenCalc(self, startValue, target):
        queue = deque()
        queue.append(startValue)
        minimum = 0
        while len(queue) != 0:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if curr == target:
                    return minimum
                if curr < target:
                    queue.append(curr * 2)
                queue.append(curr -1)
            minimum += 1
        return minimum
        
# Time Complexity: O(2^target)
# Space Complexity: O(target)

class Solution(object):
    def brokenCalc(self, startValue, target):
        count = 0
        while target > startValue:
            if target % 2 == 0:
                target = target // 2
            else:
                target = target + 1
            count += 1
        return count + startValue - target

# Time Complexity: O(log(n))
# Space Complexity: O(1)