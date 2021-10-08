// Time Complexity : O(n), n -> Number of integers
// Space Complexity : O(d), d -> Maximum level of nesting
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.List;

public class NestedListWeightSum {
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

	public static void main(String[] args) {
//		NestedListWeightSum obj = new NestedListWeightSum();

	}

}
