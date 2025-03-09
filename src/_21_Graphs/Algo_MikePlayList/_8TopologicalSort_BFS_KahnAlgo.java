package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _8TopologicalSort_BFS_KahnAlgo {

    /*
     * keyPoints
     * 1. Topological sort using BFS is called Kahn's Algorithm
     * 2. As we know that Topological sort is nothing but sort all the vertex of Graph and a way
     *    that the sorted order supports u -> v path for every edge in the graph
     * 3. Kahn's Algo (Topological sort using BFS)
     *    Approach : Here as we know in this sorted order, the first has to be one which has no prior dependency
     *               hence inDegree term comes into picture.
     *               we will calculate inDegrees for all vertices and do a BFS for only those which has inDegree == 0
     *               and only put those vertex again whose updated inDegree is now zero
     * 4. That's how we will have appropriate sorted order which is called topological sorting (LOL)
     * 5. keep on storing those elements which were put in que are in expected/desired sorted order.
     * */
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int vertices = adj.size();
        int[] inDegree = new int[vertices];

        // calculate all vertices inDegrees
        for (ArrayList<Integer> lst : adj) {
            for (Integer v : lst) {
                inDegree[v]++;
            }
        }

        // Put all those vertex in que whose inDegrees are 0 to initiate BFS from.
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            ans.add(u); //store those which were added in q some time, will be in Topological order

            for (Integer v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) { // if this vertex inDegree is 0, then only can be put in Queue
                    q.offer(v);
                }
            }
        }
        return ans;
    }
}
