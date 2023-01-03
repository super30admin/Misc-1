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
 //time - O(n*k)
 //space - O(n*k)
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int result =0;
        Queue<List<NestedInteger>> nestQ = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        nestQ.add(nestedList);
        depthQ.add(1);
        while(!nestQ.isEmpty()){
            List<NestedInteger> ele = nestQ.poll();
            int depth = depthQ.poll();
            for(NestedInteger el : ele){
                if(el.isInteger()){
                    result+= el.getInteger()*depth;
                }else{
                    nestQ.add(el.getList());
                    depthQ.add(depth+1);
                }
            }
        }
        return result;

    }
}