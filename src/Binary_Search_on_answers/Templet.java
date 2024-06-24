package Binary_Search_on_answers;

public class Templet {

    private static boolean isValid(int[] nums, int mid, int m) {
        // we return either true or false based on the criteria 'k'
        return true;
    }

    private static int function(int[] nums, int m) {
        // nums is input array and m is some criteria on which we apply binary search
        int start = Integer.MIN_VALUE; //minimum  possible answer
        int end = Integer.MAX_VALUE; //maximum possible answer
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isValid(nums, mid, m)) { // if function = = true
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
