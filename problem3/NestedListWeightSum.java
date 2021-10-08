// Time Complexity : O(n), n -> Number of integers
// Space Complexity : O(d), d -> Maximum level of nesting
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {
	/********************* DFS *********************/
	public int depthSum(List<NestedInteger> nestedList) {
		return helper(nestedList, 1);
	}

	public int helper(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger num : nestedList) {
			if (num.isInteger()) {
				sum += num.getInteger() * depth;
			} else {
				sum += helper(num.getList(), depth + 1);
			}
		}
		return sum;
	}

	/********************* DFS *********************/
	public int depthSumBFS(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}

		int sum = 0;

		Queue<Pair> queue = new LinkedList<>();

		for (NestedInteger num : nestedList) {
			queue.add(new Pair(num, 1));
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Pair p = queue.poll();
				NestedInteger num = p.num;
				int level = p.level;

				if (num.isInteger()) {
					sum += num.getInteger() * level;
				} else {
					for (NestedInteger curr : num.getList()) {
						queue.add(new Pair(curr, level + 1));
					}
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
//		NestedListWeightSum obj = new NestedListWeightSum();

	}

}
