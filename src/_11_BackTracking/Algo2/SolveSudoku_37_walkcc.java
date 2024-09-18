package _11_BackTracking.Algo2;

import jdk.jfr.Description;
import java.util.Arrays;

// DFS method has return type of boolean.
// => as soon as we get the answer we just ignore further operations an ignores everything
// else like backtrack. Hence, original array contrails all the answer as we backtracked.
@Description("BEST APPROACH")
public class SolveSudoku_37_walkcc {
    public static void main(String[] args) {
        SolveSudoku_37_walkcc obj = new SolveSudoku_37_walkcc();

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
        obj.solveSudoku(board);
        for (char[] chars : board) System.out.println(Arrays.toString(chars));
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;
        int row = 0, col = 0;
        solve(board, row, col, n);
    }

    private boolean solve(char[][] board, int row, int col, int n) {
        if (row == n) return true;                                                  // found the answer case
        if (col == n) return solve(board, row + 1, 0, n);                   // row change case
        if (board[row][col] != '.') return solve(board, row, col + 1, n);       // cell value was already set

        // for this board[row][col] cell, put all possibilities from 0 till 9
        for (char c = '1'; c <= '9'; c++) {
            if (CHECK_IF_WE_CAN_PUT_THIS_VALUE(board, row, col, c)) {
                board[row][col] = c;                                                // put this value and move to next cell
                if (solve(board, row, col + 1, n)) return true;                 // if found the answer no need to do the back track.
                board[row][col] = '.';                                              // Do the backtracking step
            }
        }
        return false;
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

    private boolean CHECK_IF_WE_CAN_PUT_THIS_VALUE2(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; ++i)
            if (board[i][col] == c || board[row][i] == c || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        return true;
    }

}