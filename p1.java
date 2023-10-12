// Time Complexity :O(log(target))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue == target) return 0;
        int ops = 0;
        while(target > startValue){
            if(target%2 == 0){
                target = target/2;
            }else{
                target++;
            }
            ops++;
        }
        if(target < startValue){
            ops = ops + startValue - target;
        }
        return ops;
    }
}