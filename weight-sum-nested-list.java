// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int sum = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        helper(nestedList, 1);
        return sum;
    }

    private void helper(List<NestedInteger> ns, int depth) {
        for (NestedInteger n : ns) {
            if (n.isInteger()) {
                sum += depth * n.getInteger();
            } else {
                List<NestedInteger> ls = n.getList();
                helper(ls, depth + 1);
            }
        }
    }
}
