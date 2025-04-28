package _11_BackTracking.medium;

import java.util.ArrayList;
import java.util.List;

class CombinationSum_39_2 {
    List<List<Integer>> list;

    public static void main(String[] args) {
        CombinationSum_39_2 obj = new CombinationSum_39_2();
        int[] arr = {1, 2, 3};
        System.out.println(obj.combinationSum(arr, 3));
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        list = new ArrayList<>();
//        Arrays.sort(arr); No need to sort as we are applying back-tracking
        dfs(0, target, arr, new ArrayList<>());
        return list;
    }

    private void dfs(int index, int target, int[] arr, List<Integer> temp) {
/*
        System.out.print("temp = " + temp);
        System.out.print(", target = " + target);
        if (target == 0) {
            System.out.println(" <== ");
        }else System.out.println();
        */
        if (target < 0) return;
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
/*
         yha humne phle index ki sari possibility le li ki phla index; 1 baar aae to kya, 2 baar aae to kya
         aur ye phla baki index ki kitni values ke saath aake expected result de dega aise hi
         maximum baar aae to kya and then jb second element ki possibility pr gye to uski sari possibility dekhi
         but pichhle index ko ek bar bhi nahi dekha sothat ek aisa element hmesha missing rhe jiski frequency
         same ho hi nahi skti means ek element ki frequency later same ho hi nahi paegi

         DIS: jb bhi hum ek element pr hain to usko poora explore krnege but agle pr jate hi unke pichhle ko nahi

         Note : kisi bhi element ko tb tk explore krte rhenge jb tk uske ane wale elemens wrong results dena na
         start kr dein.
         */
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
//             no need to create a new list each time as we are removing the last element as each step while applying back tracking
//            dfs(i, target - arr[i], arr, new ArrayList<>(temp));
            dfs(i, target - arr[i], arr, temp);
            temp.removeLast();
        }
    }
}