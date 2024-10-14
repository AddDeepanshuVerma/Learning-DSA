package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LetterCombinations_17 {
    public static void main(String[] args) {
        LetterCombinations_17 obj = new LetterCombinations_17();
        List<String> list = obj.letterCombinations("9");
        System.out.println("list = " + list);

    }

    public List<String> letterCombinations(String digits) {
        final Map<Character, String> map = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",
                                                  '6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
        List<String> res = new ArrayList<>();
        int index = 0;
        StringBuilder temp = new StringBuilder();
        solve(digits.toCharArray(), index, temp, res, map);
        return res;
    }

    private void solve(char[] arr, int index, StringBuilder temp, List<String> res, Map<Character, String> map) {
        if (index == arr.length) {
            if (!temp.isEmpty()) res.add(temp.toString());
            return;
        }

        for (char c : map.get(arr[index]).toCharArray()) {
            temp.append(c);
            solve(arr, index + 1, temp, res, map);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}