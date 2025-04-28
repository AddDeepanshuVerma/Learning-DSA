package POTD_LEETCODE.Graph;

import java.util.ArrayDeque;
import java.util.HashMap;

//Calculated all possibilities from base-case only 1 time and providing the answer on O(1)
class SlidingPuzzle_773_BFS_2_compact {

    public static int slidingPuzzle(int[][] board) {
        String str = "";
        for (int[] arr : board)
            for (int num : arr)
                str += num;

        return allPossibilities.getOrDefault(str, -1);
    }

    final static HashMap<String, Integer> allPossibilities;
    final static int[][] moves;

    static {
        String curr = "123450";
        int level = 0;
        allPossibilities = new HashMap<>();
        allPossibilities.put(curr, level);
        moves = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}};

        ArrayDeque<String> q = new ArrayDeque<>();
        q.push(curr);

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size-- > 0) {
                String pop = q.pop();
                int blank = pop.indexOf('0');
                for (int move : moves[blank]) {
                    String newBoard = swap(pop, blank, move);
                    if (!allPossibilities.containsKey(newBoard)) {
                        allPossibilities.put(newBoard, level);
                        q.add(newBoard);
                    }
                }
            }
        }
    }

    private static String swap(String pop, int i, int j) {
        char[] arr = pop.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }

}