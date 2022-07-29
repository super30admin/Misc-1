// Time Complexity : O(depth)
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int result;
    
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) {
            return 0;
        }
        
        dfs(nestedList, 1);
        return result;
    }
    
    private void dfs(List<NestedInteger> nestedList, int depth) {
        
        
        for(NestedInteger nestedInteger : nestedList) {
            
            if(nestedInteger.isInteger()) {
                result += (depth * nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList(), depth + 1);
            }
        }
    }
}