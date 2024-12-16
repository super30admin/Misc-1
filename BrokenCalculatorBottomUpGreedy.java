// bottom up tree, greedy
// imagine the target as the starting point and go from there
// what does greedy mean -> only 1 decision at a single point.
// Time complexity = O(log(n)). height of the tree.
// Space complexity = O(1). no auxiliary data structure.
class Solution {
    public int brokenCalc(int startValue, int target) {
        int count=0;
        while(target> startValue ) {
            // just one single decision making point at every iteration(loop).
            if(target%2==0) { // is it even. I don't wanna lose the value, if it is odd.
                target/=2;
            }
            else {
                target+=1; // if it is odd.
            }
            count++;
        }
        return count+ startValue-target;                
    }
}