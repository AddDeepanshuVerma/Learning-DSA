package _21_Graphs.Leetcode;

import java.util.*;

class _2CanFinish_207_BFS {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        /* KeyPoints:
         * It is a directed Graph & there can be a cycle in the Graph
         * As prob says that if a cycle is detected then it would be impossible to get the answer
         * Approach:
         * Hence our approach would be to find if cycle is there or not
         * If cycle is there, task is impossible else possible
         * Algo:
         * As we know It's a Directed Graph, so we'll think about topological
         * Hence if we could get the complete topological sorted array, cycle is there else not
         * Also : prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
         * */
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            // 'b -> a' is the path
            indegree[a]++;
            adj.computeIfAbsent(b, list -> new ArrayList<>()).add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return count == numCourses;
    }
}