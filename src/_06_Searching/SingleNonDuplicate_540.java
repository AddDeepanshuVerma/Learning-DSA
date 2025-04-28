package _06_Searching;
//https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleNonDuplicate_540 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,2,2,3,3}));
    }
    public static int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (start == end) return nums[start];
            if(mid + 1 < nums.length && mid -1 > 0 && nums[mid] < nums[mid+1] && nums[mid-1] < nums[mid])
                return nums[mid];
            if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) start = mid + 1;
                else end = mid - 1;
            } else if (mid + 1 < nums.length && nums[mid] != nums[mid + 1]) {
                if (mid % 2 != 0) start = mid + 1;
                else end = mid - 1;
            }
        }
        return nums[start];
    }

    public static int singleNonDuplicate2(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start < end){
            int mid = (start + end)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
    }
}
