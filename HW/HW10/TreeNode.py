class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class LevelOrderTraversal:
    def __init__(self):
        pass

    def printLevelTraversal(self, totalTreeLevel):
        if totalTreeLevel:
            counter_1 = 0
            counter_2 = 0
            print("[", end="")
            for levelCountNodes in totalTreeLevel:
                print("[", end="")
                for node in levelCountNodes:
                    if counter_2 < len(levelCountNodes) - 1:
                        print(node.val, end=", ")
                    elif counter_1 < len(totalTreeLevel) - 1:
                        print(node.val, end="],")
                    else:
                        print(node.val, end="]")
                    counter_2 += 1

                counter_1 += 1
                counter_2 = 0
            print("]")

        else:
            print("The tree is empty")

    def treeLevelByLevel(self, root):
        if self.checkCount(root, 0) < 0 or self.checkCount(root, 0) > 2000 or not self.checkNodeVal(root):
            raise ValueError("The conditions are not met")

        if not root:
            return None

        totalTreeLevel = []
        currentTreeLevel = [root]

        while currentTreeLevel:
            nextTreeLevel = []
            currentLevelValues = []
            for node in currentTreeLevel:
                currentLevelValues.append(node)
                if node.left:
                    nextTreeLevel.append(node.left)
                if node.right:
                    nextTreeLevel.append(node.right)
            totalTreeLevel.append(currentLevelValues)
            currentTreeLevel = nextTreeLevel

        return totalTreeLevel

    def checkCount(self, node, countNode):
        if not node:
            return countNode

        countNode += 1
        countNode = self.checkCount(node.left, countNode)
        countNode = self.checkCount(node.right, countNode)
        return countNode

    def checkNodeVal(self, node):
        if not node:
            return True

        if node.val < -1000 or node.val > 1000:
            return False

        return self.checkNodeVal(node.left) and self.checkNodeVal(node.right)

    def main(self):
        # Creating the sample binary tree
        root = TreeNode(4)
        root.left = TreeNode(3)
        root.right = TreeNode(8)
        root.left.left = TreeNode(1)
        root.right.left = TreeNode(5)
        root.right.right = TreeNode(9)

        # Performing level-order traversal
        totalTreeLevel = self.treeLevelByLevel(root)

        # Printing the result
        self.printLevelTraversal(totalTreeLevel)

if __name__ == "__main__":
    # Create an instance of LevelOrderTraversal and call the main function
    ob = LevelOrderTraversal()
    ob.main()

