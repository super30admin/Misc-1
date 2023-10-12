import java.util.List;

// This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
   interface NestedInteger {


      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

// Time Complexity : O(n)  - n is the number of integers in the input
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

public class NestedListWeightSum {

    int result;
    public int depthSum(List<NestedInteger> nestedList) {

        helper(nestedList,1);
        return result;
    }

    private void helper(List<NestedInteger> nestedList, int depth){

        for(NestedInteger el : nestedList){
            if(el.isInteger()){
                result += el.getInteger()*depth;
            }else{
                helper(el.getList(), depth+1);
            }
        }
    }

    /* BFS SOlution
    TC: O(n) SC: O(n)
     public int depthSum(List<NestedInteger> nestedList) {
         int result = 0;
        Queue<NestedInteger> q = new LinkedList<>();

        for(NestedInteger el: nestedList){
            q.add(el);
        }
        int depth = 0;
        while(!q.isEmpty()){
            depth++;
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                NestedInteger el = q.poll();
                if(el.isInteger())
                {
                    result += el.getInteger() * depth;
                }
                else
                {
                    for(NestedInteger nel: el.getList()){
                            q.add(nel);
                    }
                }
            }
        }
        return result;
     }

     */
}
