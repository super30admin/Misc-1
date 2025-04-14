// TC: O(log n base 2)
// SC: O(1)

public class LC991 {
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target)
            return startValue - target;
        int ops = 0;
        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;
            } else {
                target++;
            }
            ops++;
        }
        return ops - target + startValue;
    }
}
