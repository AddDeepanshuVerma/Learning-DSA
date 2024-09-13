package DailyCodeChallenge.level_3;

import java.util.Arrays;

class SpiralMatrix_2326_2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int row, int col, ListNode head) {
        int[][] arr2D = new int[row][col];
        for (int[] arr : arr2D) Arrays.fill(arr, -1);

        ListNode temp = head;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (true) {
            for (int i = left; i <= right && temp != null; i++) {
                arr2D[top][i] = temp.val;
                temp = temp.next;
            }
            top++;
            if (temp == null) break;
            for (int i = top; i <= bottom && temp != null; i++) {
                arr2D[i][right] = temp.val;
                temp = temp.next;
            }
            right--;
            if (temp == null) break;

            for (int i = right; i >= left && temp != null; i--) {
                arr2D[bottom][i] = temp.val;
                temp = temp.next;
            }
            bottom--;
            if (temp == null) break;

            for (int i = bottom; i >= top && temp != null; i--) {
                arr2D[i][left] = temp.val;
                temp = temp.next;
            }
            left++;
            if (temp == null) break;
        }
        return arr2D;
    }
}