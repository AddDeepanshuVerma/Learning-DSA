package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak_140 {
    public static void main(String[] args) {
        WordBreak_140 obj = new WordBreak_140();

        String str = "pineapplepenapple";
        List<String> wordDict = List.of("apple","pen","applepen","pine","pineapple");
        List<String> list = obj.wordBreak(str, wordDict);
        System.out.println("list = " + list);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        // create dictionary to a Set for O(1) for contains method as being hash-based structure
        Set<String> wordSet = new HashSet<>(wordDict);

        // create a List<String> to store the results
        List<String> res = new ArrayList<>();
        //using back tracking: we will go through each possibility and search for expected results
        int index = 0;
        solve(s.toCharArray(), index, new ArrayList<String>(), wordSet, res);
        return res;
    }

    private void solve(char[] arr, int index, ArrayList<String> temp, Set<String> wordSet, List<String> res) {
        // base condition: if our index has been at the end of our source string means we don't need to check further just store the path we had to travel to reach here(stored in temp)
        if (index == arr.length) {
            String join = String.join(" ", temp);
            res.add(join);
            return;
        }

        // if we did not reach till out of bound for the source, we keep on check further possible strings
        String check = "";
        for (int i = index; i < arr.length; i++) {
            check += arr[i];
//            if (inTheWordDictionary(check, wordSet)) {
            if (wordSet.contains(check)) {
                // store this check string in temp list as a path of String in-case it reaches till end
                temp.add(check);
                // now up-to ith index e have our string available in word Dictionary, hence check further
                // String (from i+1 index) if it does, we will have our ans in the path (stored in temp)
                solve(arr, i + 1, temp, wordSet, res);
                // this line get executed right after we hit base case means,
                // now we have explored a path now let's explore other paths and restore their path
                temp.removeLast();
            }
        }
    }
}