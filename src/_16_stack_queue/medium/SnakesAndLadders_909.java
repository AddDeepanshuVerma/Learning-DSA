package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayDeque;

class SnakesAndLadders_909 {

    public static void main(String[] args) {
        SnakesAndLadders_909 obj = new SnakesAndLadders_909();
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        System.out.println(obj.snakesAndLadders(board));
    }

    public int snakesAndLadders2(int[][] board) {
        int n = board.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[(n * n) + 1];
        visited[1] = true;
        q.offerFirst(1);
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int val = q.pollLast();
                if (val == n * n) return steps;
                for (int curr = val + 1; curr <= Math.min(val + 6, n * n); curr++) {
                    int newVal = getValue(board, curr);
                    int destination = newVal > 0 ? newVal : curr;
                    if (visited[destination]) continue;
                    q.offerFirst(destination);
                    visited[destination] = true;
                }
            }
            steps++;
        }
        return -1;
    }

    @Description("Why use BFS with explanation")
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        // size is +1 as given array values starts from 1 hence 0 will be neglected ans later values are used
        boolean[] visited = new boolean[(n * n) + 1];
        // we have already visited 1 hence true
        visited[1] = true;
        // queue has already first element as done in BFS sol
        q.offerFirst(1);
        int steps = 0;

        while (!q.isEmpty()) {
            // getting the size for that level so that all elements gets removed from that level as size we
            // keep on changing at every poll
            int size = q.size();
            while (size-- > 0) {
                int val = q.pollLast();
                // all those values which were put in queue again has our required result will be checked while
                // popping them as we will have their correct steps now
                if (val == n * n) return steps;
                // all possible next level nodes are here in this queue there are 6 possibilities
                for (int curr = val + 1; curr <= Math.min(val + 6, n * n); curr++) {
                    int destination = getValue(board, curr) > 0 ? getValue(board, curr) : curr;
                     /*if this possibility has already been explored means there has already been added similar
                     value to our queue WITHIN LOWER STEPS ACHIEVEMENT HENCE NO NEED TO CALCULATE HIGHER STEPS
                     like 6th can be achieved by 1 with dice value of 5 in single time or by 1 with dice value
                     of 1 in 5 times (we need to calculate minimum steps)*/
                    if (visited[destination]) continue;
                    visited[destination] = true;
                    // ALL NEW possibilities will be stored for the same level in queue
                    q.offerFirst(destination);
                }
            }
            // all those possibles which were stored in queue for this level will have steps++ then previous one hence increased
            steps++;
        }
        // if no solution found means we have visited all possibilities above and could not reach required result
        // and queue got empty as all levels were traversed hence no solution ~ -1
        return -1;
    }

    public int getValue(int[][] board, int val) {
        int n = board.length;
        int x = n - 1 - (val - 1) / n;
        int y = (val - 1) / n % 2 == 0 ? ((val - 1) % n) : (n - 1 - ((val - 1) % n));
        return board[x][y];
    }
}