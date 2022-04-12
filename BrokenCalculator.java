// Time Complexity : Add : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BrokenCalculator_Greedy {
    public static void main(String[] args) {
        brokenCalc(3, 10);
    }

    public static int brokenCalc(int startValue, int target) {
        //base
        if(startValue == target)
            return 0;

        int level = 0;

        while(target > startValue){  // T.C - O(log N)
            if(target %2 == 0)
                target /= 2;
            else
                target += 1;

            level++;
        }

        return level + (startValue - target);

    }
}

