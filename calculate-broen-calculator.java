// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (Y > X) {
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y += 1;
            }
            count++;
        }
        return count + X - Y;
    }
}
