// Time Complexity : O(log(target - startValue))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while(target > startValue){
            if(target % 2 == 0)
                target /= 2;
            else
                target += 1;
            count++;
        }
        return count + startValue - target;
    }
}