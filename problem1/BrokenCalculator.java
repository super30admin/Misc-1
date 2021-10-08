// Time Complexity : O(log(target))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.LinkedList;
import java.util.Queue;

public class BrokenCalculator {
	/********************* BFS *********************/
	// Time Complexity : O(2^target)
	// Space Complexity : O(target)
	// Did this code successfully run on Leetcode : TimeLimit Exceeded
	// Any problem you faced while coding this : No
	public int brokenCalcBFS(int startValue, int target) {
		if (startValue == target) {
			return 0;
		}

		Queue<Long> queue = new LinkedList<>();
		queue.add((long) startValue);

		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				long curr = queue.poll();
				if (curr == (long) target) {
					return steps;
				}
				if (curr < target) {
					queue.add(curr * 2);
				}
				queue.add(curr - 1);
			}
			steps++;
		}

		return steps;
	}

	/********************* BFS *********************/
	// Time Complexity : O(log(target))
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int brokenCalc(int startValue, int target) {
		if (startValue == target) {
			return 0;
		}

		int steps = 0;

		while (target > startValue) {
			if (target % 2 == 1) {
				target += 1;
			} else {
				target /= 2;
			}
			steps++;
		}
		return steps + startValue - target;
	}

	public static void main(String[] args) {
		BrokenCalculator obj = new BrokenCalculator();
		int x = 2;
		int y = 3;

		System.out.println("Minimum number of operations to reach target: " + obj.brokenCalc(x, y));
	}

}
