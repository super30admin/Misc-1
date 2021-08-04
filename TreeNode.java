public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode getNode(int data) {
        return new TreeNode(data);
    }

    // [5,3,9,0,4]
    public TreeNode getSampleBST() {
        TreeNode root = getNode(1);
        TreeNode node1left = getNode(0);
        TreeNode node1right = getNode(1); 
        TreeNode node2left = getNode(3);
        TreeNode node2right = getNode(0);
        TreeNode node3left = getNode(1);

        root.left = node1left;
        root.right = node1right;
        node1left.left = node2left;
        node2left.right = node2right;
        node1right.left = node3left;
        return root;
    }

}
