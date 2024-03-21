import java.util.*;
public class ConversionGraph{
   public int[][] convert(List<List<Integer>> adjList, int n) {
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                int node = adjList.get(i).get(j);
                adjMatrix[i][node] = 1;
            }
        }

        return adjMatrix;
    }
  public ArrayList<ArrayList<Integer>> convertMatrixToList(int[][] adjMatrix) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < adjMatrix.length; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
    return  adjList;
  }
   
    public int[][] reverseEdges(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int[][] reversedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reversedMatrix[j][i] = adjMatrix[i][j];
            }
        }
      return reversedMatrix;
    }

     public static void main(String[] args) {
       ConversionGraph ob = new ConversionGraph();
        // Example usage
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(1, 2));
        adjList.add(Arrays.asList(0, 2));
        adjList.add(Arrays.asList(0, 1));

        int[][] adjMatrix = convert(adjList, 3);
       int[][] adjMatrix2 = adjMatrix;

        List<List<Integer>> adjListConverted = convertMatrixToList(adjMatrix);
        System.out.println(adjListConverted);

        List<List<Integer>> reversedAdjList = reverseEdges(adjMatrix2);
        System.out.println(reversedAdjList);
    }
}
