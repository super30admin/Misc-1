class Sample{
    /********************PROBLEM-1************/
    //TC:0(Log N)
//SC:0(1)
    class Solution {
        public int brokenCalc(int startValue, int target) {
            if(target<startValue){
                return startValue-target;
            }
            int count=0;

            while(target>startValue){
                if(target%2==0){
                    target=target/2;
                }else{
                    target=target+1;
                }
                count++;
            }
            return count+(startValue-target);
        }
    }

    /*********************problem-2******************/
    //TC:0(N)
    //SC:0(h)
    class Solution {
        int moves;
        public int distributeCoins(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root);
            return moves;

        }

        private int dfs(TreeNode root){
            //base
            if(root==null){
                return 0;
            }

            //logic
            int extra=root.val-1;
            int left=dfs(root.left);
            int right=dfs(root.right);
            extra+=left+right;
            moves+=Math.abs(extra);
            return extra;
        }
    }

    /*********************problem-3******************/
}