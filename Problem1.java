/*
Broken Calculator
approach: we can use bfs but that would be exponential, we can optimize by going from target to start value
time: log target
space: O(1)
 */
public class Problem1 {
    public static int brokenCalc(int startValue, int target) {
        int op = 0;
        while (target > startValue) {
            if (target%2 == 0) {
                target/=2;
            }
            else {
                target+=1;
            }
            op++;
        }
        return op+startValue-target;
    }

    public static void main(String[] args) {
        System.out.println(brokenCalc(3,10));
    }
}
