package _10_Recursion.easy;

class Search_704 {
    public int search(int[] nums, int target) {
        return DFS(nums, target, 0, nums.length - 1);
    }

    private int DFS(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                return DFS(nums, target, mid + 1, end);
            } else {
                return DFS(nums, target, start, mid - 1);
            }

        }
        return -1;
    }

    private int DFS2(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) return mid;
            return (nums[mid] < target) ?
                    DFS2(nums, target, mid + 1, end) :
                    DFS2(nums, target, start, mid - 1);
        }
        return -1;
    }

    private int DFS3(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = (start + end) >>> 1;
            return nums[mid] == target ?
                    mid :
                    nums[mid] < target ?
                            DFS3(nums, target, mid + 1, end) :
                            DFS3(nums, target, start, mid - 1);
        }
        return -1;
    }
}