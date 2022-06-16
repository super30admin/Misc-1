//Iterative BFS Solution
//O(N) time and O(N) space
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null)  return 0; 
        
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        
        for(NestedInteger i : nestedList){
            queue.add(i);
            depth.add(1);
            
        }
        while(!queue.isEmpty()){
            NestedInteger n = queue.poll();
            int dt = depth.poll();
            
            if(n.isInteger()){ // If there is an integer
                sum += n.getInteger() * dt ;
            } else{
                for(NestedInteger l : n.getList()){ // When there is a list, iterate over it and add it into the queue and add depth also
                    queue.add(l);
                    depth.add(dt + 1);
                }
            }
        }
        
        return sum;
    }
}



/*

//Iterative DFS Solution
//O(N) time with O(N) space
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null)  return 0; 
        
        int sum = 0;
        Stack<NestedInteger> nStack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        
        for(NestedInteger i : nestedList){
            nStack.push(i);
            depth.push(1);
            
        }
        while(!nStack.isEmpty()){
            NestedInteger n = nStack.pop();
            int dt = depth.pop();
            
            if(n.isInteger()){
                sum += n.getInteger() * dt ;
            } else{
                for(NestedInteger l : n.getList()){
                    nStack.push(l);
                    depth.push(dt + 1);
                }
            }
        }
        
        return sum;
    }
}


*/





/*

//O(N) time and O(1) space  
class Solution {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null)  return 0; 
        
        helper(nestedList, 1);
        return sum;
    }
    public void helper(List<NestedInteger> nestedList, int depth){
        
        
        for(NestedInteger n : nestedList ){
            if(n.isInteger()){
                sum += n.getInteger() * depth;
            } else{
                helper(n.getList(), depth + 1);
            }
        }
    }
}

*/