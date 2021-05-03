// Time Complexity : O(log Y)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public int brokenCalc(int x, int y) {
        
        int ans = 0;
        
        while(x<y) {
            ans++;
            if(y%2==1) {
                y++;
            } else {
                y/=2;
            }
        }
        
        return ans + x - y;
        
    }
}
