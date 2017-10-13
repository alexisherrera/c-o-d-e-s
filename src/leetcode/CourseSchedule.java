package leetcode;
import java.util.*;
/**
 * Created by alexisherrera on 10/13/17.
 */
public class CourseSchedule {
    //essentially conduct DFS on the graph and check for cycles

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //first step is to create the graph
        Map<Integer, List<Integer>> g = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> globalV = new HashSet<>();

        //add skeletal code
        for (int i = 0; i < numCourses; i++) {
            g.put(i, new ArrayList<Integer>());
        }

        //add the edges provided
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];

            List<Integer> edgeList = g.get(from);
            edgeList.add(to);
            g.put(from, edgeList);
        }

        //do DFS on each node
        for (int i = 0; i < numCourses; i++) {
            if (globalV.contains(i)) { continue; }
            if (!DFS(g, i, visited, globalV)) { return false; }
        }

        return true;
    }

    public boolean DFS(Map<Integer, List<Integer>> g, int node, Set<Integer> visited, Set<Integer> globalV) {
        if (visited.contains(node)) { return false; }
        visited.add(node);
        globalV.add(node);

        //search adjacent edges
        for (Integer e : g.get(node)) {
            if (!DFS(g, e, visited, globalV)) {
                return false;
            }
        }

        //finished visiting all adjacent nodes so unmark current node as visited because different paths
        //may lead to the same node, but if they do not originate from the same node then no cycle occurs
        visited.remove(node);
        return true;

        //the time complexity is O(E + V). This is because we perform a DFS on each node at most once.
    }
}
