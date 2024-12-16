package POTD_LEETCODE.PriorityQueue;

import java.util.PriorityQueue;

class MaxAverageRatio_1792 {
    public static void main(String[] args) {
//        int[][] classes = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int[][] classes2 = {{1, 2}, {3, 5}, {2, 2}};
        System.out.println(maxAverageRatio(classes2, 2));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[0] / a[1], b[0] / b[1]));

        for (int[] aClass : classes) {
            pq.offer(new double[]{aClass[0], aClass[1]});
        }
        while (extraStudents-- > 0) {
            double[] remove = pq.remove();
            remove[0]++;
            remove[1]++;
            pq.offer(remove);
        }
        double ans = 0.0;
        int count = classes.length;
        while (!pq.isEmpty()) {
            double[] remove = pq.remove();
            ans += remove[0] / remove[1];
        }
        return ans / count;
    }
}