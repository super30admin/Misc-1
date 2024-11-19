//Time Complexity : O(log(target)) + O(k)
//Space Complexity : O(1)
//Did this code run successfully on leetcode : Yes
//Have you faced any issue while rwriting this code : No
class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int steps = 0;
        while(target > startValue) {
            if(target % 2 == 0) {
                target = target / 2;    
            } else {
                target = target + 1;   
            }
            steps++;
        }
        return steps + startValue - target;
    }
}