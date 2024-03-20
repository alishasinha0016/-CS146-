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

 class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        LevelOrderTraversal ob = new LevelOrderTraversal();

        ob.printLevelTraversal(ob.TreeLevelByLevel(root));
    }

    public void printLevelTraversal(List<List<TreeNode>> totalTreeLevel) {
        if (totalTreeLevel != null) {
            int counter_1 = 0;
            int counter_2 = 0;
            System.out.print("[");
            for (List<TreeNode> levelCountNodes : totalTreeLevel) {
                System.out.print("[");
                for (TreeNode node : levelCountNodes) {
                    if (counter_2 < levelCountNodes.size() - 1)
                        System.out.print(node.val + ", ");
                    else if (counter_1 < totalTreeLevel.size() - 1)
                        System.out.print(node.val + "],");
                    else
                        System.out.print(node.val + "]");
                    counter_2++;

                }
                counter_1++;
                counter_2 = 0;
            }
            System.out.println("]");

        } else
            System.out.println("The tree is empty");

    }

    public List<List<TreeNode>> TreeLevelByLevel(TreeNode root) {
        if (checkCount(root, 0) < 0 || checkCount(root, 0) > 2000 || !checkNodeVal(root))
            throw new IllegalArgumentException("The conditions are not met");

        if (root == null) {
            return null;
        }

        List<List<TreeNode>> totalTreeLevel = new ArrayList<>();
        List<TreeNode> currentTreeLevel = new ArrayList<>();
        currentTreeLevel.add(root);

        while (!currentTreeLevel.isEmpty()) {
            List<TreeNode> nextTreeLevel = new ArrayList<>();
            List<TreeNode> currentLevelValues = new ArrayList<>();
            for (TreeNode node : currentTreeLevel) {
                currentLevelValues.add(node);
                if (node.left != null) {
                    nextTreeLevel.add(node.left);
                }
                if (node.right != null) {
                    nextTreeLevel.add(node.right);
                }
            }
            totalTreeLevel.add(currentLevelValues);
            currentTreeLevel = nextTreeLevel;
        }
        return totalTreeLevel;
    }

    public int checkCount(TreeNode node, int countNode) {
        if (node == null)
            return countNode;

        countNode++;
        countNode = checkCount(node.left, countNode);
        countNode = checkCount(node.right, countNode);
        return countNode;
    }

    public boolean checkNodeVal(TreeNode node) {
        if (node == null)
            return true;

        if (node.val < -1000 || node.val > 1000)
            return false;

        return checkNodeVal(node.left) && checkNodeVal(node.right);

    }

}

