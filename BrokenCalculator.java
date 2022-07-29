// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue == target) {
            return 0;
        }
        
        int count = 0;
        
        while(target > startValue) {
            
            if(target % 2 == 0) {
                target /= 2;
            } else {
                target += 1;
            }
            count++;
        }
        
        return count + (startValue - target);
    }
}