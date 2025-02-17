import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem3 {
     public interface NestedInteger {
      // Constructor initializes an empty nested list.
         //     public NestedInteger();

              // Constructor initializes a single integer.
         //     public NestedInteger(int value);

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
  // BFS
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int depthSum(List<NestedInteger> nestedList) {
         int result=0;
        Queue<NestedInteger> q= new LinkedList<>();
        for(NestedInteger ne: nestedList)
        {
            q.add(ne);
        }
        int size=0;
        int depth=1;
        while(!q.isEmpty())
        {
            size=q.size();
            for (int i=0;i<size;i++)
            {
                NestedInteger curr= q.poll();
                if (curr.isInteger())
                {
                    result+=curr.getInteger()*depth;
                }
                else {
                    for (NestedInteger ne: curr.getList())
                    { q.add(ne);}
                }
            }
            depth++;
        }

         return result;
    }
    // DFS
    // Time Complexity: O(n)
    // Space Complexity: O(d), depth of nesting
    int result;
    public int depthSum1(List<NestedInteger> nestedList) {
        this.result=0;
        dfs(nestedList,1);
        return result;
    }
    private void dfs(List<NestedInteger> nestedList, int depth)
    {
        for (NestedInteger ne:nestedList )
        {
            if (ne.isInteger())
            {
                result+=depth*ne.getInteger();
            }
            else {
                dfs(ne.getList(), depth+1);
            }
        }
    }
}
