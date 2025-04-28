package LeetCode_33Question_challenge_2025.week3;

public class Q4 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, target = n - k;
        int start = 0, end = n - 1;

        int pivot = -1;
        while (pivot != target) {
            pivot = findPivot(start, end, nums);
            if (pivot > target) {
                end = pivot - 1;
            } else if (pivot < target) {
                start = pivot + 1;
            }
        }
        return nums[target];
    }

    public int findPivot(int firstIndex, int lastIndex, int[] arr) {
        int pivot = arr[firstIndex];
        int i = firstIndex + 1;
        int j = lastIndex;
        while (i <= j) {
            while (i <= lastIndex && arr[i] < pivot) i++;
            while (j > firstIndex && arr[j] >= pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, firstIndex, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Q4 obj = new Q4();
        int[] nums = {1, 2, 3, 4, 5, 1, 1, 1, -5, -4, -3, -2, -1}; // {2,3,3,3,4,5,8,8} 6th = 8;
        int value = obj.findKthLargest(nums, 6);
        System.out.println("value = " + value);
    }
}
