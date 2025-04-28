package POTD_LEETCODE.PriorityQueue;

import jdk.jfr.Description;

import java.util.PriorityQueue;

class MaxAverageRatio_1792 {
    public static void main(String[] args) {
        int[][] classes2 = {{1, 2}, {3, 5}, {2, 2}};
        System.out.println(maxAverageRatio2(classes2, 2));
    }

    @Description("Wrong observation!! here answer would not fall for the lowest value")
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

    @Description(" Interesting concept to solve the question in nlogn with explanation")
    public static double maxAverageRatio2(int[][] classes, int extraStudents) {
        /*
         * our aim is to put future deltas ( future - curr ) in a priority queue
         * which will give us max delta in log(n) with its index.
         * means : We'll be getting what will be the profit in pq when an increment is proposed
         * */

        // { delta ( curr + 1, curr) , index }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
//        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> b[0] == a[0] ? 0 : (b[0] > a[0] ? 1 : -1));
        for (int i = 0; i < classes.length; i++) {
            int[] cl = classes[i];
            double curr = cl[0] / (cl[1] * 1.0);
            double future = (cl[0] + 1) / ((cl[1] + 1) * 1.0);
            pq.offer(new double[]{future - curr, i});
        }

        // now we will get the index of our the best future increment to increase the one brilliant student
        while (extraStudents-- > 0) {
            double[] poll = pq.poll();
            int index = (int) poll[1];

            classes[index][0]++; // incrementing the best possible index of classes
            classes[index][1]++;

            int[] cl = classes[index];
            double curr = cl[0] / (cl[1] * 1.0);
            double future = (cl[0] + 1) / ((cl[1] + 1) * 1.0);
            pq.offer(new double[]{future - curr, index});
        }

        double ans = 0;
        // now simply calculate the average
        for (int[] cls : classes) {
            ans += cls[0] / (cls[1] * 1.0);
        }
        return ans / classes.length;
    }

    @Description(" Interesting concept to solve the question in nlogn without explanation")
    public static double maxAverageRatio_compact(int[][] classes, int extraStudents) {
        // { delta ( curr + 1, curr) , index }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < classes.length; i++) {
            int[] cl = classes[i];
            double curr = cl[0] / (cl[1] * 1.0);
            double future = (cl[0] + 1) / ((cl[1] + 1) * 1.0);
            pq.offer(new double[]{future - curr, i});
        }

        while (extraStudents-- > 0) {
            double[] poll = pq.poll();
            int index = (int) poll[1];

            classes[index][0]++; // incrementing the best possible index of classes
            classes[index][1]++;

            int[] cl = classes[index];
            double curr = cl[0] / (cl[1] * 1.0);
            double future = (cl[0] + 1) / ((cl[1] + 1) * 1.0);
            pq.offer(new double[]{future - curr, index});
        }

        double ans = 0;
        // now simply calculate the average of average
        for (int[] cls : classes) {
            ans += cls[0] / (cls[1] * 1.0);
        }
        return ans / classes.length;
    }

}