import java.util.*;

class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class MST {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<Edge> minPQ = new PriorityQueue<>(new Comparator<Edge>() {
            @Override //compare()
            public int compare(Edge e1, Edge e2) {
                return e1.cost - e2.cost;
            }
        });
        boolean[] visited = new boolean[n + 1]; // 1-based indexing for houses

        // Add edges for pipes (considering well cost)
        for (int[] pipe : pipes) {
            minPQ.add(new Edge(pipe[0], pipe[1], pipe[2]));
        }

        // Add edges for wells
        for (int i = 0; i < n; i++) {
            minPQ.add(new Edge(0, i + 1, wells[i]));
        }

        int totalCost = 0;
        int connectedHouses = 0;

        while (connectedHouses < n && !minPQ.isEmpty()) {
            Edge currentEdge = null;
            for (Edge edge : minPQ) {
                if (!visited[edge.to]) {
                    currentEdge = edge;
                    break;
                }
            }
            if (currentEdge == null) {
                break; // No more unvisited houses
            }

            visited[currentEdge.to] = true;
            totalCost += currentEdge.cost;
            connectedHouses++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] wells = {1, 1};
        int[][] pipes = {{1, 2, 1}, {1, 2, 2}};

        MST obMST = new MST();
        int minCost = obMST.minCostToSupplyWater(n, wells, pipes);
        System.out.println("Minimum cost to supply water to all houses: " + minCost);
    }
}
