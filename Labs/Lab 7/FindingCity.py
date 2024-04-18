class FindingCity:

    def validity(self, n, edges, distanceThreshold):
        if 2 <= n <= 100 and 1 <= distanceThreshold <= 10**4:
            pairSet = set()
            for edgeArray in edges:
                if len(edgeArray) == 3 and 0 <= edgeArray[0] < n and 0 <= edgeArray[1] < n and edgeArray[2] >= 1:
                    pair = str(edgeArray[0]) + "-" + str(edgeArray[1])
                    if pair in pairSet:
                        return False
                    pairSet.add(pair)
                else:
                    return False
            return True
        else:
            return False

    def findTheCity(self, n, edges, distanceThreshold):
        if self.validity(n, edges, distanceThreshold):
            minCityNum = n
            minReachableCity = -1
            cityDistances = [[0 if i == j else -1 for j in range(n)] for i in range(n)]

            for edge in edges:
                u, v, weight = edge
                cityDistances[u][v] = weight
                cityDistances[v][u] = weight

            for k in range(n):
                for i in range(n):
                    for j in range(n):
                        if cityDistances[i][k] != -1 and cityDistances[k][j] != -1:
                            newDistance = cityDistances[i][k] + cityDistances[k][j]
                            if cityDistances[i][j] == -1 or newDistance < cityDistances[i][j]:
                                cityDistances[i][j] = newDistance

            for i in range(n):
                reachableCities = 0  # Step 1
                for j in range(n):  # Step 2
                    if cityDistances[i][j] != -1 and cityDistances[i][j] <= distanceThreshold:  # Step 3
                        reachableCities += 1  # Step 4
                if reachableCities <= minCityNum:
                    minCityNum = reachableCities
                    minReachableCity = i

            return str(minReachableCity)
        else:
            return None

    def main(self):
        ob = FindingCity()
        # Test cases
        edges1 = [[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]]
        result = ob.findTheCity(4, edges1, 4)
        if result is None:
            print("Illegal Argument: The constraints were not met.")
        elif result == "-1":
            print("No city found that meets the given criteria.")
        else:
            print(result)

        edges2 = [[0, 1, 2], [0, 4, 8], [1, 2, 3], [1, 4, 2], [2, 3, 1], [3, 4, 1]]
        result = ob.findTheCity(5, edges2, 2)
        if result is None:
            print("Illegal Argument: The constraints were not met.")
        elif result == "-1":
            print("No city found that meets the given criteria.")
        else:
            print(result)


if __name__ == "__main__":
    FindingCity().main()

