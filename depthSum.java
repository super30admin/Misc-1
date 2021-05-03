// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    int ans = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return ans;
    }
    
    public void dfs(List<NestedInteger> ls,int d) {
        
        for(int i=0;i<ls.size();i++) {
           
            if(ls.get(i).isInteger()) ans+=d*ls.get(i).getInteger();
            else dfs(ls.get(i).getList(), d+1);
            
            
        }
    
    }
}
