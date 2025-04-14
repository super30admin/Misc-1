// TC: O(n)
// SC: O(n)

import java.util.*;

public class LC339 {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        int depth = 1;
        int n = nestedList.size();
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                NestedInteger polled = q.poll();
                boolean isInteger = polled.isInteger();
                if (isInteger) {
                    sum += depth * polled.getInteger();
                } else {
                    q.addAll(polled.getList());
                }
                size--;
            }
            depth++;
        }
        return sum;
    }
}
