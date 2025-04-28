package _21_Graphs.Leetcode._3hard;

import java.util.ArrayDeque;
import java.util.HashSet;

//40 / 54 testcases passed
class ShortestPathLength_847_4 {
    /*Much improved : Here when we are traversing from a source, we are making sure that for each path we are storing what we have covered
    so far like for each individual path we are storing its path data beside this node in the queue.
    So that this specific node does not cover the same path again :
            for example : Its is laieka stream of water running from 0 to 1 & from 1 we can again run this stream 1 to 0 but will never reapeat
    the travelled stream, it is diffrent from BFS' visited concept coz now we can travel 0 to 1 then 1 to 0 but not again,here we
    visited 0 twise with same node path but not more than that.

    Hence each node wll have diffrent water streams from one to another node, here water streams form 0 to 1 & 1 to 0 are diffrent considered scenario.
    Also one nodes 0 to 1 stream should not impact on other node's 0 to 1 stream that is the reason we keep visited Hashset diffrent for each node.
            for example 0's path was 0 -> 1 -> 0 -> 2...., mean while 2's path was 2 -> 0 -> 1 -> 0....
    here 2 is using a path from 0 to 1 again but it should be valid hence we had to take diff visited path for each diffrent node(0 & 2 in this case)

    optimal using bitMasking:
    That if why to over come this complexity BitMasking comes into picture: if constraints are low we can do these two HashSet tasks
    in a single go, like here we are using visited & distinct Hashset to check visitedPath & distinct travelled node sofar respectably
    but bit mask can do this in single go:

    For example : 0 -> 1 -> 0 -> 1(this should be wrong)
    here we will store what we have travelled so far and keep in bitMask format & if we are about to repeat the same path, we stop
    like in above case 0001 -> from 0 : 0011 -> from 1 : 0011 -> from 0 : 0011(got repeated)

    Thats how bitMask catches the repeatation, It's same like it diffrentaite bw streams of water
            this bitMask also helps us if we reached the final destination or not as in final destination all bit will be converted to 1.
    Though here we have to maintain a visited<pair<>(from x : xxxx) BUT WE CAN HAVE THIS SET AS A UNIVERSAL SET INSTEAD OF DIFF
    FOR EACH NODE AS ALL NODE WILL HAVE DIFFRENT OR'ed NODES & if they are somehow same means we have already travelled till that node
    will simillar nodes visited hence we can ignore this repeatation as earlier one must have travelled with <= number of paths.

    In our two hasSet approach we could not make that universal as we were only storing node->node stream while in bitMask we have
    whole path.*/
    public int shortestPathLength(int[][] graph) {
        int nv = graph.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nv; i++) {
            int time = bfs(i, graph);
//            System.out.println("time = " + time);
            min = Math.min(min, time);
        }
        return min;
    }

    private int bfs(int curr, int[][] graph) {
        ArrayDeque<Trio> q = new ArrayDeque<Trio>();
        HashSet<String> visited = new HashSet<>();
        HashSet<Integer> distinct = new HashSet<>();

        distinct.add(curr);
        q.offer(new Trio(curr, visited, distinct));
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Trio poll = q.poll();
                int u = poll.node;
                HashSet<String> vis = poll.visited;
                HashSet<Integer> dis = poll.distinct;
                if (dis.size() == graph.length) { // found the answer
                    return level;
                }

                for (int v : graph[u]) {
                    String key = u + "_" + v;
                    if (!vis.contains(key)) {
                        HashSet<String> newVis = new HashSet<>(vis);
                        HashSet<Integer> newDis = new HashSet<>(dis);
                        newVis.add(key);
                        newDis.add(v);
                        q.offer(new Trio(v, newVis, newDis));
                    }
                }

            }
            level++;
        }
        return Integer.MAX_VALUE;
    }

    record Trio(Integer node, HashSet<String> visited, HashSet<Integer> distinct) {
    }

    public static void main(String[] args) {
        var obj = new ShortestPathLength_847_4();
//        int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
//        int[][] graph = {{1, 2}, {0, 2}, {0, 1}};
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(obj.shortestPathLength(graph));
    }
}