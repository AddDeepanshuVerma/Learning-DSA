package _18_TREE.medium;

import java.util.*;

class MostProfitablePath_2467_compact {
    public static void main(String[] args) {
        MostProfitablePath_2467_compact obj = new MostProfitablePath_2467_compact();
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        int[] amount = {-5644, -6018, 1188, -8502};
        System.out.println(obj.mostProfitablePath(edges, 3, amount));
    }

    int max;
    ArrayDeque<Integer> stack;
    HashMap<Integer, List<Integer>> n2n;
    Set<Integer> visited;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int alice = 0;
        max = Integer.MIN_VALUE;
        stack = new ArrayDeque<>();
        visited = new HashSet<>();
        n2n = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            n2n.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            n2n.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
        }

        // find the path from alice(0) till bob and store in a stack
        DFS_Bob(alice, bob);

        // do a BFS where we will keep On burning nodes from 0,
        // level wise & whenever we go to next level our bob also moves to stack top element
        BFS_Alice(bob, amount);
        return max;
    }

    private void BFS_Alice(int bob, int[] amount) {
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        int value = amount[0];
        if (bob == 0) value = amount[0] >> 1;

        queue.addLast(new Pair(0, value));
        visited = new HashSet<>(Set.of(0));

        while (!queue.isEmpty()) {
            if (!stack.isEmpty()) amount[stack.pop()] = 0;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair poll = queue.removeFirst();
                List<Integer> list = n2n.get(poll.node);
                if (list.size() == 1 && poll.node != 0) max = Math.max(max, poll.sum); /* here this is the leaf node */
                for (int ngbr : list) {
                    if (!visited.contains(ngbr)) {
                        visited.add(ngbr);
                        int temp = amount[ngbr];
                        if (!stack.isEmpty() && stack.peek() == ngbr) {
                            temp = amount[ngbr] >> 1;
                        }
                        queue.addLast(new Pair(ngbr, poll.sum + temp));
                    }
                }
            }
        }
    }

    private boolean DFS_Bob(int root, int bob) {
        stack.push(root);
        visited.add(root);
        if (root == bob) return true;

        for (int ngbr : n2n.get(root)) {
            if (!visited.contains(ngbr)) {
                if (DFS_Bob(ngbr, bob)) return true;
            }
        }
        visited.remove(root);
        stack.pop();
        return false;
    }

    record Pair(int node, int sum) {
    }
}