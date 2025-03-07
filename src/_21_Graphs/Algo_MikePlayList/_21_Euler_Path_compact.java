package _21_Graphs.Algo_MikePlayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class _21_Euler_Path_compact {
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        if (!isConnected(V, adj)) return 0;

        int count = 0; // odd Degrees Vertex Count
        for (List<Integer> list : adj) {
            if ((list.size() & 1) == 1) { // size was odd
                count++;
            }
        }

        if (count > 2) return 0;    // none
        if (count == 2) return 1;   // Euler path detected only
        return 2;                   // Euler circuit/circle detected
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

        // now if there is any vertex which is nonZeroDegree and not visited then there are 2 separate component with edges
        // Hence we can not form an Euler Path so return false.
        for (int i = 0; i < v; i++) {
            if (!visited.contains(i) && !adj[i].isEmpty()) {
                return false; // two separate components with edges found hence no euler
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