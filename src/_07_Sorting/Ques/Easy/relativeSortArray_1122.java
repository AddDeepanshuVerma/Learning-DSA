package _07_Sorting.Ques.Easy;

import java.util.*;

class relativeSortArray_1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] arr3 = {2,2,2,1,4,3,3,9,6,7,19};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        System.out.println(Arrays.toString(arr3));

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        System.out.println(map);
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            int values = map.get(arr2[i]);
            while (values > 0){
                if(!map.containsKey(arr1[j])) list.add(arr1[j]);
                arr1[j] = arr2[i];
                values--;
                j++;
            }
        }
        Collections.sort(list);
        for (int i = arr1.length - 1, k = 0; i >= arr1.length - list.size(); i--) {
            arr1[i] = (int) list.get(k);
            j++;
        }
        return arr1;
    }
}