// Time Complexity : O(logY)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We start with Y with goal to reduce it to X
// If X is even, divide it by 2 else add 1 and then increment moves by 1
// We perform above step until Y is X

class Solution {
    public int brokenCalc(int X, int Y) {
        
        int moves = 0;
        
        while(Y > X) {
            if(Y % 2 == 0) {
                Y = Y / 2;
            } else {
                Y = Y + 1;
            }
            moves++;
        }
        if(X > Y) {
            moves = moves + X - Y;
        }
        return moves;
    }
}