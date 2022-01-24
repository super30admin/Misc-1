// Time Complexity: O(n)
// Space Complexity: O(n)
import java.util.*;
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    public int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }
}