class DepthSum {
     
    //time:O(n) where n= num of integers
    //space: O(d) where d = max depth of nested List for recursive stack
    
    //global sum of the integers
    int sum =0;
    public int depthSum(List<NestedInteger> nestedList) {
        //if list is empty
        if(nestedList==null || nestedList.size()==0){
            return 0;
        }
        
        //dfs on the list
        dfs(nestedList, 1);
        
        //return sum
        return sum;
    }
    
    private void dfs(List<NestedInteger> nestedList, int depth){
        
        //looping through the list
        for(NestedInteger el: nestedList){
            //if curr elemnt is integer
            if(el.isInteger()){
                //add to sum
                sum = depth * el.getInteger() + sum;
            }
            //if curr elemnt is list
            else{
                //get the list
                List<NestedInteger> nestedChild = el.getList();
                //perform dfs on the list
                dfs(nestedChild, depth+1);
            }
        }
    }
    
}