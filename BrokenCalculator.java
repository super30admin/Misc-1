/**
 * Time Complexity:  O(log k)  where k is the target
 * Space Complexity: O(1)
 */
class Solution {
    public int brokenCalc(int startValue, int target) {
        int steps = 0;
        while(target > startValue){
            if(target % 2 == 0){
                target = target/2;
            }else{
                target = target + 1;
            }
            steps++;
        }

        return steps + (startValue - target);

    }
}