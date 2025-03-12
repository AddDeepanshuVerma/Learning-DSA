package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.*;

//Here we'll learn to find the length of Tree diameter or even print it
//Tree Diameter: No of edges in the longest path in Graph/Tree from any node to any other node")
public class _22_MaxDiameterUDG_TreeDiameter {
    /*
     * Concepts to learn:
     * 1. If you choose a random node u and find the farther node v from this u, then this node v
     *    will always be ONE OF THE END of the diameter of graph.
     * 2. The farthest node from one end of diameter is the other end of diameter
     *
     *
     * How to solve, using above 2 concepts:
     * 1. Pick any node & find the farther node v using BFS, this will be one of the end of tree diameter
     * 2. Now from this one end again run the BFS to find the farthest node, this will be another edge of diameter.
     * 3. Meanwhile, do these calculations we can calculate whatever else we need, length of diameter or print this diameter.
     * */

    public static void main(String[] args) {
        int[][] edges = {{1, 0}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
        int nV = 6;
        int treeDiameter = TreeDiameter(nV, edges);
        System.out.println(treeDiameter);
    }

    private static int TreeDiameter(int nV, int[][] edges) {
        // first create the graph from this given undirected edges
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }

        // pick any random node and find the farthest node from it
        Trio info1 = farthestNode_bfs(0, nV, graph); // return in the form of { u, farthest node from u, length of farthest node}
        int oneEnd = info1.end;

        // now find the farthest node from this one end of tree diameter
        Trio info2 = farthestNode_bfs(oneEnd, nV, graph);

        return info2.length;
    }

    private static Trio farthestNode_bfs(int start, int nV, HashMap<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[nV];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int nodeCount = 0, lastNode = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            nodeCount++;

            while (size-- > 0) {
                int u = q.poll();
                lastNode = u;

                for (int v : graph.get(u)) {
                    if (visited[v]) continue;
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        int edgeLength = nodeCount - 1;
        return new Trio(start, lastNode, edgeLength);
    }

    record Trio(Integer start, Integer end, Integer length) {
    }

}
