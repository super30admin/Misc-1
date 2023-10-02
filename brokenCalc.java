// **Optimized → Go from target to → startvalue (Ask interview if you are allowed to use /2 and +1 i.e division and addition operation) take greedy path i.e best path**
//     1. If number is divisible by 2 → then only divide it or add 1 to it
//     2. Once your number reaches less than target → target - number = number of steps (i.e you need to add 1 these many times, so add this number to your step count)
//     3. TC: log(target value) SC: O(1)
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
