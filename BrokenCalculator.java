public class BrokenCalculator {
    // Greedy approach
    // TC : O(log n) - since we wll be dividing the number by 2 at certain places (not always)
    // SC : O(1)
    public int brokenCalc(int startValue, int target) {
        if(startValue == target) return 0;

        int count = 0;
        while(target > startValue) {
            if(target % 2 == 0){
                target = target / 2; // going in reverse
            }else {
                target = target + 1; // again, going in reverse
            }
            count++;
        }

        // this will take care of the use case when the start value was greater than target when we get the input
        // in that case, while loop won't work and the next line will take care of it.
        return count + (startValue - target);
    }
}
