//Time Complexity: O(n); where n is total number of nodes in tree.
//Space Complexity: O(H); where H is height of the tree.

public class DistributeCoinsInBT {		
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	/**Approach: DFS + get extra coins from bottom-up**/
	int moves;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    private int dfs(TreeNode root){
        //base
        if(root == null) return 0;
         
        //logic  
        int extra = root.val-1;
        extra += dfs(root.left);
        extra += dfs(root.right);
        moves += Math.abs(extra);
        return extra;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		DistributeCoinsInBT ob= new DistributeCoinsInBT();
		//TreeNode t1= new TreeNode(0, new TreeNode(1, new TreeNode(0), new TreeNode(0)), new TreeNode(4));
		TreeNode t1= new TreeNode(0, new TreeNode(3), new TreeNode(0));
		
		System.out.println("Min no. of moves required to make every node have exactly one coin: "+ob.distributeCoins(t1));					
	}	
}
