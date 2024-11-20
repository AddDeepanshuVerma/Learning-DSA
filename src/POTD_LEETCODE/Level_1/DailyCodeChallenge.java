package POTD_LEETCODE.Level_1;

import jdk.jfr.Description;

import java.util.*;

public class DailyCodeChallenge {
    static int[][] arr2D = new int[][]{
            {0, 0, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 0}
    };
    static int[][] arr2D2 = new int[][]{
            {0},
            {1},
            {1},
            {0},
            {0},
            {1},
    };

    public static void main(String[] args) {
//        int str = longestIdealString("acfgbd", 2);
//        System.out.println(str);
//        System.out.println(minFallingPathSum(new int[][]{{1,7,20},{5,20,6},{7,5,20}}));
//        System.out.println(findFirstOccurance("godding", 'n'));
//        System.out.println(findlastOccurance("godding", 'n'));
//        System.out.println(reversePrefix("abcdefd", 'd'));
//        System.out.println(findMaxTwoPointer(new int[]{-1,10,6,7,-7,1}));
//        System.out.println(numSubarrayBoundedMax(new int[]{2,9,2}, 2, 8));
//        System.out.println(compareVersion("0.1","1.1"));
//        System.out.println(numRescueBoats2(new int[]{3,5,3,4}, 5));
//        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10,7,9,8,1})));
//        System.out.println(maximumHappinessSum1(new int[]{0,0,-1,-2,-3, 1,2,3,4,10,7,9,8,1} , 5));
//        System.out.println(maximumHappinessSum3(new int[]{0,0,-1,-2,-3, 1,2,3,4,10,7,9,8,1} , 5));
        System.out.println(matrixScore(arr2D));
    }

    @Description("Below is solution within itself")
    public static int matrixScore(int[][] grid) {
        int res = 0;
        int row = grid.length;
        // Change row as per first value in each row has to be 1
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            int sum = 0;
            for (int[] ints : grid)
                sum += ints[i];
            if (sum <= row / 2) {
                for (int j = 0; j < row; j++) {
                    grid[j][i] = grid[j][i] == 0 ? 1 : 0;
                }
            }
        }
        for (int[] ints : grid) {
            int rowSum = binaryToDecimal(ints);
            res += rowSum;
        }
        return res;
    }

    private static int binaryToDecimal(int[] arr) {
        int res = 0, base = 1;
        for (int i = arr.length - 1; i >= 0; i--, base <<= 1)
            if (arr[i] == 1)  res += base;
        return res;
    }

    @Description("Below is solution with help of functions")
    public static int matrixScore1(int[][] grid) {
        int res = 0;
        // Change row as per first value in each row has to be 1
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                switchRow(grid, i);
            }
        }
        printMatrix(grid);
//        switch columns if 0's are more & switch if yes
        for (int i = 0; i < grid[0].length; i++) {
            int sum = sumOfColumn(grid, i);
            if (sum <= grid.length / 2) {
                switchColumn(grid, i);
            }
        }
//        printMatrix(grid);
        for (int i = 0; i < grid.length; i++) {
            int row = sumOfRowAfterBinaryConversion(grid[i]);
            System.out.println(i + "th row sum is :" + row);
            res = res + row;
        }
        return res;
    }

    private static int sumOfRowAfterBinaryConversion(int[] arr) {
        int sum = 0;
        int temp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum = sum + (int) Math.pow(2, temp++) * arr[i];
        }
        return sum;
    }

    private static void printMatrix(int[][] grid) {
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void switchRow(int[][] grid, int i) {
        for (int j = 0; j < grid[i].length; j++) {
            grid[i][j] = grid[i][j] == 0 ? 1 : 0;
        }
    }

    private static void switchColumn(int[][] grid, int i) {
        for (int j = 0; j < grid.length; j++) {
            grid[j][i] = grid[j][i] == 0 ? 1 : 0;
        }
    }

    private static int sumOfColumn(int[][] grid, int i) {
        int sum = 0;
        for (int[] ints : grid) {
            sum += ints[i];
        }
        /*for (int j = 0; j < grid.length; j++) {
            sum += grid[j][i];
        }*/
        return sum;
    }

    public static long maximumHappinessSum3(int[] arr, int k) {
        long sum = 0;
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for (int i = n - 1; i >= n - k; i--) {
            int max = Math.max(arr[i] - count++, 0);
            if (max > 0) sum += max;
//            sum += Math.max(arr[i] - count++, 0);
        }
        return sum;
    }

    public static long maximumHappinessSum1(int[] arr, int k) {
        long sum = 0;
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < k; i++) {
            sum += Math.max(arr[i] - i, 0);
        }
        return sum;
    }

    static void bubbleSort(int array[], int num) {
        int i, j, temp;
        for (i = 0; i < (num - 1); i++) {
            for (j = 0; j < num - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        Integer[] arr = Arrays.stream(happiness).boxed().toArray(Integer[]::new);
//        Arrays.sort(arr, (a, b) -> (b > a ? 1 : -1));
       /* Integer[] arr = new Integer[happiness.length];
        for (int i = 0; i < happiness.length; i++) {
            arr[i] = happiness[i];
        }*/
        Arrays.sort(arr, (a, b) -> (b - a));
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < k; i++) {
            sum += Math.max(arr[i] - i, 0);
        }
        return sum;
    }

    public static String[] findRelativeRanks(int[] nums) {
        final int n = nums.length;
        String[] ans = new String[n];
        HashMap<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < n; i++) keyMap.put(nums[i], i);
        Arrays.sort(nums);
        reverseArrays(nums);
        for (int i = 0; i < n; i++) {
            Integer a = keyMap.get(nums[i]);
            ans[a] = (i + 1) + "";
            switch (i) {
                case 0 -> ans[a] = "Gold Medal";
                case 1 -> ans[a] = "Silver Medal";
                case 2 -> ans[a] = "Bronze Medal";
            }
        }
        return ans;
    }

    private static void reverseArrays(int[] temp) {
        int start = 0;
        int end = temp.length - 1;
        while (start < end) {
            int x = temp[start];
            temp[start] = temp[end];
            temp[end] = x;
            start++;
            end--;
        }
    }

    public static int numRescueBoats2(int[] people, int limit) {
        // sorting thr array so that we could apply greed approach in here
        Arrays.sort(people);
        int minIndex = 0;
        int maxIndex = people.length - 1;
        int boat = 0;
        while (minIndex <= maxIndex) {
            //As we can send two people at max, being greedy; we'll send person with maximum weight either alone or if possible add one minimum weight person
            // If two people were sent means both minimum & maximum weight people will be removed from further calculation.
            if (people[minIndex] + people[maxIndex] <= limit) {
                minIndex++;
                maxIndex--;
            } else {
                // if just one was sent means we would have sent the maximum weight as being greedy and just it was removed from further calculation  .
                maxIndex--;
            }
            // boat is always sent with max of two and min of one person
            boat++;
        }
        return boat;
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        for (int i = 1; i < people.length; i++) {
            if (people[i - 1] + people[i] <= limit) {
                people[i] += people[i - 1];
            } else {
                count++;
            }
        }
        if (people[people.length - 1] > limit) {
            count += 2;
        } else {
            count += 1;
        }
        return count;
    }

    public int compareVersion2(String version1, String version2) {
        final String[] levels1 = version1.split("\\.");
        final String[] levels2 = version2.split("\\.");
        final int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; ++i) {
            final Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            final Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            final int compare = v1.compareTo(v2);
            if (compare != 0)
                return compare;
        }
        return 0;
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.min(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                return 1;
            } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                return -1;
            }
        }
        if (v1.length > v2.length) {
            for (int i = n; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) > 0) {
                    return 1;
                }
            }
        } else {
            for (int i = n; i < v2.length; i++) {
                if (Integer.parseInt(v2[i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int l = -1;
        int r = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > right)
                l = i;
            if (nums[i] >= left)
                r = i;
            ans += r - l;
        }
        return ans;
    }

    public static int findMaxTwoPointer(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        Arrays.sort(nums);
        if (nums[0] > 0 || nums.length < 2) right = left;
        while (left < right) {
            if (nums[left] + nums[right] == 0) {
                result = nums[right];
                break;
            } else if (nums[left] + nums[right] < 0) {
                left++;
            } else if (nums[left] + nums[right] > 0) {
                right--;
            }
        }
        return result;
    }

    public static int findMax(int[] nums) {
        int result = Integer.MIN_VALUE;
        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums) {
            set1.add(n);
            if (set1.contains(-n)) {
                result = Math.max(result, Math.abs(n));
            }
        }
        return result;
    }

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0) return -1;
//        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < 0) continue;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == 0) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static String reversePrefix(String word, char ch) {
           /* if(word.indexOf(ch) > 0){
                String str1 = word.substring(0, word.indexOf(ch)+1);
                String str2 = word.substring(word.indexOf(ch)+1, word.length());
                StringBuffer reversestr1 = new StringBuffer(str1).reverse();
                String res = reversestr1 + str2;
                return res;
            }else{
                return word;s
            }*/
        return word.indexOf(ch) > 0 ? new StringBuffer(word.substring(0, word.indexOf(ch) + 1)).reverse() + word.substring(word.indexOf(ch) + 1) : word;
//            return word.contains(ch) ? Collections.reverse(word.substring(0,word.charAt(ch))) + word.substring() : word;
    }

    /*private int numberOfNodes;
    private int[] distanceSum;
    private int[] subtreeSize;
    private List<Integer>[] graph;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.numberOfNodes = n;
        this.graph = new List[n];
        this.distanceSum = new int[n];
        this.subtreeSize = new int[n];
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int[] edge : edges) {
            int nodeA = edge[0], nodeB = edge[1];
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
        dfsPostOrder(0, -1, 0);
        dfsPreOrder(0, -1, distanceSum[0]);
        return distanceSum;
    }
    private void dfsPostOrder(int node, int parentNode, int depth) {
        distanceSum[0] += depth;
        subtreeSize[node] = 1;
        for (int child : graph[node]) {
            if (child != parentNode) {
                dfsPostOrder(child, node, depth + 1);
                subtreeSize[node] += subtreeSize[child];
            }
        }
    }
    private void dfsPreOrder(int node, int parentNode, int totalDistance) {
        distanceSum[node] = totalDistance;
        for (int child : graph[node]) {
            if (child != parentNode) {
                int childDistance = totalDistance - subtreeSize[child] + numberOfNodes - subtreeSize[child];
                dfsPreOrder(child, node, childDistance);
            }
        }
    }*/
    //    https://leetcode.com/problems/freedom-trail/?envType=daily-question&envId=2024-04-27
    public static int findRotateSteps(String ring, String key) {
//        String ring = "godding", key  =  "gd";
        int count = 0;
        int extraSpace = 0;
        int resultatntvalue = 0;
        for (int i = 0; i < key.length(); i++) {
            int firstOccurance = findFirstOccurance(ring, key.charAt(0));
            int lastOccurance = findlastOccurance(ring, key.charAt(0));
            resultatntvalue = Math.min(firstOccurance - extraSpace, lastOccurance + extraSpace);
        }
        return count;
    }

    class Solution {
        public int findRotateSteps(String ring, String key) {
            Map<String, Integer> mem = new HashMap<>();
            return dfs(ring, key, 0, mem) + key.length();
        }

        private int dfs(final String ring, final String key, int index, Map<String, Integer> mem) {
            if (index == key.length())
                return 0;
            final String hashKey = ring + index;
            if (mem.containsKey(hashKey))
                return mem.get(hashKey);
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < ring.length(); ++i)
                if (ring.charAt(i) == key.charAt(index)) {
                    final int minRotates = Math.min(i, ring.length() - i);
                    final String newRing = ring.substring(i) + ring.substring(0, i);
                    final int remainingRotates = dfs(newRing, key, index + 1, mem);
                    ans = Math.min(ans, minRotates + remainingRotates);
                }
            mem.put(hashKey, ans);
            return ans;
        }
    }

    private static int findFirstOccurance(String ring, char c) {
        return ring.indexOf(c);
    }

    private static int findlastOccurance(String ring, char c) {
        return ring.length() - ring.lastIndexOf(c);
    }

    //https://leetcode.com/problems/longest-ideal-subsequence/?envType=daily-question&envId=2024-04-25
    public static int minFallingPathSum2(int[][] grid) {
        int firstMin = 0;
        int secondMin = 0;
        int firstMinPos = -1;
        final int INF = Integer.MAX_VALUE;
        for (int[] row : grid) {
            int curFirstMin = INF;
            int curSecondMin = INF;
            int curFirstMinPos = -1;
            for (int j = 0; j < row.length; ++j) {
                int sum = (j != firstMinPos ? firstMin : secondMin) + row[j];
                if (sum < curFirstMin) {
                    curSecondMin = curFirstMin;
                    curFirstMin = sum;
                    curFirstMinPos = j;
                } else if (sum < curSecondMin) {
                    curSecondMin = sum;
                }
            }
            firstMin = curFirstMin;
            secondMin = curSecondMin;
            firstMinPos = curFirstMinPos;
        }
        return firstMin;
    }

    public static int longestIdealString(String s, int k) {
        // dp[i] := the longest subsequence that ends in ('a' + i)
        int[] dp = new int[26];
        for (final char c : s.toCharArray()) {
            final int i = c - 'a';
            dp[i] = 1 + getMaxReachable(dp, i, k);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private static int getMaxReachable(int[] dp, int i, int k) {
        final int first = Math.max(0, i - k);
        final int last = Math.min(25, i + k);
        int maxReachable = 0;
        for (int j = first; j <= last; ++j)
            maxReachable = Math.max(maxReachable, dp[j]);
        return maxReachable;
    }

    public static int minFallingPathSum(int[][] grid) {
        int firstMin = 0; // The smallest sum of the falling path so far.
        int secondMin = 0; // The second smallest sum of the falling path so far.
        int firstMinPos = -1; // Position of the smallest sum in the previous row.
        final int INF = Integer.MAX_VALUE; // Set a high value to represent the initial state that's effectively infinity.
        // Iterating through each row in the grid.
        for (int[] row : grid) {
            int curFirstMin = INF; // The smallest sum in the current row.
            int curSecondMin = INF; // The second smallest sum in the current row.
            int curFirstMinPos = -1; // Position of the smallest sum in the current row.
            // Iterating through each element in the current row.
            for (int j = 0; j < row.length; ++j) {
                // Calculate the sum by adding the current element to the smaller of the two sums from the previous row,
                // but not the one directly above (to avoid falling path through same column, hence j != firstMinPos check).
                int sum = (j != firstMinPos ? firstMin : secondMin) + row[j];
                // If the calculated sum is smaller than the current smallest sum, update the first and second min values and positions.
                if (sum < curFirstMin) {
                    curSecondMin = curFirstMin; // The smallest becomes the second smallest.
                    curFirstMin = sum;          // The current sum becomes the new smallest.
                    curFirstMinPos = j;         // Update the current smallest sum position.
                } else if (sum < curSecondMin) { // If the current sum is between first and second min, update the second min only.
                    curSecondMin = sum;
                }
            }
            // Prepare for next row.
            firstMin = curFirstMin;
            secondMin = curSecondMin;
            firstMinPos = curFirstMinPos;
        }
        // After processing all rows, the smallest sum will represent the minimum sum of a falling path.
        return firstMin;
    }
}
