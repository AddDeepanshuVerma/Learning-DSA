package _07_Sorting.Algos;

class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else i++;
        }
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != j) {
                return j;
            }
            j++;
        }
        return nums.length;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}