package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _9DetectCycle_DG_BFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1)));
        adj.add(new ArrayList<>(List.of(2)));
        adj.add(new ArrayList<>(List.of(3)));
        adj.add(new ArrayList<>(List.of(3)));
        var obj = new _9DetectCycle_DG_BFS();
        System.out.println(obj.isCyclic(adj));
    }

    /*
     * Key Points :
     * 1. As we know that it is Directed Graph and to apply Kahn's Algorithm this graph need to be Acyclic(no cycle)
     * 2. Hence We will try to get Topological sort using BFS (apply Kahn's Algorithm)
     * 3. If we would successfully be able to get topological Sort out of this Graph OR
     *    let's say, if we were able to explore all vertices while applying Kahn's Algo
     * 4. Would mean that there is no cycle
     * 5. Though if we could not get the topological sort of all vertices or could not visit all nodes;
     *    means we could not apply Kahn's algo hence - "IT IS A DIRECTED BUT CYCLIC GRAPH"
     */
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int vertices = adj.size();
        int[] inDegree = new int[vertices];

        for (ArrayList<Integer> list : adj) {
            for (Integer v : list) {
                inDegree[v]++;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0; // count the number of nodes getting explored
        while (!q.isEmpty()) {
            int u = q.poll();
            count++; // this first is explored

            for (Integer v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        if (count == vertices) {
            return false; // no cycle was there as we have successfully explored all nodes so far after applying Kahn's Algorithm
        }
        return true;
    }
}
