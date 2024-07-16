package Misc-1;

// TC: O(n)
// SC: O(n)
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        return dfs(nestedList,1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth){
        int result=0;
        for(NestedInteger elem: nestedList){
            if(elem.isInteger()){
                result += elem.getInteger()*depth;
            }else{
                result += dfs(elem.getList(), depth+1);
            }
        }

        return result;
    }
}