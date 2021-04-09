// Time Complexity : The time complexity is O(n) where n is the number of Integers
// Space Complexity : Te space complexity is O(h) where h is the depth of the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

//DFS
class Solution {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {
        sum = 0;
        dfs(nestedList,1);
        return sum;
    }

    public void dfs(List<NestedInteger> nestedList,int depth){

        // if the value is integer add it to the sum, else do dfs on the nested integer
        for(NestedInteger each:nestedList){
            if(each.isInteger()){
                sum += each.getInteger()*depth;
            }
            else{
                dfs(each.getList(),depth+1);
            }
        }
    }
}

// Time Complexity : The time complexity is O(n) where n is the number of Integers
// Space Complexity : Te space complexity is O(n) where n is the number of Integers
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS
class Solution {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {

        Queue<NestedInteger> q = new LinkedList<>();

        for(NestedInteger each:nestedList){
            q.offer(each);
        }

        sum = 0;
        int level = 1;

        // if the value is integer add it to the sum, else add the nested integer to the queue
        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){
                NestedInteger cur = q.poll();

                if(cur.isInteger()){
                    sum += cur.getInteger()*level;
                }
                else{
                    for(NestedInteger each:cur.getList()){
                        q.offer(each);
                    }
                }
            }
            level++;
        }
        return sum;
    }
}