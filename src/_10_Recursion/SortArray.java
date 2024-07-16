package _10_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,2,1,4,5,6,7));
        System.out.println(sort(list));
    }

    public static List<Integer> sort(List<Integer> list) {
        if (list.size() == 1) return list;
        int temp = list.remove(list.size() - 1);
        sort(list);
        insert(list, temp);
        return list;
    }

    public static List<Integer> insert(List<Integer> list, int temp) {
        if (list.isEmpty() || list.get(list.size() - 1) <= temp) {
            list.add(list.size(), temp);
            return list;
        }
        int value = list.remove(list.size() - 1);
        insert(list, temp);
        list.add(list.size(), value);
        return list;
    }

    public static List<Integer> insert2(List<Integer> arr, int temp) {
        if (arr.isEmpty()) {
            arr.add(temp);
            return arr;
        } else if ((int) arr.get(0) >= temp) {
            arr.add(0, temp);
            return arr;
        } else if ((int) arr.get(arr.size() - 1) <= temp) {
            arr.add(arr.size(), temp);
            return arr;
        }
        int temp1 = (int) arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        arr = insert2(arr, temp);
        arr.add(arr.size(), temp1);
        return arr;
    }
}
