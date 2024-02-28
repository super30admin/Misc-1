// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList,1);
    }
    public int dfs(List<NestedInteger> nestedList, int depth){
        int result = 0;
        for(NestedInteger el : nestedList){
            if(el.isInteger()){
                result += depth*el.getInteger();
            }
            else{
                result += dfs(el.getList(),depth+1);
            }
        }
        return result;
    }
}