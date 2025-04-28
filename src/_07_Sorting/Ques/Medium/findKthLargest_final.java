package _07_Sorting.Ques.Medium;

class findKthLargest_final {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(findKthLargest(arr, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int L = 0, pivot_idx = 0;
        int R = n - 1;
        while (true) {
            pivot_idx = indexOfPivotInArrays(nums, L, R);
            if (pivot_idx == k - 1) {
                break;
            } else if (pivot_idx > k - 1) {
                R = pivot_idx - 1;
            } else {
                L = pivot_idx + 1;
            }
        }
        return nums[pivot_idx];
    }

    public static int indexOfPivotInArrays(int[] arr, int firstIndex, int high) {
        int pivot = arr[firstIndex];
        int i = firstIndex;// both fine int i = firstIndex would not work for single element {1}, searching 1 ;
        int j = high;
        while (i <= j) {
            if (arr[i] < pivot && arr[j] > pivot) swap(arr, i++, j--);
            if (arr[i] >= pivot && i <= j) i++;
            if (arr[j] <= pivot && i <= j) j--;
        }
        swap(arr, j, firstIndex);
        return j;
    }

    public static int chat_GPT(int[] arr, int firstIndex, int high) {
        int pivot = arr[firstIndex];
        int i = firstIndex + 1;
        int j = high;
        while (i <= j) {
            while (i <= j && arr[i] >= pivot) i++;
            while (i <= j && arr[j] < pivot) j--;
            if (i <= j) swap(arr, i++, j--);
        }
        swap(arr, j, firstIndex);
        return j;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}