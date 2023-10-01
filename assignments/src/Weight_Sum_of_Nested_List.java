// Approach: Simple DFS
// Time: O(n)
// Space: O(n) for the recursion stack
class Weight_Sum_of_Nested_List {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return sum;
    }

    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger el : nestedList) {
            if (el.isInteger()) {
                sum += depth * el.getInteger();
            } else {
                dfs(el.getList(), depth + 1);
            }
        }
    }
}