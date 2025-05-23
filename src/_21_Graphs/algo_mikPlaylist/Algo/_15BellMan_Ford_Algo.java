package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.Arrays;

public class _15BellMan_Ford_Algo {
    /*
     * why : As we can not apply Dijkstra Algorithm with negative edges as when there would be an -ive cycle
     *       we will keep on finding the better path as weight was negative hence BellManFord comes into picture.
     *       which helps us find the shortest distance from source to other nodes even with -ive weight.
     * Limitations : Graph has to be a Directed Graph and if it's UnDirected, make adj Lists as Directed.
     * Algorithm :
     * 1. Fist make a fix order of edges we are going to work on.
     * 2. Now we need to relax all those edges in given order (Total Vertices - 1) time -
     * 3. Then we will get the Shortest path from a given source
     * 4. Initially let source = 0; Hence source to source distance is 0
     *    Then distance = {0,∞,∞,∞,∞,∞}
     *    Now based on this data we will relax all given edges v-1 times in A FIX ORDER.
     * 5. For each step we need to question below :
     *      For each edge given is (u, v, w), we need to ask
     *      if (distance[u] != infinity && distance[u] + w  < distance[v])
     *          distance[v] = distance[u] + w;
     *      Note: Here if distance of u is itself infinity for now then we can ignore
     *            also as we are going through each edge V-1 times hence even if 0th edge
     *            is in the end all other we be processed in remaining V-2 times relaxation.
     * NOTE : HERE WE RUN THE LOOP V-1 TIMES COZ IF WE CONTINUE AFTER THIS NO EDGES WILL BE RELAXED
     *        ANYMORE BUT IF THEY DO THAT MEANS THEIR LIES AN -IVE CYCLE IN GRAPH
     *        HENCE WHAT WE CAN DO IS RUN RELAXATION V TIMES AND FIND THE ANSWER THO IF QUESTION IS ASKING TO
     *        DETECT THE -IVE CYCLE RUN 1 MORE TIME AND IF ANY VERTEX GETS RELAXED IT MEANS -IVE CYCLE DETECTED.
     * */

    // 2642. Design Graph With Shortest Path Calculator (TO REVISE ABOUT ALL 3 ALGO)
    // TC : V*E
    // Brief : we relax edges in a specific order V-1 times while distance[src] = 0, keep a 1D array distance[], distance[src] = 0
    static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE); // OR TO SURPASS INTMAX CHECK LATER, WE CAN PUT 1E8 HERE

        distance[src] = 0;
        for (int i = 0; i < V; i++) { // as per algorithm should be V-1 times
            for (int[] edge : edges) { // {u, v, w}
                int u = edge[0], v = edge[1], w = edge[2];
                if (distance[u] == Integer.MAX_VALUE) continue; // if source is unreachable skip

                if (distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // now we are able to apply this relaxation 1 more time, means we found -ive cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                return new int[]{-1};// -ive cycle detected
            }
        }
        return distance;
    }
}
