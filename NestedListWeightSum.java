//Time Complexity O(N)
//Space Complexity O(1) 
//Leetcode tested

import java.util.LinkedList;
import java.util.List;

public class NestedListWeightSum {
    int result;
    public int depthSum(List<NestedInteger> nestedList){
        dfs(nestedList,1);
        return result;
    }
    public void dfs(List<NestedInteger> nestedList,int depth){
        for (NestedInteger el: nestedList) {
            if(el.isInteger()){
                result+= depth*(el.getInteger());
            }else{
                dfs(el.getList(),depth+1);
            }
        }
    }
}
