package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingLocal {

    public static void main(String[] args) {

//        System.out.println(missingNumber(new int[]{4,3,2,7,8,2,3,1}));
//        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
//        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
//        System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(firstMissingPositive(new int[]{1}));

    }
    public static int firstMissingPositive(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i]-1;
            if(arr[i] > 0 && arr[i] <= arr.length  && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index+1){
                return index+1;
            }
        }
        return arr.length+1;
}
    public  static int missingNumber2(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
        }

        // case 2
        return arr.length;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        final List<Integer> duplicates = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            final int n = Math.abs(nums[i]);
            if(nums[n - 1] < 0) {
                duplicates.add(n);
            } else {
                nums[n - 1] *= -1;
            }
            System.out.println(Arrays.toString(nums));
        }

        return duplicates;

    }

    public static int findDuplicate(int[] nums) {
            int i = 0;
            while (i < nums.length){
                int cI =  nums[i] - 1;
                if(nums[i] != nums[cI]){
                    swap(nums, i, cI);
                }else{
                    i++;
                }
            }
            System.out.println(Arrays.toString(nums));
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] != j+1){
                    return nums[j];
                }
            }
            return nums.length;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i]-1;
            if( nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        i = 0;
        List<Integer> list  = new ArrayList<>();
        while(i < nums.length){
            if(nums[i] != i+1){
                list.add(i+1);
            }
            i++;
        }
        return list;

    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
    public static int missingNumber(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }

}
