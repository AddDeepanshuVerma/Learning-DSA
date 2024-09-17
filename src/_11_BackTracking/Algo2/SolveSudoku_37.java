package _11_BackTracking.Algo2;

import java.util.Arrays;

// NAIVE APPROACH: check others; here as we find the answer, we create an array ans stores values in it
// here even if our DFS finds the answer, though it store that in another array
// but still checks further combinations
class SolveSudoku_37 {
    static int count;

    public static void main(String[] args) {
        SolveSudoku_37 obj = new SolveSudoku_37();

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        for (char[] chars : board) System.out.println(Arrays.toString(chars));
        System.out.println("---------------------------");
        char[][] res = obj.solveSudoku(board);
        for (char[] chars : res) System.out.println(Arrays.toString(chars));
        System.out.println("loop ran count = " + count);
    }

    public char[][] solveSudoku(char[][] board) {
        int n = board.length;
        char[][] res = new char[n][n];
        int row = 0, col = 0;
        solve(board, row, col, n, res);
        return res;
    }

    private void solve(char[][] board, int row, int col, int n, char[][] res) {
        count++;
        // found the answer case
        if (row == n) {
            for (int i = 0; i < n; i++)
                System.arraycopy(board[i], 0, res[i], 0, n);
            return;
        }
        // row change case
        if (col == n) {
            solve(board, row + 1, 0, n, res);
            return;
        }

        // cell value was already set
        if (board[row][col] != '.') {
            solve(board, row, col + 1, n, res);
        } else {
            // for this board[row][col] cell, put all possibilities from 0 till 9
            for (char ch = '1'; ch <= '9'; ch++) {
                if (CHECK_IF_WE_CAN_PUT_THIS_VALUE(board, row, col, ch)) {
                    // put this value and move to next cell
                    board[row][col] = ch;
                    solve(board, row, col + 1, n, res);
                    // Do the backtracking step
                    board[row][col] = '.';
                }
            }
        }


    }

    private boolean CHECK_IF_WE_CAN_PUT_THIS_VALUE(char[][] board, int row, int col, char c) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            int subRow = ((row / 3) * 3) + (i / 3);
            int subCol = ((col / 3) * 3) + (i % 3);
            if (board[row][i] == c || board[i][col] == c || board[subRow][subCol] == c) {
                return false;
            }
        }
        return true;
    }


}