//Problem 1: Broken Calculator
// Time Complexity : O(log(target)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// dont take startValue to target, bring target to startValue.
class Solution {
    //O(log(target))
    public int brokenCalc(int startValue, int target) {
        int count=0;
        while(target>startValue){
            if(target%2==0)
                target/=2;
            else{
                target+=1;
            }
            count++;
        }
        return count+(startValue-target);
    }
}


//Problem 2: distribute coins
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// the number of moves at any node can be decided by number of excess coins that particular node has, that will be dependent on number of extra coins from left subtree and right subtree
class Solution {
    //O(n) //O(h)
    int moves;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root){
        //base
        if(root==null) return 0;
        //logic
        int extra=root.val-1;
         extra+= dfs(root.left);
         extra+=dfs(root.right);
        moves+=Math.abs(extra);
        return extra;
    }
}

//Problem 3: nested weight list
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// when u have list in a list in a list, go deeper and deeper with dfs calls, if integer, add to current list sum, when coming out, add to result.
class Solution {
    int res;
    public int depthSum(List<NestedInteger> nestedList) {
        // helper(nestedList, 1);
        // return res;

        Queue<NestedInteger> q= new LinkedList<>();
        q.addAll(nestedList);
        int depth=1;
        int res=0;

        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                NestedInteger ne=q.poll();
                if(ne.isInteger())
                    res+=depth*ne.getInteger();
                else{
                    q.addAll(ne.getList());
                }
            }
            depth++;
        }

        return res;
    }

    private void helper(List<NestedInteger> nestedList, int depth){
        for(NestedInteger ne: nestedList){
            if(ne.isInteger()){
                res+=ne.getInteger()*depth;
            }else{
                helper(ne.getList(), depth+1);
            }
        }
    }
}
