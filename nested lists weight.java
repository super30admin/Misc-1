//tc;- O(n).
//sc:- O(1).

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
    public int depthSum(List<NestedInteger> nestedList) {
        return reccursion(nestedList,1);
    }
    private int reccursion(List<NestedInteger> nestedList,int depth){
        int sum=0;
        for(NestedInteger index: nestedList){
            if(index.isInteger()){
                sum=sum+index.getInteger()*depth;       //The fact that there are nested lists and we need to process the lists again and again and is reccursion
            }// so for each element in given list if it is normal integer,then  sum is updated with that integer*depth.
            // if present element is list, then calling reccur with this list and depth incremented by 1.
            else{
                sum=sum+reccursion(index.getList(),depth+1);
            }
        }
        return sum;
    }
}