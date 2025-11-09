public class BrokenCalculator {

// Time Complexity: O(log(target))
// Space Complexity: O(1)
// We keep halving the target if it's even, else we just increment it by 1.
// We repeat this until the target drops to or below the start.
// After that, we just need to count how far off we are and add that.
    public int brokenCalc(int startVal, int target){
        int steps = 0;
        while(target>startVal)
        {
            if(target % 2 ==0)
            {
                target = target / 2;
            }
            else{
                target = target +1;
            }
            steps++;
        }
        return steps+startVal-target;
    }
}
