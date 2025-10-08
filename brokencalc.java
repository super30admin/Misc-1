//TC: O(log (target)): each step halves target when even (and at most one +1 before each halve); final add is O(1).
//SC: O(1): constant extra variables (steps).

//Work backwards: while target > startValue, if target is even, halve it; else increment it to make it even, counting steps.
//Once target ≤ startValue, answer is steps + (startValue - target) since only decrements remain.

class Solution {
    public int brokenCalc(int startValue, int target) {
        
        int steps = 0;

        while(target > startValue){
            if(target % 2 == 0){
                target = target / 2;
            }else{
                target = target + 1;
            }
            steps++;
        }

        return steps + startValue - target;
    }
}
