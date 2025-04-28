package _07_Sorting.Algos;


class FindDuplicate_287 {
    public static void main(String[] args) {
        int[] arr = {5,4,5,3,2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[correct] == arr[i]) {
                i++;
            } else {
                swap(arr, correct, i);
            }
        }
//        System.out.println(Arrays.toString(arr));
//         got the sorted array
//         now find the missing number
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return arr[i];
            }
        }
        return -1;
    }

    static void swap(int[] arr, int first, int end) {
        int temp = arr[first];
        arr[first] = arr[end];
        arr[end] = temp;
    }
}