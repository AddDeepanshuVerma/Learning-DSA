package _07_Sorting.Ques.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class minimumAbsDifference_1200 {
    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList();
        int minDiff = Integer.MIN_VALUE;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-1; i++){
            minDiff = Math.max(arr[i] - arr[i+1], minDiff);
        }
        for(int j = 0; j<arr.length-1; j++){
            if(minDiff == arr[j] - arr[j+1]){
                list.add(Arrays.asList(arr[j], arr[j+1]));
            }
        }
        return list;
    }
}