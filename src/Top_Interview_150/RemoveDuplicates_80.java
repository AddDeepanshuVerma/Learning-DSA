package Top_Interview_150;

class RemoveDuplicates_80 {

    public static void main(String[] args) {
      int[] arr = {1,1,1,2,2,3};
      System.out.println(removeDuplicates2(arr));
    }

    public static int removeDuplicates(int[] nums) {
      int i = 2;
      for (int j = 2; j < nums.length; j++) {
        if (nums[j] > nums[i - 2]) {
          nums[i] = nums[j];
          i++;
        }
      }
      return i;
    }

  public static int removeDuplicates2(int[] nums) {
    int i = 0;
      for (int j = 0; j < nums.length; j++) {
          if (i < 2 || nums[j] > nums[i - 2])
              nums[i++] = nums[j];
      }

    return i;
  }
}