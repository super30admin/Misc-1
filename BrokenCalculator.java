//tc O(logn)
//sc O(n)
class Solution {
    public int brokenCalc(int startValue, int target) {
        int sol = 0;
        while (target > startValue) {
            sol++;
            if (target % 2 == 1)
                target++;
            else
                target /= 2;
        }

        return sol + startValue - target;
    }
}