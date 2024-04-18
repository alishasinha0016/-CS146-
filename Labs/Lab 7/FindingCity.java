import java.util.*;

public class FindingCity {

    public boolean validity(int n, int[][] edges, int distanceThreshold) {
        if (n >= 2 && n <= 100 && distanceThreshold >= 1 && distanceThreshold <= Math.pow(10, 4)) {
            Set<String> pairSet = new HashSet<>();
            for (int[] edgeArray : edges) {
                if (edgeArray.length == 3 && edgeArray[0] >= 0 && edgeArray[0] < n &&
                        edgeArray[1] >= 0 && edgeArray[1] < n && edgeArray[2] >= 1) {
                    String pair = edgeArray[0] + "-" + edgeArray[1];
                    if (pairSet.contains(pair)) {
                        return false;
                    }
                    pairSet.add(pair);
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public String findTheCity(int n, int[][] edges, int distanceThreshold) {
        if (validity(n, edges, distanceThreshold)) {
            int minCityNum = n;
            int minReachableCity = -1;
            int[][] cityDistances = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        cityDistances[i][j] = 0;
                    else
                        cityDistances[i][j] = -1;
                }
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                cityDistances[u][v] = weight;
                cityDistances[v][u] = weight;
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (cityDistances[i][k] != -1 && cityDistances[k][j] != -1) {
                            int newDistance = cityDistances[i][k] + cityDistances[k][j];
                            if (cityDistances[i][j] == -1 || newDistance < cityDistances[i][j]) {
                                cityDistances[i][j] = newDistance;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int reachableCities = 0;
                for (int j = 0; j < n; j++) {
                    if (cityDistances[i][j] != -1 && cityDistances[i][j] <= distanceThreshold) {
                        reachableCities++;
                    }
                }
                if (reachableCities <= minCityNum) {
                    minCityNum = reachableCities;
                    minReachableCity = i;
                }
            }

            return minReachableCity + "";
        } else
            return null;
    }

    public static void main(String[] args) {
        FindingCity ob = new FindingCity();
        String result = "";
        // Test cases
        int[][] edges1 = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        result = ob.findTheCity(4, edges1, 4);
        if (result == null)
            System.out.println("Illegal Argument: The constraints were not met.");
        else if (result.equals("-1"))
            System.out.println("No city found that meets the given criteria.");
        else
            System.out.println(result);

        int[][] edges2 = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
        result = ob.findTheCity(5, edges2, 2);
        if (result == null)
            System.out.println("Illegal Argument: The constraints were not met.");
        else if (result.equals("-1"))
            System.out.println("No city found that meets the given criteria.");
        else
            System.out.println(result);
    }
}

