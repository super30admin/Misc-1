// with recursion (dfs)
// Time complexity = O(n)
// Space complexity = O(h)
class Solution {
    int res;
    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return res;
    } 
       
        private void dfs(List<NestedInteger> nestedList, int depth) {
            for(NestedInteger ni: nestedList) {
                if(ni.isInteger()) {                
                    res+= depth* ni.getInteger();                
                } else {
                    List<NestedInteger> li = ni.getList();
                    dfs(li, depth+1);
                }                
            }
        }

}

// with the queue solution
// Time complexity = O(n)
// Space complexity = O(n)

// why not stack because it is Last In First Out.
//so it will mess up the depth.
//better to use 2 stacks when you want the syncing.
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        int result=0;
        int depth=1;
        for(NestedInteger ni: nestedList) {
            q.add(ni);
        }
        
        
        while(!q.isEmpty()) {
            int size = q.size();
            System.out.println("q is " + q.size());
            for(int i=0;i< size;i++) {
                NestedInteger currEl = q.remove();
                if(currEl.isInteger()) {                
                    System.out.println("depth is " + depth);
                    System.out.println("currEl is " + currEl.getInteger());
                    result+= depth* currEl.getInteger();                
                } else {
                    List<NestedInteger> li = currEl.getList();
                    for(NestedInteger el: li) {
                        q.add(el);
                    }
                }                
            }
            depth++;

        }
        return result;
    }
}


// Stack solution
// Time complexity = O(n)
// Space complexity = O(n)
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Stack<NestedInteger> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        int count =0;
        int result=0;
        for(NestedInteger ni: nestedList) {
            stack.push(ni);
            depthStack.push(1);
        }
        System.out.println("stack is " + stack.size());
        while(!stack.isEmpty()) {
            NestedInteger currEl = stack.pop();
            int currDepth = depthStack.pop();
            if(currEl.isInteger()) {                
                result+= currDepth* currEl.getInteger();
                
            } else {
                List<NestedInteger> li = currEl.getList();
                for(NestedInteger el: li) {
                    stack.push(el);
                    depthStack.push(currDepth +1);
                }
            }
        }
        return result;
    }
}