// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList==null || nestedList.size()==0) return 0;
        dfs(nestedList,1);
        return sum;
    }
    
    private void dfs(List<NestedInteger> nestedList,int depth){
        for(NestedInteger num:nestedList){
            if(num.isInteger()){
                sum=sum+num.getInteger()*depth;
            }else{
                dfs(num.getList(),depth+1);
            }
        }
    }
}