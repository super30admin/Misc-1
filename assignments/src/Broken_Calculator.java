// Approach: Think backwards - as it gives the correct Greedy approach required to
// solve this problem i.e. divide by 2 if target even or +1 if odd then divide.
// Time: O(log target)
// Space: O(1)

class Broken_Calculator {
    public int brokenCalc(int startValue, int target) {
        int steps = 0;

        while (target > startValue) {
            steps++;

            if (target % 2 == 1) {      // odd
                target++;
            } else {                    // even
                target /= 2;
            }
        }
        return steps + startValue - target;
    }
}