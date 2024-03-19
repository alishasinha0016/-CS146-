class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class LCA:
    def lowestCommonAncestor(self, root, p, q):
        if p == q or not self.isValidNode(root, p) or not self.isValidNode(root, q) or \
           not (2 <= self.countNumberOfNodes(root) <= 100000) or \
           not self.nodeValueCheck(root) or not self.areAllValuesUnique(root):
            raise ValueError("The conditions are not met")

        if root is None or root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root
        return left if left else right

    def countNumberOfNodes(self, root):
        if root is None:
            return 0

        left_count = self.countNumberOfNodes(root.left)
        right_count = self.countNumberOfNodes(root.right)

        return 1 + left_count + right_count

    def nodeValueCheck(self, node):
        if node is None:
            return True

        if not -10**9 <= node.val <= 10**9:
            return False

        return self.nodeValueCheck(node.left) and self.nodeValueCheck(node.right)

    def areAllValuesUnique(self, root):
        seen_values = set()
        return self.checkUniqueness(root, seen_values)

    def checkUniqueness(self, node, seen_values):
        if node is None:
            return True

        if node.val in seen_values:
            return False

        seen_values.add(node.val)

        return self.checkUniqueness(node.left, seen_values) and self.checkUniqueness(node.right, seen_values)

    def isValidNode(self, root, node):
        if root is None:
            return False

        if root == node:
            return True

        if node.val < root.val:
            return self.isValidNode(root.left, node)
        else:
            return self.isValidNode(root.right, node)


if __name__ == "__main__":
    lca = LCA()

    root = TreeNode(4)
    root.left = TreeNode(3)
    root.right = TreeNode(8)
    root.left.left = TreeNode(1)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(9)

    p = root.left
    q = root.left.left

    ancestor = lca.lowestCommonAncestor(root, p, q)
    print(f"Lowest Common Ancestor is: {ancestor.val}")  # Output: 3

