package _21_Graphs.randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class CourseSchedule_207_DFS {
    public static void main(String[] args) {
        var obj = new CourseSchedule_207_DFS();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
//        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        System.out.println(obj.courseSchedule(numCourses, prerequisites));
    }

    public boolean courseSchedule(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] arr : prerequisites) {
            adj.computeIfAbsent(arr[1], list -> new ArrayList<>()).add(arr[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] seen = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && checkIfCycleExists(i, seen, adj, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean detectCycle(int curr, boolean[] seen, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        seen[curr] = true;
        for (Integer next : adj.getOrDefault(curr, Collections.emptyList())) {
            if (seen[next]) return true; // cycle detected
            if (visited[next]) continue;
            if (detectCycle(next, seen, adj, visited)) {
                return true;
            }
        }
        seen[curr] = false;
        return false;
    }

    private boolean checkIfCycleExists(int curr, boolean[] seen, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        seen[curr] = true;
        for (Integer next : adj.getOrDefault(curr, Collections.emptyList())) {
            if (!visited[next] && checkIfCycleExists(next, seen, adj, visited)) {
                return true;
            } else if (seen[next]) {
                return true;
            }
        }
        seen[curr] = false;
        return false;
    }
}