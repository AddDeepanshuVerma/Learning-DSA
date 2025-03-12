package _21_Graphs.Leetcode._2medium;

import java.util.*;

class _7PossibleBipartition_886_DFS {
    public static void main(String[] args) {
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(possibleBipartition(4, dislikes));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        // nodes are from 1 to n
        // let initially no node was coloured hence initial colour === -1
        // -1 === no colour; 0 === red colour; 1 === black colour
        int[] coloured = new int[n + 1];
        Arrays.fill(coloured, -1);

        // let's create the edges here we are creating edge of dislikes means
        // we'll make them of different colour then previous every time meets(if they are no already coloured)

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] dislike : dislikes) {
            int u = dislike[0], v = dislike[1];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }

        for (int i = 1; i < n + 1; i++) {
            if (coloured[i] == -1) {
                int initialColour = 0; // always red
                if (sameColourDetected(i, initialColour, coloured, adj)) {
                    return false; // Given n can not be divided in 2 groups
                }
            }
        }
        return true;
    }

    private static boolean sameColourDetected(int u, int currColour, int[] colour, HashMap<Integer, List<Integer>> adj) {
        colour[u] = currColour;

        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (colour[v] == currColour) return true; // same colour detected of adjacent
            if (colour[v] == -1) { // no colour till now then colour it
                if (sameColourDetected(v, 1 - currColour, colour, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}