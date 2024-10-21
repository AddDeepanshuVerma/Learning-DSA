package _18_TREE.medium;

import java.util.*;

class MostProfitablePath_2467_2 {
    public static void main(String[] args) {
        MostProfitablePath_2467_2 obj = new MostProfitablePath_2467_2();
        int[][] edges = {{0, 1}, {1, 2}, {2,3}};
        int[] amount = {-5644,-6018,1188,-8502};
        System.out.println(obj.mostProfitablePath(edges, 3, amount));
    }


    int max;
    ArrayDeque<Integer> stack;
    HashMap<Integer, List<Integer>> n2n;
    Set<Integer> visited;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        max = Integer.MIN_VALUE;
        n2n = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int left = edge[0];
            int right = edge[1];
            n2n.computeIfAbsent(left, val -> new ArrayList<>()).add(right);
            n2n.computeIfAbsent(right, val -> new ArrayList<>()).add(left);
        }

        // find the path from root(0) till bob and store in a stack
        int root = 0;
        stack = new ArrayDeque<>();
        visited = new HashSet<>();
        DFS(root, bob);

        // do a BFS where we will keepOn burning nodes from 0 level wise
        // & whenever we go to next level our bob also moves to stack top element

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        visited.clear();

        int value = amount[0];
        if (bob == 0) {
            value = amount[0] >> 1;
        }
        Pair pair = new Pair(0, value);

//        amount[bob] = 0;
        queue.addLast(pair);
        visited.add(0);
        amount[stack.pop()] = 0;

        while (!queue.isEmpty()) {
            // move our
            // make bob's index value to zero
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
            if (!stack.isEmpty()) amount[stack.pop()] = 0;
        }
        return max;
    }

    private boolean DFS(int root, int bob) {
        stack.push(root);
        visited.add(root);
        if (root == bob) return true;

        for (int ngbr : n2n.get(root)) {
            if (!visited.contains(ngbr)) {
                if (DFS(ngbr, bob)) return true;
            }
        }
        visited.remove(root);
        stack.pop();
        return false;
    }

    record Pair(int node, int sum) {
    }
}