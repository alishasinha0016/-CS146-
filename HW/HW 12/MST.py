import heapq

class MST:
    def validity_check(self, n, wells, pipes):
        if 2 <= n <= 10**4 and len(wells) == n and 1 <= len(pipes) <= 10**4:
            for well in wells:
                if not 0 <= well <= 10**5:
                    return False
            for pipe in pipes:
                if len(pipe) == 3 and 1 <= pipe[0] <= n and 1 <= pipe[1] <= n and 0 <= pipe[2] <= 10**5 and pipe[0] != pipe[1]:
                    continue
                else:
                    return False
            return True
        else:
            return False

    def min_cost_to_supply_water(self, n, wells, pipes):
        if not self.validity_check(n, wells, pipes):
            return -1

        edges = []

        # Add edges for pipes (considering well cost)
        for pipe in pipes:
            edges.append((pipe[0], pipe[1], pipe[2]))

        # Add edges for wells
        for i in range(n):
            edges.append((0, i + 1, wells[i]))

        # Sort the edges based on cost

        edges.sort(key=self.get_cost)

        total_cost = 0
        connected_houses = 0
        visited = set()

        # Traverse through the sorted edges and calculate the minimum cost
        for edge in edges:
            from_house, to_house, cost = edge
            if from_house not in visited or to_house not in visited:
                visited.add(from_house)
                visited.add(to_house)
                total_cost += cost
                connected_houses += 1
            if connected_houses == n:
                break

        return total_cost

    def get_cost(self, edge):
        return edge[2]

if __name__ == "__main__":
    n = 2
    wells = [1, 1]
    pipes = [[1, 2, 1], [1, 2, 2]]

    # Create an instance/object of the MST class
    obMST = MST()

    # Calculate the minimum cost to supply water by calling min_cost_to_supply_water()
    min_cost = obMST.min_cost_to_supply_water(n, wells, pipes)
    if (min_cost != -1):
        print(f"Minimum cost to supply water to all houses: {min_cost}")
    else:
        print("Invalid input")

