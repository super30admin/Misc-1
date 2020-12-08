
// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            res++;
            if (!isEven(Y)) {
                Y++;  
            }else{
                Y /= 2;
            }
        }
        return res + X - Y;
    }
    
    // ********** DFS
    private boolean isEven(int num) {
        return (num % 2 == 0);
    }

  public int brokenCalcDFS(int X, int Y) {
    if (X > Y) {
      return X - Y;
    }
    if(X==Y){
      return 0;
    }
    if (!isEven(Y)) {
      return brokenCalc(X, Y + 1) + 1;
    } else {
      return brokenCalc(X, Y / 2) + 1;
    }
  }
    
    
    
    
}