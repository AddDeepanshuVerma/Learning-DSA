package Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(BinarySearch(new int[]{1,2,4,5,6}, 5));
    }

    public static int BinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                System.out.println("start = " + start);
                System.out.println("end = " + end);
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        return -1;
    }
}