
// Time Complexity : O(n)
// Space Complexity : O(d)  maximum level of nesting in the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {

    // ******** BFS 
    public int depthSumBFS(List<NestedInteger> nestedList) {
        
        Queue<NestedInteger> q = new LinkedList<>(nestedList);
        int res =0;
        int depth =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                NestedInteger front = q.remove();
                if(front.isInteger()){
                    res += front.getInteger() * depth; 
                }else{
                    q.addAll(front.getList());
                }
            }
            depth++;
        }
        return res;
    }
    
    
    // ******** DFS 
     public int depthSum(List<NestedInteger> nestedList) {
         return dfs(nestedList, 1);
     }
    
    private int dfs(List<NestedInteger> nestedList, int depth) {
        int result = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result += depth * ni.getInteger();
            } else {
                result += dfs(ni.getList(), depth + 1);
            }
        }
        return result;
    }
}