package POTD_LEETCODE.DFS;

import java.util.*;

class CheckIfPrerequisite_1462 {
    public static void main(String[] args) {
        int[][] prereq = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] queries = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};
        List<Boolean> booleans = checkIfPrerequisite(5, prereq, queries);
        System.out.println("booleans = " + booleans);

    }

    // gets TLE as we are applying BFS/DFS on each query
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] item : prerequisites) {
            int from = item[0], to = item[1];
            map.computeIfAbsent(from, val -> new ArrayList<>()).add(to);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int source = queries[i][0], target = queries[i][1];
            boolean[] visited = new boolean[numCourses];
            ans.add(dfs(source, target, map, visited));
            ans.add(bfs(source, target, map, visited));
        }
        return ans;
    }

    private static boolean bfs(int source, int target, HashMap<Integer, List<Integer>> map, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            if (poll == target) return true;

            for (Integer next : map.getOrDefault(poll, Collections.emptyList())) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return false;
    }

    private static boolean dfs(int source, int target, HashMap<Integer, List<Integer>> map, boolean[] visited) {
        if (source == target) {
            return true;
        }

        for (Integer next : map.getOrDefault(source, Collections.emptyList())) {
            if (!visited[next]) {
                visited[next] = true;
                if (dfs(next, target, map, visited)) return true;
            }
        }

        return false;
    }
}