package DailyCodeChallenge.Level_1;

import com.sun.jdi.Value;
import jdk.jfr.Description;

import javax.xml.transform.Source;
import java.io.FileInputStream;
import java.util.*;

class maxProfitAssignment_826 {
    public static void main(String[] args) {
        /*int[] difficulty = {66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63};
        int[] profit = {66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77};
        int[] worker = {61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16};*/
        int[] difficulty = {13, 37, 58};
        int[] profit = {4, 90, 96};
        int[] worker = {34, 73, 45};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    //Approach-3 (Using simple iteration and sorting)
    //T.C : O(nlogn + mlogm + m + n)
    //S.C : O(n)
    @Description("https://www.youtube.com/watch?v=_HptwlLP8sI&ab_channel=codestorywithMIK")
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        // Create an array of pairs to hold difficulty and profit
        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = difficulty[i];
            vec[i][1] = profit[i];
        }
        // Sort the array based on difficulty
        Arrays.sort(vec, (a, b) -> Integer.compare(a[0], b[0]));
        // Sort the worker array
        Arrays.sort(worker);

        int totalProfit = 0;
        int j = 0; // Pointer to vec array
        int maxProfit = 0;

        for (int i = 0; i < m; i++) {
            while (j < n && worker[i] >= vec[j][0]) {
                maxProfit = Math.max(maxProfit, vec[j][1]);
                j++;
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }

    //Approach-2 (Using Binary Search)
    //T.C : O(nlogn)
    //S.C : O(n)
    public static int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vec.add(new int[]{difficulty[i], profit[i]});
        }

        vec.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Pre-processing to find the maximum profit till index i at constant time
        for (int i = 1; i < vec.size(); i++) {
            vec.get(i)[1] = Math.max(vec.get(i)[1], vec.get(i - 1)[1]);
        }

        int totalProfit = 0;
        for (int i = 0; i < m; i++) {
            int workerDiffLevel = worker[i];

            // Apply binary search on list and find floor
            int l = 0, r = vec.size() - 1;
            int maxProfit = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (vec.get(mid)[0] <= workerDiffLevel) {
                    maxProfit = Math.max(maxProfit, vec.get(mid)[1]);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }

    //Approach-1 (Using max-heap)
    //T.C : O(nlogn + mlogn)
    //S.C : O(n)
    public static int maxProfitAssignment3(int[] difficulty, int[] profit, int[] worker) {
        // Create a max-heap using a priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap by profit
        for (int i = 0; i < difficulty.length; i++) {
            pq.offer(new int[]{profit[i], difficulty[i]});
        }
        /*for (int i = 0; i < pq.size(); i++) {
            System.out.println("peeking " + Arrays.toString(pq.peek()));
            pq.poll();
        }
        System.out.println();*/
        Integer[] worker_dsc = Arrays.stream(worker).boxed().toArray(Integer[]::new);
        Arrays.sort(worker_dsc, (a, b) -> b - a);
        int m = worker_dsc.length;
        int i = 0;
        int totalProfit = 0;
        while (i < m && !pq.isEmpty()) {
            if (pq.peek()[1] > worker_dsc[i]) {
                pq.poll();
            } else {
                totalProfit += pq.peek()[0];
                i++;
            }
        }

        return totalProfit;
    }

    // own approach
    //T.C : ~n^2
    public static int maxProfitAssignment4(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
        }
        Arrays.sort(difficulty);
        for (int i = 0; i < worker.length; i++) {
            int index = findFloor(difficulty, worker[i]);
            if (index == -1) continue;
            int value = difficulty[index];
            int max = findMaxProfitForGivenValue(map, value);
            sum += max;
        }
        return sum;
    }


    private static int findMaxProfitForGivenValue(Map<Integer, Integer> map, int value) {
        int max = 0;
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if (mp.getKey() <= value) {
                max = Math.max(mp.getValue(), max);
            }
        }
        return max;
    }

    private static int findFloor(int[] arr, int target) {
        /*if (target < arr[0]) {
            return 0;
        }*/
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        int ans = -1;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}


















