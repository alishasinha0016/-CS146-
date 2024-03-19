import java.util.*;

class TreeNode {
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

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.equals(q)|| (!isValidNode(root, p)) || (!isValidNode(root, q))||
        (countNumberOfNodes(root) >= 2 && countNumberOfNodes(root) <= 100000) ||
        (!NodeValueChcek(root)) || (!areAllValuesUnique(root)) ){
    throw new IllegalArgumentException("The conditions are not met");
}

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if(left != null){
            return left;
        }
        else{
            return right;
        }
    }
    public int countNumberOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
    
        int leftCount = countNumberOfNodes(root.left);
        int rightCount = countNumberOfNodes(root.right);
    
        return 1 + leftCount + rightCount;
    }
    public boolean NodeValueChcek(TreeNode node){
            if (node == null) {
                return true;
            }
        
            if (node.val < -1000000000 || node.val > 1000000000) {
                return false;
            }
        
            return NodeValueChcek(node.left) && NodeValueChcek(node.right);
        }
        
    public boolean areAllValuesUnique(TreeNode root) {
    Set<Integer> seenValues = new HashSet<>();
    return checkUniqueness(root, seenValues);
}

private boolean checkUniqueness(TreeNode node, Set<Integer> seenValues) {
    if (node == null) {
        return true;
    }

    if (!seenValues.add(node.val)) {
        return false;
    }

    return checkUniqueness(node.left, seenValues) && checkUniqueness(node.right, seenValues);
}

public boolean isValidNode(TreeNode root, TreeNode node) {
    if (root == null) {
        return false;
    }

    if (root == node) {
        return true;
    }

    if (node.val < root.val) {
        return isValidNode(root.left, node);
    } else {
        return isValidNode(root.right, node);
    }
    
}
    

    public static void main(String[] args) {
        LCA lca = new LCA();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left; 
        TreeNode q = root.left.left; 

        TreeNode ancestor = lca.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor is: " + ancestor.val); // Output: 2
    }
}
