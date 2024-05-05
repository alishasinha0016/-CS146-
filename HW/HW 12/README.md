In this program, we use priority queue to keep track and store the edges sorted by their weights prioriry. To solve this problem the Prims Algorithm is used which is used to find the MST or the Minimum Spanning Tree.

In this program we have two classes, Edge Class and MST Class. The Edge class is used to represent an edge in a graph. It has three attributes: from (source vertex/house), to (destination vertex/house), and cost (edge weight/cost).

In the MST class, there two methods, validityCheck() and minCostToSupplyWater(). The validityCheck() checks the constraints. In case any one of the constranints are not met, it returns false else true. In the minCostToSupplyWater() function a Priority queue, that stores the edges sorted by their weights, and a boolean type array that keeps track of visited houses are delcated and initialized. We then, using a loop, add edges for the existing pipe connection also comparing the well cost. If there is a self loop, it is not added.
For each housei, we iterate through all pipes connecting housei to other housej. Then we create edge from house i to j with cost equal to minimum between the pipe cost and the cost of building a well in housej. Also, if there are houses with no connections initially, then we create an edge connecting them to all other houses with the Integer_MAX_VALUE. 

In the while loop, we dequeue the cheapest edge from the priority queue. In case, the edge connects two unvisited houses, we add the edge cost to the totalCost variable. The houses are then connected by edge and marked as visited. 
