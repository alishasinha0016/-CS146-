import java.util.*;

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

}
class validateBST {

    public static void main(String[] args) {
        // Constructing 1st BST
        TreeNode input_1_BST = new TreeNode(4);
        input_1_BST.left = new TreeNode(3);
        input_1_BST.left.left = new TreeNode(1);
        input_1_BST.right = new TreeNode(8);
        input_1_BST.right.left = new TreeNode(5);
        input_1_BST.right.right = new TreeNode(9);

        // Constructing 2nd BST
        TreeNode input_2_BST = new TreeNode(1);
        input_2_BST.left = new TreeNode(2);
        input_2_BST.right = new TreeNode(8);
        input_2_BST.left.left = new TreeNode(3);
        input_2_BST.left.right = new TreeNode(4);
        input_2_BST.right.left = new TreeNode(5);
        input_2_BST.right.right = new TreeNode(6);

        // Testing isValidBST function
        validateBST ob_BST = new validateBST();
        System.out.println("Valid BST: " + ob_BST.isValidBST(input_1_BST)); 
        System.out.println("Invalid BST: " + ob_BST.isValidBST(input_2_BST)); 
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderListTraversal = new ArrayList<>();
        inorderTraversal(root, inorderListTraversal);
        for (int i = 1; i < inorderListTraversal.size(); i++) {
            if (inorderListTraversal.get(i) <= inorderListTraversal.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inorderTraversal(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, inorderList);
        inorderList.add(root.val);
        inorderTraversal(root.right, inorderList);
    }
}
