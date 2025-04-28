package _10_Recursion.algo1;

class Search_704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println("Index = " + new Search_704().search(nums, 2));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) return binarySearch(nums, mid + 1, end, target);
            else return binarySearch(nums, start, mid - 1, target);
        } else {
            return -1;
        }
    }

    private int binarySearch2(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (start + end) >>> 1;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return binarySearch2(nums, mid + 1, end, target);
        else return binarySearch2(nums, start, mid - 1, target);
    }
}