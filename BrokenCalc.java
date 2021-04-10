// Time Complexity : The time complexity is O(log(Y-X)) since at every step we are reducing the search space by half
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int brokenCalc(int X, int Y) {

        int steps = 0;

        // try to get X from Y by performing division and addition operations greedely
        while(Y > X){
            if(Y % 2 == 0){
                Y = Y/2;
            }
            else{
                Y++;
            }
            steps++;
        }
        return steps + (X-Y);
    }
}