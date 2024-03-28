public class CoursePrerequisites {

    public boolean checkValidity(int numCourses, int[][] prerequisites)
    {
        // checking for the constraints 
        if(numCourses < 1 || numCourses > 2000 || prerequisites.length <  0 || prerequisites.length > 5000)
            return false;
            int prerequisite [] = new int [2];

            for(int i = 0; i<prerequisites.length; i++){
                prerequisite = prerequisites[i];
                if (prerequisites[i].length != 2 || prerequisite[0] < 0 || prerequisite[1] >= numCourses)
                    return false;
            }
            return true;
        }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency matrix to represent the graph
        boolean[][] courseGraph = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            courseGraph[prerequisite[0]][prerequisite[1]] = true;
        }

        // Check for cycles using DFS
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && checkRepeatCourse(courseGraph, i, visited)) {
                return false;
            }
        }

        return true;
    } 

    public boolean checkRepeatCourse(boolean[][] graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i]) {
                if (visited[i] || checkRepeatCourse(graph, i, visited)) {
                    return true;
                }
            }
        }
        visited[v] = false;
        return false;
    }

    public static void main(String[] args) {
        CoursePrerequisites cs = new CoursePrerequisites();
        System.out.println(cs.canFinish(2, new int[][]{{1, 0}}));  // Output: true
        System.out.println(cs.canFinish(2, new int[][]{{1, 0}, {0, 1}}));  // Output: false
    }
}

