package _21_Graphs.Leetcode;

import java.util.*;

class _3FindOrder_210_BFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] arr : prerequisites) {
            adj.computeIfAbsent(arr[1], list -> new ArrayList<>()).add(arr[0]);
            degree[arr[0]]++; // inDegree increasing for this vertex
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int course = 0; course < degree.length; course++) {
            if (degree[course] == 0) {
                q.offer(course);
            }
        }

        ArrayList<Integer> tplSortOrder = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            tplSortOrder.add(u);

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                degree[v]--;
                if (degree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        int size = tplSortOrder.size();
        if (size != numCourses) return new int[]{};

        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = tplSortOrder.get(i);
        }
        return ans;
    }

    // Slightly optimized approach
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] arr : prerequisites) {
            adj.computeIfAbsent(arr[1], list -> new ArrayList<>()).add(arr[0]);
            degree[arr[0]]++; // inDegree increasing for this vertex
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int course = 0; course < degree.length; course++) {
            if (degree[course] == 0) {
                q.offer(course);
            }
        }

        int[] ans = new int[numCourses];
        int count = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            ans[count++] = u;
            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                degree[v]--;
                if (degree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return count != numCourses ? new int[]{} : ans;
    }

}