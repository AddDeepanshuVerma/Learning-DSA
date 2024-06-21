package AdityaVerma_BS;

public class Desc_array_BS {
    static int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
    public static void main(String[] args) {
        int index = binarySearchDesc(arr, 0);
        System.out.println(index);

    }

    private static int binarySearchDesc(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
