package _07_Sorting.Ques.Easy;

import java.util.Arrays;
import java.util.HashMap;

class sortByBits_1356 {
    public static void main(String[] args) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        sortByBits(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortByBits(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, countOfOnesInDigit(i));
        }
        System.out.println(map);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (map.get(arr[j]) < map.get(arr[j-1])) {
                    swap(arr, j, j - 1);
                }else break;
            }
        }
        return arr;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static Integer countOfOnesInDigit(int i) {
        String st = Integer.toBinaryString(i);
        return st.split("1", -1).length-1;
    }
}