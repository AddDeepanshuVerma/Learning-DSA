package _13_Maths.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GetPermutation_60_2 {
    public static void main(String[] args) {
        GetPermutation_60_2 obj = new GetPermutation_60_2();
        System.out.println(obj.getPermutation(3, 3));
    }

    List<String> list;

    public String getPermutation(int n, int k) {
        list = new ArrayList<>();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) arr[i] = (char) ('1' + i);
//        System.out.println(arr);
        solve(arr, 0);
        System.out.println("list = " + list);
        Collections.sort(list);
        System.out.println("list = " + list);
        return list.get(k - 1);
    }

    private void solve(char[] arr, int idx) {
        if (idx == arr.length - 1) {
            list.add(String.valueOf(arr));
            return;
        } else for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            solve(arr, idx + 1);
            swap(arr, i, idx);
        }
    }

    private void swap(char[] arr, int i, int j) {
        if (arr[i] == arr[j]) return;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}









