import java.util.*;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (!isValdChecker(image, sr, sc, color)) {
            return image;
        }
        if (!checkConstraints(image, sr, sc, color)) {
            throw new IllegalArgumentException("Input does not meet the constraints");
        }

        int m = image.length;
        int n = image[0].length;
        int rowNum, colNum;
        int originalColor = image[sr][sc];
        LinkedList<int[]> floodFillQueue = new LinkedList<>();
        floodFillQueue.add(new int[] { sr, sc });

        while (floodFillQueue.size() > 0) {
            int[] queueElement = floodFillQueue.removeFirst();
            rowNum = queueElement[0];
            colNum = queueElement[1];
            image[rowNum][colNum] = color;

            if (rowNum - 1 >= 0 && image[rowNum - 1][colNum] == originalColor) {
                floodFillQueue.add(new int[] { rowNum - 1, colNum });
            }
            if (rowNum + 1 < m && image[rowNum + 1][colNum] == originalColor) {
                floodFillQueue.add(new int[] { rowNum + 1, colNum });
            }
            if (colNum - 1 >= 0 && image[rowNum][colNum - 1] == originalColor) {
                floodFillQueue.add(new int[] { rowNum, colNum - 1 });
            }
            if (colNum + 1 < n && image[rowNum][colNum + 1] == originalColor) {
                floodFillQueue.add(new int[] { rowNum, colNum + 1 });
            }
        }

        return image;
    }

    public boolean isValdChecker(int[][] imageMatrix, int row, int col, int color) {
        return (imageMatrix != null && imageMatrix.length != 0 && imageMatrix[0].length != 0
                && imageMatrix[row][col] != color);
    }

    public boolean checkConstraints(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] < 0)
                    counter++;
            }
        }
        return ((1 <= m) && (n <= 50) && (color < Math.pow(2, 16)) &&
                (0 <= sr) && (sr < m) && (0 <= sc) && (sc < n) && (counter == 0));
    }

    public void display(int[][] image) {
        try {
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[0].length; j++) {
                    System.out.print(image[i][j] + " ");
                }
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.out.println("The matrix is null");
        }
    }

    public static void main(String[] args) {
        FloodFill obColorFill = new FloodFill();

        // Test the function with the provided test cases
        int[][] image1 = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr1 = 1, sc1 = 1, color1 = 2;
        System.out.println("Input 1:");
        obColorFill.display(image1);
        int[][] result1 = obColorFill.floodFill(image1, sr1, sc1, color1);
        System.out.println("Output 1:");
        obColorFill.display(result1);

        int[][] image2 = { { 0, 0, 0 }, { 0, 0, 0 } };
        int sr2 = 0, sc2 = 0, color2 = 0;
        System.out.println("Input 2:");
        obColorFill.display(image2);
        int[][] result2 = obColorFill.floodFill(image2, sr2, sc2, color2);
        System.out.println("Output 2:");
        obColorFill.display(result2);

    }
}

