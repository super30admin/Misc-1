public int depthSum(List<NestedInteger> nestedList) {
    return depthSumHelper(nestedList, 1);
}

private int depthSumHelper(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger ni : nestedList) {
        if (ni.isInteger()) {
            sum += ni.getInteger() * depth;
        } else {
            sum += depthSumHelper(ni.getList(), depth + 1);
        }
    }
    return sum;
}



Time Complexity (TC): O(N), where N is the total number of nested elements.
Space Complexity (SC): O(D), where D is the maximum depth of nesting.
