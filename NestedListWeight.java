//time: O(N) | Space: O(N)

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
        int result = 0;
        Queue<List<NestedInteger>> q = new LinkedList<>();
        q.add(nestedList);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0;i<size;i++) {
                List<NestedInteger> curr = q.poll();
                for(NestedInteger item: curr) {
                    if(item.isInteger()) {
                        result += item.getInteger()*level;
                    }else {
                        q.add(item.getList());
                    }
                }
            }
        }
        return result;
    }
}