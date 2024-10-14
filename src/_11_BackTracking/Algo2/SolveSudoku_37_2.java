package _11_BackTracking.Algo2;

import java.util.Arrays;

//Here achieving the results of boolean return type method from this void return type method.
//here as soon as we get the answer we update our flag as true and right before backtracking
// condition put an if statement to backtrack elements of original array which has the answer
class SolveSudoku_37_2 {
    static int count;

    static class FOUND_THE_ANSWER {
        boolean flag;

        public FOUND_THE_ANSWER(boolean flag) {
            this.flag = flag;
        }
    }

    public static void main(String[] args) {
        count = 0;
        SolveSudoku_37_2 obj = new SolveSudoku_37_2();

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
        System.out.println("loop ran count = " + count);
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;
        int row = 0, col = 0;
        solve(board, row, col, n, new FOUND_THE_ANSWER(false));
    }

    // as we retrieved after getting the answer hence original array also contains the answer
    private void solve(char[][] board, int row, int col, int n, FOUND_THE_ANSWER flag) {
        count++;
        // found the answer case
        if (row == n) {
            flag.flag = true;
            return;
        }
        // row change case
        if (col == n) {
            solve(board, row + 1, 0, n, flag);
            return;
        }

        // cell value was already set
        if (board[row][col] != '.') {
            solve(board, row, col + 1, n, flag);
        } else {
            // for this board[row][col] cell, put all possibilities from 0 till 9
            for (char ch = '1'; ch <= '9'; ch++) {
                if (CHECK_IF_WE_CAN_PUT_THIS_VALUE(board, row, col, ch)) {
                    // put this value and move to next cell
                    board[row][col] = ch;
                    solve(board, row, col + 1, n, flag);
                    // Do the backtracking step
                    if (flag.flag) break;
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