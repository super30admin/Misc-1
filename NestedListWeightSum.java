// Time Complexity : O(n). where n is the number of integers in the nexted list. 
// Space Complexity : O(d), where d is the maximum depth of the nested list.

class Solution {
	public int depthSum(List<NestedInteger> nestedList) {
		Wrapper wrapper = new Wrapper(0);
		traverse(nestedList, 1, wrapper);
		return wrapper.sum;
	}

	private void traverse(List<NestedInteger> nestedList, int depth, Wrapper wrapper) {
		for(NestedInteger entry : nestedList) {
			if(entry.isInteger()) {
				wrapper.sum += depth * entry.getInteger();
			} else {
				traverse(entry.getList(), depth+1, wrapper);
			}
		}
	}
}

class Wrapper {
	Integer sum;
	Wrapper(Integer sum) {
		this.sum = sum;
	}
}