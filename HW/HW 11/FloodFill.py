class FloodFill:
    def isValidChecker(self, imageMatrix, row, col, color):
        return (imageMatrix and len(imageMatrix) > 0 and len(imageMatrix[0]) > 0 and imageMatrix[row][col] != color)

    def checkConstraints(self, image, sr, sc, color):
        m, n = len(image), len(image[0])
        counter = sum(1 for row in image for pixel in row if pixel < 0)
        return (1 <= m <= 50 and 0 <= sr < m and 0 <= sc < n and counter == 0)

    def floodFill(self, image, sr, sc, newColor):
        if not self.isValidChecker(image, sr, sc, newColor):
            return image
        if not  self.checkConstraints(image, sr, sc, newColor):
            raise ValueError("Input does not meet the constraints")

        m, n = len(image), len(image[0])
        originalColor = image[sr][sc]
        floodFillQueue = [(sr, sc)]

        while floodFillQueue:
            rowNum, colNum = floodFillQueue.pop(0)
            image[rowNum][colNum] = newColor

            if rowNum - 1 >= 0 and image[rowNum - 1][colNum] == originalColor:
                floodFillQueue.append((rowNum - 1, colNum))
            if rowNum + 1 < m and image[rowNum + 1][colNum] == originalColor:
                floodFillQueue.append((rowNum + 1, colNum))
            if colNum - 1 >= 0 and image[rowNum][colNum - 1] == originalColor:
                floodFillQueue.append((rowNum, colNum - 1))
            if colNum + 1 < n and image[rowNum][colNum + 1] == originalColor:
                floodFillQueue.append((rowNum, colNum + 1))

        return image

    def display(self, image):
        try:
            for row in image:
                print(" ".join(str(pixel) for pixel in row))
        except TypeError:
            print("The matrix is null")

if __name__ == "__main__":
    obColorFill = FloodFill()

    # Test the function with the provided test cases
    image1 = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
    sr1, sc1, color1 = 1, 1, 2
    print("Input 1:")
    obColorFill.display(image1)
    result1 = obColorFill.floodFill(image1, sr1, sc1, color1)
    print("Output 1:")
    obColorFill.display(result1)

    image2 = [[0, 0, 0], [0, 0, 0]]
    sr2, sc2, color2 = 0, 0, 0
    print("Input 2:")
    obColorFill.display(image2)
    result2 = obColorFill.floodFill(image2, sr2, sc2, color2)
    print("Output 2:")
    obColorFill.display(result2)

