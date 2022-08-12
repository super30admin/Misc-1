// Time Complexity : O(log(target))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class BrokenCalculator {
    class Solution {
        public int brokenCalc(int startValue, int target) {
            int ops = 0;
            while (startValue < target) {
                if (target % 2 == 0)
                    target /= 2;
                else
                    target += 1;
                ++ops;
            }
            return ops + startValue - target;
        }
    }
}
