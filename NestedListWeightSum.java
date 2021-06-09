class NestedListWeightSum {

    // Time Complexity: O(n*k)          (where k -> max length of list in a nested list and n -> length of nestList)
    // Space Complexity: O(max(depth))  

    public int depthSum(List<NestedInteger> nestedList) {
        return recur(nestedList);
    }

    private int recur(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger list : nestedList){
            if(list.isInteger())
                sum += depth * list.getInteger();
            else
                sum += recur(list.getList(), depth+1);
        }

        return sum;
    }
}