// DFS
// Time: O(n)
// Space: O(n)

class Solution {
    int res;
    public int depthSum(List<NestedInteger> nestedList) {
        res = 0;
        helper(nestedList,1);
        return res;
    }
    
    private void helper(List<NestedInteger> nestedList, int depth){
        // base
        
        // logic
        for (int i = 0; i < nestedList.size(); i++){
            NestedInteger el = nestedList.get(i);
            if (el.isInteger()){
                res+=el.getInteger()*depth;
            }else{
                helper(el.getList(), depth+1);
            }
        }
    }
    
}


// BFS
// Time: O(n)
// Space: O(n)

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue <NestedInteger> q = new LinkedList<>();
        for (NestedInteger el: nestedList){
            q.add(el);
        }
        
        int result = 0;
        int count = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                NestedInteger curr = q.poll();
                if (curr.isInteger()){
                    result += count * curr.getInteger();
                }else{
                    for(NestedInteger ele: curr.getList()){
                        q.add(ele);
                    }
                }
            }
            count++;
            
        }
        return result;
        
    }
}
