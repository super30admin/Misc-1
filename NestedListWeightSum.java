// Time Complexity : O(n) --> where n is the number of NestedInteger in the input list
// Space Complexity : O(d) --> where d is the depth of the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return sum;
    }
    
    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger ele : nestedList) {
            if (ele.isInteger()) sum += ele.getInteger() * depth;
            else dfs(ele.getList(), depth + 1);
        }
    }
}