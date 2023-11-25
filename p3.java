// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        //using bfs
        Queue<NestedInteger> q = new LinkedList<>();
        //get the first list in the queue
        for(int i=0; i<nestedList.size(); i++){
            q.add(nestedList.get(i));
        }
        int depth = 1;
        int result = 0;
        //process the queue till its empty
        while(!q.isEmpty()){
            int size = q.size();
            //go through all elements for each level
            for(int i=0; i<size; i++){
                NestedInteger n = q.remove();
                //if the nestedinter is an integer
                if(n.isInteger()){
                    result = result + (depth*n.getInteger());
                } else{//if the nested integer has a list of nested ineteger
                    List<NestedInteger> list = n.getList();
                    for(int j=0; j<list.size(); j++){
                        q.add(list.get(j));
                    }
                }
            }
            depth++;
            
        }
        return result;
    }
}