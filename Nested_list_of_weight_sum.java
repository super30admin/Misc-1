class Solution{
  int sum;
  public int depthSum(List<NestedInteger> nestedList){
    if(nestedList == null) return sum;
    dfs(nestedList, 1);
    return sum;
    }
    
  private void dfs(List<NestedInteger> nestedList, int depth){
    for(NestedInteger el: nestedList){
        if(el.isInteger()){
          sum += depth * (el.getInteger();
          }else{
            dfs(el.getList(), depth + 1);
            }
           }
          }
       }
       
       
//TC: O(n)
//SC: O(1)
