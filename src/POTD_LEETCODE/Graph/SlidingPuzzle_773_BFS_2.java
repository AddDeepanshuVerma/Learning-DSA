package POTD_LEETCODE.Graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Calculated all possibilities from base-case only 1 time and providing the answer on O(1)
class SlidingPuzzle_773_BFS_2 {
    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {0, 4, 5}};
        System.out.println(slidingPuzzle(board));
        int[][] board2 = {{1, 2, 3}, {5, 4, 0}};
        System.out.println(slidingPuzzle(board2));
        int[][] board3 = {{4, 1, 2}, {5, 0, 3}};
        System.out.println(slidingPuzzle(board3));
        
        System.out.println(allPossibilities);
    }

    public static int slidingPuzzle(int[][] board) {
        String str = "";
        for (int[] arr : board)
            for (int num : arr)
                str += num;

        return allPossibilities.getOrDefault(str, -1);
    }

    //========================= ALL POSSIBILITY EXPLORED IN STATIC BLOCK =========================

    // Below map stores all possibility for 2*3 matrix with minimum count of changes
    static HashMap<String, Integer> allPossibilities;
    static HashMap<Integer, int[]> moves;

    static {
        moves = new HashMap<>();
        moves.put(0, new int[]{1, 3});
        moves.put(1, new int[]{0, 2, 4});
        moves.put(2, new int[]{1, 5});
        moves.put(3, new int[]{0, 4});
        moves.put(4, new int[]{3, 1, 5});
        moves.put(5, new int[]{4, 2});
    }

    static {
        String curr = "123450";
        int level = 0;
        allPossibilities = new HashMap<>();
        allPossibilities.put(curr, 0); // means we can reach from 123450 to target in 0 changes.

        ArrayDeque<String> q = new ArrayDeque<>();
        q.push(curr);

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size-- > 0) {
                String pop = q.pop();
                int blank = pop.indexOf('0');
                for (int move : moves.get(blank)) {
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