// Time: O(N) | Space: O(1)

class Solution {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while(target > startValue) {
            if(target%2 == 0) target/=2;
            else target += 1;
            count++;
        }
        // to handle if startValue greater than target
        return count + startValue - target;
    }

}