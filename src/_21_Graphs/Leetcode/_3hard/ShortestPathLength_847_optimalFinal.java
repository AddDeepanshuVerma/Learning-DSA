package _21_Graphs.Leetcode._3hard;

import java.util.LinkedList;
import java.util.Queue;

// most optimal so far : Used bitMasking to track visited path for each individual node & hence a common HashSet for all nodes
class ShortestPathLength_847_optimalFinal {

    /**
     * -------------------------------
     * \U0001f9e0 INTUITION:
     * -------------------------------
     * We want to visit all `n` nodes using the shortest path (min number of steps).
     * Since we can start anywhere and revisit nodes, we use:
     * ✅ BFS (shortest path in unweighted graph)
     * ✅ Bit-masking to represent visited nodes
     * ✅ Multi-source BFS (start from all nodes)
     * <p>
     * State: (currentNode, visitedMask)
     * Goal: when visitedMask == (1 << n) - 1 (all nodes visited)
     * <p>
     * -------------------------------
     * \U0001f680 ALGORITHM (BFS + BIT-MASKING):
     * -------------------------------
     * 1. Initialize queue with all nodes as starting points.
     * 2. For each step, explore all neighbors.
     * 3. Update visited mask using OR: (mask | (1 << neighbor))
     * 4. If all nodes are visited, return the number of steps.
     * 5. Use a `seen` 2D array to avoid revisiting the same state.
     * <p>
     * -------------------------------
     * ✅ TIME COMPLEXITY: O(n * 2^n)
     * -------------------------------
     * - There are n nodes.
     * - Each state is (node, visitedMask), and visitedMask has 2^n possibilities.
     * <p>
     * -------------------------------
     * ✅ SPACE COMPLEXITY: O(n * 2^n)
     * -------------------------------
     * - For the queue and seen array.
     */

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // BFS queue: int[]{node, visitedMask}
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];

        // Final bitmask when all nodes are visited: 111...1 (n bits)
        int allVisitedMask = (1 << n) - 1;

        // STEP 1: Start BFS from every node
        for (int i = 0; i < n; i++) {
            int mask = 1 << i; // only node i is visited
            queue.offer(new int[]{i, mask});
            seen[i][mask] = true;
        }

        int steps = 0;

        // STEP 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all states at current BFS level
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int node = current[0];
                int mask = current[1];

                // If all nodes visited, return steps
                if (mask == allVisitedMask) return steps;

                // Explore neighbors
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (!seen[neighbor][nextMask]) {
                        queue.offer(new int[]{neighbor, nextMask});
                        seen[neighbor][nextMask] = true;
                    }
                }
            }

            steps++;
        }

        return -1; // Should never reach here since graph is connected
    }
}