import java.util.List;
import java.util.ArrayList;
import java.util.*;
// Using DFS
// Time Complexity: O(n)
// Space Complexity: O(n)

//Using BFS
// Time Complexity: O(n)
// Space Complexity: O(n)

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    
    public int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += depthSum(ni.getList(), depth + 1);
            }
        }
        return sum;
    }

    //using BFS
    public int depthSumBFS(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int sum = 0;
        int level = 1;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                NestedInteger ni = queue.poll();
                if (ni.isInteger()) {
                    sum += ni.getInteger() * level;
                } else {
                    queue.addAll(ni.getList());
                }
            }
            level++;
        }
        return sum;
    }
}