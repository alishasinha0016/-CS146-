import java.util.*;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
       
        TreeNode invertedRoot = invertTree(root);
        printTreeLevelByLevel(invertedRoot);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Here we are using recursion to make the swap happen till we reach the lowest subtree
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // Here we are swapping the left and right subtree
        root.left = right;
        root.right = left;

        return root;
    }

    public static void printTreeLevelByLevel(TreeNode root) {
        if (root == null) {
            return;
        }
    
        List<TreeNode> currentTreeLevel = new ArrayList<>();
        currentTreeLevel.add(root);
    
        while (!currentTreeLevel.isEmpty()) {
            List<TreeNode> nextTreeLevel = new ArrayList<>();
            for (int i = 0; i < currentTreeLevel.size(); i++) {
                TreeNode node = currentTreeLevel.get(i);
                System.out.print(node.val + " ");
                
                if (node.left != null) {
                    nextTreeLevel.add(node.left);
                }
                if (node.right != null) {
                    nextTreeLevel.add(node.right);
                }
            }
    
            System.out.println(); 
            currentTreeLevel = nextTreeLevel;
        }
    }
    
}
