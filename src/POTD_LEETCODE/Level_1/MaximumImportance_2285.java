package POTD_LEETCODE.Level_1;

public class MaximumImportance_2285 {
    public static void main(String[] args) {

    }

    /*public long maximumImportance(int n, int[][] roads) {
        long res = 0;
        int[] a = new int[n];
        for (int[] r : roads) {
            a[r[0]]++;
            a[r[1]]++;
        }
        int[] arr = new int[n + 1];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a1, b) -> b.getValue() - a1.getValue());
        for (int i = 0; i < n; i++) {
            pq.add(new Pair<>(i, a[i]));
        }
        while (!pq.isEmpty()) {
            arr[pq.peek().getKey()] = n--;
            pq.remove();
        }
        for (int[] r : roads) {
            res += arr[r[0]] + arr[r[1]];
        }

        return res;
    }*/
}
