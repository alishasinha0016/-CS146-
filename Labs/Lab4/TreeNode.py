class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def invertTree(root):
    if root is None:
        return None

    # Here we are using recursion to make the swap happen till we reach the lowest subtree
    left = invertTree(root.left)
    right = invertTree(root.right)
    # Here we are swapping the left and right subtree
    root.left = right
    root.right = left

    return root

def printTreeLevelByLevel(root):
    if root is None:
        return

    currentTreeLevel = [root]

    while currentTreeLevel:
        nextTreeLevel = []
        for node in currentTreeLevel:
            print(node.val, end=" ")

            if node.left:
                nextTreeLevel.append(node.left)
            if node.right:
                nextTreeLevel.append(node.right)

        print()
        currentTreeLevel = nextTreeLevel

def main():
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(8)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)

    invertedRoot = invertTree(root)
    printTreeLevelByLevel(invertedRoot)

if __name__ == "__main__":
    main()

