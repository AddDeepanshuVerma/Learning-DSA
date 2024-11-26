package POTD_LEETCODE.Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

// process was fine but the execution while carrying the while 2D array each time make it lengthy and more on TC side.
class SlidingPuzzle_773_fails {
    public static void main(String[] args) {
        SlidingPuzzle_773_fails obj = new SlidingPuzzle_773_fails();
        int[][] board = {{1, 2, 3}, {5, 4, 0}};
        System.out.println(obj.slidingPuzzle(board));

    }

    public int slidingPuzzle(int[][] board) {
        /*
         * get the (i, j) index of 0th val
         * and then run a BFS for all the possibility for up,down,right,left
         * while maintaining the level of depth in BFS, now asa we get
         * the desired answer break the loop and depth is the answer.
         * */
        int i = 0, j = 0;
        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[i].length; l++) {
                if (board[k][l] == 0) {
                    i = k;
                    j = l;
                    break;
                }
            }
        }

        ArrayDeque<Pair> q = new ArrayDeque<>();
        Set<Duo> set = new HashSet<>();
        set.add(new Duo(i, j));
        q.addLast(new Pair(i, j, board, new Duo(-1, -1)));
        int level = 0;
        boolean found = false;

        outer:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size && !q.isEmpty(); k++) {
                Pair pop = q.removeFirst();
                int row = pop.i, col = pop.j;
                int[][] newBoard = pop.newBoard;
                if (isEqual(newBoard)) {
                    found = true;
                    break outer;
                }

                if (row + 1 < 2 && !set.contains(new Duo(row + 1, col))) { //down
                    set.add(new Duo(row + 1, col));
                    swap(newBoard, row, col, row + 1, col);
                    q.addLast(new Pair(row + 1, col, copyArray(newBoard)));
                    swap(newBoard, row, col, row + 1, col);
                }
                if (col + 1 < 3 && !set.contains(new Duo(row, col + 1))) { //right
                    set.add(new Duo(row, col + 1));
                    swap(newBoard, row, col, row, col + 1);
                    q.addLast(new Pair(row, col + 1, copyArray(newBoard)));
                    swap(newBoard, row, col, row, col + 1);

                }
                if (row - 1 >= 0 && !set.contains(new Duo(row - 1, col))) { //up
                    set.add(new Duo(row - 1, col));
                    swap(newBoard, row, col, row - 1, col);
                    q.addLast(new Pair(row - 1, col, copyArray(newBoard)));
                    swap(newBoard, row, col, row - 1, col);
                }
                if (col - 1 >= 0 && !set.contains(new Duo(row, col - 1))) { //left
                    set.add(new Duo(row, col - 1));
                    swap(newBoard, row, col - 1, row, col);
                    q.addLast(new Pair(row, col - 1, copyArray(newBoard)));
                    swap(newBoard, row, col - 1, row, col);
                }
            }
            level++;
        }
        return found ? level : -1;
    }

    private int[][] copyArray(int[][] newBoard) {
        int[][] res = new int[2][3];
        for (int i = 0; i < 2; i++) {
            System.arraycopy(newBoard[i], 0, res[i], 0, 3);
        }
        return res;
    }

    private void swap(int[][] board, int row, int col, int newR, int newC) {
        int temp = board[row][col];
        board[row][col] = board[newR][newC];
        board[newR][newC] = temp;
    }

    private boolean isEqual(int[][] board) {
        int val = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 1 && j == 2) return true;
                if (board[i][j] != val++) return false;
            }
        }
        return true;
    }

    static class Pair {
        int i;
        int j;
        int[][] newBoard;
        Duo prev;

        public Pair(int i, int j, int[][] newBoard, Duo prev) {
            this.i = i;
            this.j = j;
            this.newBoard = newBoard;
            this.prev = prev;
        }

        public Pair(int i, int j, int[][] newBoard) {
            this.i = i;
            this.j = j;
            this.newBoard = newBoard;
        }
    }

    record Duo(int i, int j) {
    }
}