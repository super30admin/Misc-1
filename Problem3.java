/*
Nested List Weight Sum
approach: same as nested iterator
time: O(n) n - is all nested integers
space: O(depth) worst case ex: [[[[]]]]
 */
public class Problem3 {
    class NestedInteger {
        public boolean isDigit() {
            return true;
        }

        public Integer getInteger() {
            return 0;
        }

        public NestedInteger[] getList() {
            return new NestedInteger[]{};
        }
    }
    int res = 0;
    private int weightSumofNestedList(NestedInteger[] nestedIntegers) {
        dfs(nestedIntegers, 1);
        return res;
    }

    private void dfs(NestedInteger[] nestedIntegers, int i) {
        for (NestedInteger el: nestedIntegers) {
            if (el.isDigit()) {
                res+=i*el.getInteger();
            }
            else{
                dfs(el.getList(), i+1);
            }
        }
    }
}
