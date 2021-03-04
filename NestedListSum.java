// Time Complexity : O(N) N  is sum of count of integers and nested lists
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We iterate through each nested integer in the given list
// If it is an integer we add n * d to sum
// If it is a list, we recursively calculate for the list with depth d + 1
// return sum

class Solution {
    
    int sum;
    
    public int depthSum(List<NestedInteger> nestedList) {
        
        if(nestedList == null) return sum;
        
        dfs(nestedList, 1);
        
        return sum;
    }
    
    private void dfs(List<NestedInteger> nestedList, int depth) {
        
        if(nestedList == null) return;
        
        for(NestedInteger el : nestedList) {
            if(el.isInteger()) {
                sum += el.getInteger() * depth;
            }
            else {
                dfs(el.getList(), depth + 1);
            }
        }
    }
}