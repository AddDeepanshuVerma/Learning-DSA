package _21_Graphs.Leetcode._3hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class MaximumImportance_2285 {
    public static long maximumImportance(int n, int[][] roads) {
        int[][] degree = new int[n][2]; // {index, index's degree}
        for (int i = 0; i < degree.length; i++) {
            degree[i] = new int[]{i, 0};
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1];
            degree[u][1]++;
            degree[v][1]++;
        }
        Arrays.sort(degree, (a, b) -> a[1] - b[1]); // sorted based on degrees index

        // now assign each node a value from n to 1
        HashMap<Integer, Integer> map = new HashMap<>(); // {node, assigned value}
        for (int i = n; i > 0; i--) {
            map.put(degree[i - 1][0], i);
        }

        long sum = 0;
        for (int[] road : roads) {
            sum += map.get(road[0]) + map.get(road[1]);
        }
        return sum;
    }

    public static long maximumImportance2(int n, int[][] roads) {
        int[] degree = new int[n]; // {index, index's degree}
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // stores : {node, degree}

        for (int i = 0; i < degree.length; i++) {
            pq.offer(new int[]{i, degree[i]});
        }

        long sum = 0;
        // now max degree gets popped out & gets multiplied by max value available so far
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            sum += (long) n * poll[1];
            n--;
        }

        return sum;
    }

    public static long maximumImportance3(int n, int[][] roads) {
        int[] degrees = new int[n]; // {index, index's degree}
        for (int[] road : roads) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // stores : {node, degree}
        for (int degree : degrees) pq.offer(degree);

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += (long) n * pq.poll();
            n--;
        }

        return sum;
    }

    public static long maximumImportance4(int n, int[][] roads) {
        int[] degree = new int[n]; // {index, index's degree}
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);
        long sum = 0;

        for (int i = 0; i < degree.length; i++) {
            sum += (long) degree[i] * (i + 1);
        }
        return sum;
    }

    public static long maximumImportance5(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        long sum = 0;
        int i = 0;
        while (i < n) {
            sum += (long) degree[i++] * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        long ans = maximumImportance5(n, roads);
        System.out.println(ans);
    }
}