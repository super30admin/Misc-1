// Time Complexity : O(n) where n is the number of elements in the List
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach:  Its a DFS, as you go to a list, check if it is nested list or an integer, if it is
nested list, further explore and if it is integer, add it to the sum * depth. The depth will keep on incrementing as you go down. 
*/
class Solution {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        sum = 0;
        int depth = 1;                                                                                      // Start from height of 1
        dfs(nestedList, depth);
        return sum;                                                                                         // Return the total sum
    }
    private void dfs(List<NestedInteger> nestedList, int depth){    
        for(NestedInteger n : nestedList){                                                                          // For each of nested integer
            if(n.isInteger()){  
                sum += n.getInteger() * depth;                                                                  // check the sum * depth as per weight calculation
            } else {
                List<NestedInteger> li = n.getList();
                dfs(li, depth+1);                                                                           // Explore the nested list further
            }
        } 
    }
}