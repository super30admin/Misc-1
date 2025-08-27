// TC: O(n)
// SC: O(n)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    /**
     * @param nestedList: a list of NestedInteger
     * @return: the sum
     */
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> bfs = new LinkedList<>();
        int result = 0;

        for(NestedInteger el: nestedList){
            bfs.add(el);
        }

        int weight = 1;
        while(!bfs.isEmpty()){
            int size = bfs.size();

            for(int i=0; i<size; i++){
                NestedInteger curr = bfs.poll();

                if(curr.isInteger()){
                    result = result + (curr.getInteger() * weight);
                }else{
                    for(NestedInteger el: curr.getList()){
                        bfs.add(el);
                    }
                }
            }
            weight++;
        }

        return result;
    }
}