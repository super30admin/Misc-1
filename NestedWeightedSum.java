import java.jutil.*;

//Time Complexity : O(N) for N is the total number of nested elements
//Space Complexity : O(D) for Stack Size and BFS
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
Because the input is nested, it is natural to think about the problem in a recursive way. 
We go through the list of nested integers one by one, 
keeping track of the current depth dd.
 If a nested integer is an integer nn, we calculate its sum as n\times dn×d.
  If the nested integer is a list, we calculate the sum of this list recursively using the same process
   but with depth d+1.
*/

public class NestedWeightedSum {
    int sum =0;
    public int depthSum(List<NestedInteger> nestedList) {
          if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger nestedInt : nestedList) {
            queue.offer(nestedInt);
        }
        
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInt = queue.poll();
                if (nestedInt.isInteger()) {
                    sum += nestedInt.getInteger() * depth;
                } else {
                    for (NestedInteger innerInt : nestedInt.getList()) {
                        queue.offer(innerInt);
                    }
                }
            }
        }
        return sum;
    }

    public void dfs(List<NestedInteger> nestedList,int depth){
        for(NestedInteger list: nestedList){
            if(list.isInteger()){
                sum += list.getInteger() * depth;
            }
            else {
                dfs(list.getList(),depth + 1);
            }
        }
    }
}