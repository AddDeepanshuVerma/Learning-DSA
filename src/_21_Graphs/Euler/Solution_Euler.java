package _21_Graphs.Euler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution_Euler {
    /* Problem Statement :
    An Eulerian Path is a path in graph that visits every edge exactly once.
    An Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex.
    Given an undirected connected graph with V nodes, and E edges, with adjacency list adj,
    return 2 if the graph contains an eulerian circuit, else if the graph contains an eulerian path, return 1,
    otherwise, return 0.*/

    public int isEulerCircuit(int V, List<Integer>[] adj) {
        // V represents total number of vertices lets say 3
        // adj list represents for each vertex [0, 1, 2], vertices they are pointing to
        // ep :     V = 3; adj = [[1, 2], [0, 2], [0, 1]]
        // here 0 points to (1,2), 1 points to (0,2) & 2 points to (0,1)

        /* Solution :
         *   First need to check if all non-zero degree vertices are connected : true : false;
         *   Now find how many vertices has odd number of degrees
         *   If odd num of degrees == 0 => Euler circuit
         *   If odd num of degrees == 2 => Euler Path
         *   If odd num of degrees == 0 => None
         * */

        System.out.println("adj = " + Arrays.toString(adj));
        System.out.println("V = " + V);

        if (!isConnected(V, adj)) return 0;

        int count = 0; // odd Degrees Vertex Count
        for (List<Integer> list : adj) {
            if ((list.size() & 1) == 1) { // size was odd
                count++;
            }
        }

        if (count > 2) return 0; // none
        if (count == 2) return 1; // Euler path detected only
        return 2; // Euler circuit/circle detected
    }

    private boolean isConnected(int v, List<Integer>[] adj) {
        // first find any nonZeroDegreeVertex which has some degree
        int nonZeroDegreeVertex = -1;
        for (int i = 0; i < adj.length; i++) {
            if (!adj[i].isEmpty()) {
                nonZeroDegreeVertex = i;
                break;
            }
        }
        // now run a DFS from this nonZeroDegreeVertex & mark all visited nonZeroDegreeVertex as visited
        Set<Integer> visited = new HashSet<>();
        dfs(adj, nonZeroDegreeVertex, visited);

        // now if there is any vertex which is nonZeroDegree and not visited then there are 2 separate graph & we'll return false
        for (int i = 0; i < v; i++) {
            if (!visited.contains(i) && !adj[i].isEmpty()) {
                return false; // two separate graphs found hence no euler
            }
        }
        return true;
    }

    private void dfs(List<Integer>[] adj, int nonZeroDegreeVertex, Set<Integer> visited) {
        visited.add(nonZeroDegreeVertex);

        for (Integer vertex : adj[nonZeroDegreeVertex]) {
            if (!visited.contains(vertex)) {
                dfs(adj, vertex, visited);
            }
        }
    }
}