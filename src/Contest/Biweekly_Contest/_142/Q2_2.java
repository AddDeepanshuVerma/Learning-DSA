package Contest.Biweekly_Contest._142;

import java.util.*;

class Q2_2 {
    public List<Integer> findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        List<Integer> answer = new ArrayList<>(Collections.nCopies(n, 1));

        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        int[] newParent = parent.clone();
        Map<Character, Stack<Integer>> lastSeen = new HashMap<>();

        // Helper method to reassign parents
        reassignParents(0, adj, newParent, s, lastSeen);

        List<List<Integer>> newAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newAdj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            newAdj.get(newParent[i]).add(i);
        }

        computeSubtreeSizes(0, newAdj, answer);
        return answer;
    }

    private void reassignParents(int node, List<List<Integer>> adj, int[] newParent, String s, Map<Character, Stack<Integer>> lastSeen) {
        char c = s.charAt(node);
        if (lastSeen.containsKey(c) && !lastSeen.get(c).isEmpty()) {
            newParent[node] = lastSeen.get(c).peek();
        }

        lastSeen.putIfAbsent(c, new Stack<>());
        lastSeen.get(c).push(node);

        for (int child : adj.get(node)) {
            reassignParents(child, adj, newParent, s, lastSeen);
        }

        lastSeen.get(c).pop();
        if (lastSeen.get(c).isEmpty()) {
            lastSeen.remove(c);
        }
    }

    private int computeSubtreeSizes(int node, List<List<Integer>> newAdj, List<Integer> answer) {
        int size = 1;
        for (int child : newAdj.get(node)) {
            size += computeSubtreeSizes(child, newAdj, answer);
        }
        answer.set(node, size);
        return size;
    }
}

