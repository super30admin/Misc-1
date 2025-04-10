import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(t-a), where t is target and a is start value
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Since BFS approach leads to TLE because of the range, using greedy approach from the other way around
 */

public class BrokenCalc {
    // ------------ GREEDY APPROACH ---------------------
    public int brokenCalc(int startValue, int target) {
        int result = 0;
        while (target > startValue) {
            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
            result++;
        }

        return result + startValue - target;
    }


    // ------------ BFS approach - TLE ------------------
    public int brokenCalc2(int startValue, int target) {
        if (startValue > target) {
            return startValue - target;
        }

        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(startValue);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                if (curr == target) 
                    return level;
                
                if (curr > target) {
                    q.add(curr - 1);
                } else {
                    q.add(curr * 2);
                    q.add(curr - 1);
                }

            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        // Your code here
    }
}