// Time Complexity : O(X - Y)
// Space Complexity : O(1)
// Passed Leetcode

class Solution {
    public int brokenCalc(int X, int Y) {
        int moves = 0;
        while (Y > X) {
            
            if (Y % 2 == 0) {
                Y = Y / 2;
            } else 
                Y = Y + 1;
            moves += 1;
        }
        
        return moves + X - Y;
        
    }
}