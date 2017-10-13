package leetcode;
import java.util.*;
/**
 * Created by alexisherrera on 10/13/17.
 */
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> g = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> gVisited = new HashSet<>();
        Stack<Integer> orderOfVisit = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            g.put(i, new ArrayList<>());
        }

        //add edges to the graph
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];

            List<Integer> edgeList = g.get(from);
            edgeList.add(to);
            g.put(from, edgeList);
        }

        //search graph
        for (int i = 0; i < numCourses; i++) {
            if (!gVisited.contains(i) && !DFS(g, visited, gVisited, i, orderOfVisit)) { return new int[0]; }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = orderOfVisit.pop();
        }

        return result;
    }


    public boolean DFS(Map<Integer, List<Integer>> g, Set<Integer> visited, Set<Integer> gVisited, int node,
                       Stack<Integer> orderOfVisit) {

        if (visited.contains(node)) { return false; }
        visited.add(node);

        for (Integer edge : g.get(node)) {
            if (!gVisited.contains(edge) && !DFS(g, visited, gVisited, edge, orderOfVisit)) { return false; }
        }

        visited.remove(node);
        orderOfVisit.push(node);
        gVisited.add(node);
        return true;
    }
}
