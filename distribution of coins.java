//Time complexity :_ O(n).
//space complexity:- 0(1).

class Solution {
    int sum=0;
    public int distributeCoins(TreeNode root) {
        postorder(root);
        return sum;
        
    }
    private int postorder(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=postorder(root.left);
        int right=postorder(root.right);// main idea is that parent value signifies how many coins are to be given to children, therefore from bottom calculating how many coins are there for left leaf and right leaf.
        sum=sum+ Math.abs(left) +Math.abs(right); 
        //calculating number of moments for every call.
        return left+right+root.val-1;// the addition value from bottom -1 and why -1 is that one coin is kept for itself.
    }
}