1. When every we are being asked that we need to move from one state string of another state string in minimal time
   THEN BFS IS THE SOLUTION.

2. If we know "the connection bw 2 nodes" OR "their is an edge bw this and this node", we can form DSU/UnionFind.
   And with DSU we can also calculate number of islands connected.

3. DSU 's union function can be way compact like : parent[find(edge[1])] = find(edge[0]).
   "return i == parent[i] ? i : (parent[i] = find(parent[i]));"
   source : _21_Graphs.Leetcode._2medium._5ValidPath_1971_DSU_COMPACT

4. Check if we really need to make Adjacency lists (HashMap<Integer, List<Integer>> adj)
   or we can work with given graph structure.✨✨✨✨✨✨

5. When working with a Graph which is given as a type of Tree unDirected graph and we are applying BFS or DFS
   Then instead of maintaining visited type boolean array, we can simple work in parent node: next node that we are going to
   explore just does not have to be parent rest are fine.
   for (Integer v : adj.getOrDefault(u, Collections.emptyList())){
        if (v != parent){ /* then proceed */ }
   }

6. When it is given that graph is a tree It means we are forcefully being told that:
    This graph is a single component
    This graph would not have any cycle
    This graph traversal does not need to have visited boolean array, we can simply check vai nextNode != parentNode ✨✨✨

7. In Tree type graph only parent->child relationship is needed, hence instead of adding u->v & v->u, we can simply work with
    parent->child as pr given relation in problem (like 2246 submitted solutions).✨✨✨

8. In Dijkstra algorithm we do not use boolean type visited as the one with lower & lower weight serves this purpose where we would not
    visit the same index again as edgeWeights are positive & we can not get lower weight going backward (note: in case of -ive weights
    BellMan ford algo comes into picture until there is a -ive cycle in the graph.

9. In a Directed graph if edges is given like :  edges = [2,2,3,-1]
    Then we do not need to make adjacency lists using HashMap, we can do traversal using this edges 1D array Alone.✨✨✨

10. In DSU when we have explored all edges and created one parent array, Now before processing that data further, we must call
    find(i) for each index in parent array to make sure all values are updated.

11. check out ony DSU solution for problem : "2360. Longest Cycle in a Graph" Here with the help of some given condition we are applying
    DSU on directed graph to detect longest cycle length in graph.🖤🖤🖤

12. TOPOLOGICAL SORT : A really smart question based on this sorting is there on leetcode: 2115, Here even to identify that "it is a graph question
    and being a directed graph can be solved using topological sort" is hard.
    Here problems where, the one node depends on another and that another can be dependent of any other can be solved if we are ale top write the
    Topological sorted order of all of those node(here we start bfs with those nodes that has no dependency or has indegree == 0).
    And every other node that we go through, for this topological order to be created, is a reachable node. Rest those were not reachable must be
    in some kind of cycle and topological order does not contain cycle, hence only valid node will be there.🔥🔥🔥

13. After implementing DSU, when we have our parent[] & size[] array ready, there are multiple ways to know about:
    how many parents we have & how many components they have
    A. Brute force ways: Using HashSet to store unique data in parents array & later that HashSet can be used to get size[value]

        HashSet<Integer> components = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            int leader = find(i);
            components.add(leader);
        }
        for (Integer component : components) {
            int currComponentSize = size[component];
        }

    B. Optimal way: Instead of using HashSet we can use simple array & increment common parents index value

        int[] components = new int[n];
        for (int i = 0; i < parent.length; i++) {
            components[find(i)]++;
        }
        int numOfComponents = 0;
        for (int i = 0; i < components.length; i++) {
            if (components[i] == 0) continue;
            int currComponentSize = size[i];
            numOfComponents++;
        }

    C. Most optimal way : simply traverse all nodes/parentsArray & when index == parent[index] means this is our leader of one of the component
       and those under his leader ship would not have same condition true, hence calculate the size as well

       int numOfComponents = 0;
       for (int i = 0; i < n; i++) {
           if (parent[i] == i) {
               int currComponentSize = size[i]
               numOfComponents++;
           }
       }
       return count;

14. While applying Dijkstra algorithm or doing any BFS before exploring the neighbour node of current node, below check can save significant
    amount of time:
    if (currWeight_of_u > minWeight_so_far[u]) continue;
    // do not explore neighbours nodes of v further in the HashMap
    for (int[] ngrb : adj.getOrDefault(u, Collections.emptyList())) {
        -----
        -----
    }

15. A problem related to DSU can be set in such a way that:
    that we will have a chance to build graph using 1 by 1 edge using DSU and while building this graph in a increasing order of
    edge weight, we can say that at some point the max edge weight used is lower to what we are going to use next.
    Hence in this case we have two pointer:
        one pointer adds the edge by DSU 1 by 1 &
        second pointer answers all the queries (already in sorted order) whose weight is less that used in graph
    USE-CASE : 1697. Checking Existence of Edge Length Limited Paths

16. A DSU problem shows us that :
    a problem can be set where instead of creating single DSU graph, multiple DSU graph can be calculated
    where we used the instance of DSU class to be created multiple times like : Alice = new DSU(), BOB = new DSU();
    And in such way a question can be formed like :
    USE-CASE : 1579. Remove Max Number of Edges to Keep Graph Fully Traversable

17. Sometime we really need a hint to be sure that this question can be solved after considering it as a Graph Question LIKE : 399

18. In Dijkstra algorithm we relay on our weight array instead of visited array as we are always looking for minimum answer
    but if there is a case when we don't need weight array as we are sure simple BFS + priorityQueue will reach to destination
    then we can remove this weight array concept and callBack that visited array one.

19. if given constraints is : n<=10
    Then we can apply O(2^n ∗ n^3) === (subset of n length) x (floyd warshall algo on those subsets).s

20. In Floyd Warshall algorithm when we are putting given edges weights of problem, There might be multiple a->b path with diff weights
    hence always put using mat[i][j] = Math.min(mat[i][j], currWeight).

21. Floyd Warshall can be optimized using below methods:
    for (int i = 0; i < matrix.length; i++) {
        Arrays.fill(matrix[i], Integer.MAX_VALUE);
        matrix[i][i] = 0;
    }

    for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (matrix[i][k] == Integer.MAX_VALUE) continue;            // saves our time by writing early
                for (int j = 0; j < 26; j++) {
                    if (matrix[k][j] == Integer.MAX_VALUE) continue;
                    -------------------
                    -------------------
                }
            }
    }

22. When we are bound to handle out of intMax range cases in priority queue
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int)a[1] - (int)b[1]);
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> a[1] < b[1] ?  -1 : 1);
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
    PriorityQueue<Pair>   pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.weight));

    in such problem we can use long INF as : Long.MAX_VALUE / 2;

23. To forward & backward the digit character 1 by 1
    char forw = (char) (((int) (ch - '0') + 1) % 10 + '0');

    char bacw = (char) (((int) (ch - '0') - 1 + 10) % 10 + '0');
    char bacw = (char) (((int) (ch - '0') + 9) % 10 + '0');

    Another way :
        char ch = arr[i];
            for (int move : new int[]{1, -1}) {
                arr[i] = (char) (((int) (ch - '0') + move + 10) % 10 + '0'); // forward & backward single digit in wheel
                String v = String.valueOf(arr);
                if (visited.contains(v)) continue;
                visited.add(v);
                q.offer(v);
            }
        arr[i] = ch;

24. If given that graph is Acyclic, think about "topological sort" OR "onion peeling", does't matter if given Graph is directed/undirected.

25. Whenever we are using the combination of PriorityQueue & visited Hashset
    then make sure that we mark the key visited only when it pops out of queue at the starting of while loop.
    Reason : as if we mark that key in ngbr for loop, there might be a better case with low cost occur later which will be neglected by prior one.

26. As a rule of thumb TLE happens around 10^8, so when n = 100 and edges = n^2 === 10^4, any algorithm under O(E^2) or O(n^4) can pass!
    Like FloydWarshall TC : nv^3

27. The discussion of Dijkstra s time complexity makes the assumption that the number of edges ∣E∣ is proportional to ∣V∣^2 .
    While such a graph is theoretically possible because each vertex can have ∣V∣−1 edges, real world graphs tend to be sparse.
    It is more common in discussions of Dijkstra's algorithm to assume that ∣E∣ is proportional to ∣V∣ (not ∣V∣ 2 ). Assuming more
    realistic inputs, the time complexity for a single run of the algorithm is O(n⋅log(n)), where n=∣V∣. We run this for each node,
    so the total time complexity will tend to be more like O(n 2 ⋅log(n)). The runtime distribution for this problem bears this out,
    as Floyd-Warshall implementations tend to do worse than Dijkstra's implementations.

    Obviously this all depends on your input! If you know for some reason that the input graphs are likely to be very dense,
    then Floyd-Warshall will do better for you.

28. Reverse thinking is very hard and counters intuitive : GRAPH : 3419 :
    if someone asks us to check if all nodes can be reachable to a single target node. instead of starting from all the nodes
    and try to figure out if we can reach to target node, it makes sense to start from target and try to reach to all the other nodes.
    Now we are left with directions which we can control anyways. because we are always given the edges, its we who decide the direction
    as per our problem requirements. Just always think if you need to reach to single node from multiple nodes, think of reversing the direction.

29. Whenever we are given directed Graph we need to think in below order:
    a. Check if we can applying topological sort resolve our.
    b. Check if we need to travel all node with repeated edges then we might apply, add my children first then add me addLast.
    c. if it is asking for shortest path with +ve weights, it's dijkstra.
    d. If nothing is working so far, Check if reversing the graph can help or not.
    e. As in only Directed graph we can do reversing, it would be the last option if nothing works!!!!!

30. WE CAN NOT APPLY WAVE TYPE BFS IN DIJKSTRA ALGORITHM DUE TO THE USE OF PRIORITY-QUEUE.
    As we can not use wave type BFS in PriorityQueue hence attached delta with each node being put in PQ itself (3342 leetcode problem).



























