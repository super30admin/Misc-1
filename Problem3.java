public class Problem3 {
    int sum;

    // DFS solution
    // TC : O(n)
    // SC : O(n)
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;

        dfs(nestedList, 1);
        return sum;

    }

    private void dfs(List<NestedInteger> nestedList, int depth) {
        //base case

        //logic
        for (NestedInteger el : nestedList) {
            if (el.isInteger()) {
                sum = sum + el.getInteger() * depth;
            } else {
                dfs(el.getList(), depth + 1);
            }
        }
    }

    // BFS Solution
    // TC : O(n)
    // SC : O(n)
    public int depthSum1(List<NestedInteger> nestedList) {
        // DFS solution
        if (nestedList == null || nestedList.size() == 0) return 0;
        int sum = 0;
        int depth = 1;

        Queue<List<NestedInteger>> que = new LinkedList<>();
        que.add(nestedList);

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                List<NestedInteger> curr = que.poll();
                for (NestedInteger el : curr) {
                    if (el.isInteger()) {
                        sum = sum + el.getInteger() * depth;
                    } else {
                        que.add(el.getList());
                    }
                }
            }
            depth++;
        }
        return sum;
    }

}
