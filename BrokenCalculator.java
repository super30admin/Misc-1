// Time Complexity : log(n) where n is the target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Opertions to conver startValue to target would be same as the target to startValue
// If its even divide else add 1, also keep the count of operations
// Finally return the operatios + starValue - target
class Solution {
    public int brokenCalc(int startValue, int target) {
        int operations = 0;
        while(startValue < target){
            operations++;
            if(target%2 == 1)
                target++;
            else
                target /= 2;
        }
        return operations + startValue - target;
    }
}