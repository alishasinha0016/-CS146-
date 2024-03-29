class CoursePrerequisites:
    def checkValidity(self, numCourses, prerequisites):
        if numCourses < 1 or numCourses > 2000 or len(prerequisites) < 0 or len(prerequisites) > 5000:
            return False

        for prerequisite in prerequisites:
            if len(prerequisite) != 2 or prerequisite[0] < 0 or prerequisite[1] >= numCourses:
                return False

        return True

    def canFinish(self, numCourses, prerequisites):
        if self.checkValidity(numCourses, prerequisites):
            # Create an adjacency matrix to represent the graph
            courseGraph = [[False for _ in range(numCourses)] for _ in range(numCourses)]
            for prerequisite in prerequisites:
                courseGraph[prerequisite[0]][prerequisite[1]] = True

            # Check for cycles using DFS
            visited = [False] * numCourses
            for i in range(numCourses):
                if not visited[i] and self.checkRepeatCourse(courseGraph, i, visited):
                    return False

            return True
        else:
            print("The input is not valid. Hence printing:")
            return False

    def checkRepeatCourse(self, graph, v, visited):
        visited[v] = True
        for i in range(len(graph)):
            if graph[v][i]:
                if visited[i] or self.checkRepeatCourse(graph, i, visited):
                    return True
        visited[v] = False
        return False

def main():
    # Testing
    ob = CoursePrerequisites()
    print(ob.canFinish(2, [[1, 0]]))
    print(ob.canFinish(2, [[1, 0], [0, 1]]))

if __name__ == "__main__":
    main()
