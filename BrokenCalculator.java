public class BrokenCalculator {
    /**
     * brute force
     * BFS
     *
     *
     *
     */





    /**
     * if target divisible by 2 - devide.
     * if itsn ot divisible by 2 add 1.
     * adding one to count of operations everytime.
     * until we are at or above target.
     * if we fall below target, compute target - the final value.
     * that + count gives number of operations
     - Time Complexity - o(logN) - because deviding by 2 in every iteration
     - Space Complexity - o(1)
     *
     */
    public int brokenCalc(int startValue, int target) {
        if (startValue == target) {
            return 0;
        }

        int count = 0;
        while (target > startValue) {
            if (target % 2 == 0) {
                target = target / 2;
            } else {
                target = target + 1;
            }
            count++;
        }
        return count + (startValue - target);
    }

}
