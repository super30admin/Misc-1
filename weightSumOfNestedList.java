// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We can solve this question using a DFS or BFS.
// We can use 2 ways to implement using DFS. 1) Iterative DFS using 2 stacks 2) Recursive DFS

// Approach: BFS
// Time Complexity = O(d+n), where d = total depth and n is the no. of elements
// Space Complexity = O(d+n), for the queue

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        Queue<List<NestedInteger>> q = new LinkedList<>();
        q.add(nestedList);
        int result=0;
        int level=1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                List<NestedInteger> curr = q.poll();
                for (int j=0; j < curr.size(); j++) {
                    if (curr.get(j).isInteger()) {
                        result += (curr.get(j).getInteger() * level);
                    }
                    else {
                        q.add(curr.get(j).getList());
                    }
                }
            }
            level++;
        }

        return result;
    }
}
//---------------------------------------------------------------------------------------------------------------------
// Approach: Iterative DFS
// Time Complexity = O(d+n), where d = total depth and n is the no. of elements
// Space Complexity = O(d+n), for stack

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        Stack<List<NestedInteger>> st = new Stack<>();
        Stack<Integer> level = new Stack<>();
        st.push(nestedList);
        level.push(1);

        int result=0;

        while (!st.isEmpty()) {
            List<NestedInteger> curr = st.pop();
            int lvl = level.pop();
            for (int i=0; i<curr.size(); i++) {
                if(curr.get(i).isInteger()) {
                    result += (curr.get(i).getInteger() * lvl);
                    System.out.println(result);
                }
                else {
                    st.push(curr.get(i).getList());
                    level.push(lvl+1);          // Dont pass lvl++, since it will add lvl to the stack and increment lvl later
                }
            }
        }

        return result;
    }
}

//---------------------------------------------------------------------------------------------------------------------
// Approach: Recursive DFS
// Time Complexity = O(d+n), where d = total depth and n is the no. of elements
// Space Complexity = O(d+n), for internal stack

class Solution {
    int result;
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;

        dfs(nestedList, 1);
        return result;
    }

    private void dfs(List<NestedInteger> curr, int level) {
        for (int i=0; i<curr.size(); i++) {
            if(curr.get(i).isInteger()) {
                result += (curr.get(i).getInteger() * level);
            }
            else {
                dfs(curr.get(i).getList(), level+1);
            }
        }
    }
}