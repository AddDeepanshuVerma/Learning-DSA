package _17_SlidingWindow.Algo;

// Maximum Sum Subarray of size K, Sliding Window
// 1. for an index we will simply go through whole array and keep on adding each and every element
// 2. while we'll also maintain an index if (j -i + 1) is ever touch our window size of k,then
//      first we will store our ans and before next element sum addition. here itself we will remove
//      ith index and increment i, that's how i and j maintains a window of size K.
public class WindowSizeFixed {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, -5, 6, 9, 2};
        int k = 4;
        System.out.println(maximumSubArraySum3(arr, k));
    }

    // General format for fixed size sliding window
    private static int maximumSubArraySum(int[] arr, int k) {
        int sum = 0, i = 0, ans = 0;
        int j = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                ans = Math.max(ans, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return ans;
    }

    // Sliding window main template with slight changes
    private static int maximumSubArraySum2(int[] arr, int k) {
        int sum = 0, i = 0, ans = 0;
        int j = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 == k) {
                ans = Math.max(ans, sum);
                sum -= arr[i++];
            }
            j++;
        }
        return ans;
    }

    // compact template
    private static int maximumSubArraySum3(int[] arr, int k) {
        int sum = 0, i = 0, ans = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if (j - i + 1 == k) {           // this if block is the ONLY root of sliding window algorithm
                ans = Math.max(ans, sum);
                sum -= arr[i++];
            }

        }
        return ans;
    }


}
