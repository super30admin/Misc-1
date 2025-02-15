/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
// Approach : unpack the nested nested lists first and then unpack the integers
// out of the lists with BFS traversal (level by level).
// Utilizing queue add initially all the nested integers out of nested list. Now
// go over the queue and pop one element by element and check if
// it is a ineteger then add to result and check if it is a list then go through
// the list and add to the queue to process.
// Time : O(n) // n - no of unpacked elements
// space : O(max(depth))
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger ne : nestedList) {
            q.add(ne);
        }

        int depth = 1;
        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = q.poll();
                if (curr.isInteger()) {
                    result += curr.getInteger() * depth;
                } else {
                    // not an integer then it is a nested integer so unpack it and add to the queue.
                    for (NestedInteger ne : curr.getList()) {
                        q.add(ne);
                    }
                }
            }
            depth++;
        }

        return result;

    }
}


/ Approach : Using DFS
// Time : O(n) // n - no of unpacked elements
// space : O(max(depth))
class Solution {
    int result;
    public int depthSum(List<NestedInteger> nestedList) {
        this.result =0;
        dfs(nestedList ,1);
        return result;
    }

    private void dfs(List<NestedInteger> nestedList , int depth){
        for(NestedInteger ne : nestedList){
            if(ne.isInteger()){
                result+=ne.getInteger() * depth;
            } else{
                dfs(ne.getList(),depth+1);
            }
        }
    }
}

// Approach : Using DFS - Int based recursion
// Time : O(n) // n - no of unpacked elements
// space : O(max(depth))
class Solution {
    //int result;
    public int depthSum(List<NestedInteger> nestedList) {
        //this.result =0;
        return dfs(nestedList ,1);
        //return result;
    }

    private int dfs(List<NestedInteger> nestedList , int depth){
        int result=0;
        for(NestedInteger ne : nestedList){
            if(ne.isInteger()){
                result+=ne.getInteger() * depth;
            } else{
                result+=dfs(ne.getList(),depth+1);
            }
        }
        return result;
    }
}