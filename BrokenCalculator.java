//Time Complexity O(Log N)
//Space Complexity O(1) 
//Leetcode tested


public class BrokenCalculator {
        public int brokenCalc(int startValue, int target) {
            if(startValue >= target) return startValue-target;
            if(target%2 == 0) return 1 + brokenCalc(startValue,target/2);
            return 1 + brokenCalc(startValue,target+1);
        }
}
