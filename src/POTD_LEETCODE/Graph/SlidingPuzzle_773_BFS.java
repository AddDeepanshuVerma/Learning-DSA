package POTD_LEETCODE.Graph;

import java.util.*;

//Calculating through BFS for shortest path answer each time
class SlidingPuzzle_773_BFS {
    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {0, 4, 5}};
        System.out.println(slidingPuzzle(board));
        int[][] board2 = {{1, 2, 3}, {5, 4, 0}};
        System.out.println(slidingPuzzle(board2));
    }

    public static int slidingPuzzle(int[][] board) {
        /*
         * instead of using 2D array, we can maintain a string more appropriately
         * which given us some pros & cons:
         *   pros :  1. Easy to maintain data on diff-diff possibilities as String is send by value not reference
         *           2. No need to apply backTracking as String in immutable
         *           3. As at some point we might need to go to the already visited path but never the same state which
         *               occurred earlier hence a HashMap<Sting> can be used to check all possible state occurred
         *   cons :  1. How are we going to maintain that black item need to switch based on UDRL while now it's a 1D string
         *               To solve this : as we know given items can be placed at max 6 places which is very small scale hence
         *                               we can store moving possibility for all 6 places.
         *  */

        String target = "123450";
        String curr = "";
        for (int[] ints : board)
            for (int num : ints)
                curr += num;

        HashMap<Integer, int[]> moves = new HashMap<>();
        moves.put(0, new int[]{1, 3});
        moves.put(1, new int[]{0, 2, 4});
        moves.put(2, new int[]{1, 5});
        moves.put(3, new int[]{0, 4});
        moves.put(4, new int[]{3, 1, 5});
        moves.put(5, new int[]{4, 2});

        Set<String> visited = new HashSet<>();
        visited.add(curr);
        ArrayDeque<String> q = new ArrayDeque<>();
        q.push(curr);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String pop = q.pop();
                if (pop.equals(target)) return level;

                int blank = pop.indexOf('0');
                for (int move : moves.get(blank)) {
                    String newBoard = swap(pop, blank, move);
                    if (!visited.contains(newBoard)) {
                        visited.add(newBoard);
                        q.add(newBoard);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private static String swap(String pop, int i, int j) {
        char[] arr = pop.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }

}