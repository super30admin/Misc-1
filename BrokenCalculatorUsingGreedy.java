// Time Complexity : O(log n)  + O(k)   -> n is the number od divisions and k is add 1 which is very small.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class BrokenCalculatorUsingGreedy {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while(startValue < target)
        {
            if(target %2 ==0){
                target = target /2;
            }else{
                target = target + 1;
            }
            count++;
        }
        return count+(startValue - target);

        /*
        if(startValue >= target) return startValue - target;
         if(target % 2 == 0)
        {
            count = 1+brokenCalc(startValue, target/2);
        }
        else {
            count = 1+brokenCalc(startValue,target+1);
        }

        return count;
        */
    }
}
