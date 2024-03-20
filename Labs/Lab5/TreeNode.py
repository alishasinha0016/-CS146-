class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class ValidateBST:
    def main(self):
        # Constructing 1st BST
        input_1_BST = TreeNode(4)
        input_1_BST.left = TreeNode(3)
        input_1_BST.left.left = TreeNode(1)
        input_1_BST.right = TreeNode(8)
        input_1_BST.right.left = TreeNode(5)
        input_1_BST.right.right = TreeNode(9)

        # Constructing 2nd BST
        input_2_BST = TreeNode(1)
        input_2_BST.left = TreeNode(2)
        input_2_BST.right = TreeNode(8)
        input_2_BST.left.left = TreeNode(3)
        input_2_BST.left.right = TreeNode(4)
        input_2_BST.right.left = TreeNode(5)
        input_2_BST.right.right = TreeNode(6)

        # Testing isValidBST function
        ob_BST = ValidateBST()
        print("Valid BST:", ob_BST.isValidBST(input_1_BST))
        print("Invalid BST:", ob_BST.isValidBST(input_2_BST))

    def isValidBST(self, root):
        inorder_list = []
        self.inorder_traversal(root, inorder_list)
        for i in range(1, len(inorder_list)):
            if inorder_list[i] <= inorder_list[i - 1]:
                return False
        return True

    def inorder_traversal(self, root, inorder_list):
        if root is None:
            return
        self.inorder_traversal(root.left, inorder_list)
        inorder_list.append(root.val)
        self.inorder_traversal(root.right, inorder_list)

# Running the main function
if __name__ == "__main__":
    ValidateBST().main()
