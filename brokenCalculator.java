// Time Complexity = O(log n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Here we ask the interviewer if we can use + and / operation, since we will be moving back from the target to reach the start
// This reverse checking will reduce our complexity from exponential (going from start to target), to log n
// if the target is even we can directly divide the target by 2, otherwise we have to add 1 to the target so that it becomes even and can be divisible by 2
// once the target is smaller than startValue, we can calculate the difference between the two to reach the target and add it to ops to return the final operations
class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue == target) return 0;

        int ops=0;

        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;
            }
            else {
                target += 1;
            }
            ops++;
        }

        return ops+(startValue-target);
    }
}
