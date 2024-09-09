package DailyCodeChallenge.level_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LetterCasePermutation_784_2 {
    Set<String> set;

    public List<String> letterCasePermutation(String s) {
        set = new HashSet<>();
        String ip = s.toLowerCase();
        String op = "";
        DFS(op, ip);
        return new ArrayList<>(set);
    }

    private void DFS(String op, String ip) {
        if (ip.isEmpty()) {
            set.add(op);
            return;
        }
        // Take with capital alpha
        DFS(op + Character.toLowerCase(ip.charAt(0)), ip.substring(1));
        // Take with small alpha
        DFS(op + Character.toUpperCase(ip.charAt(0)), ip.substring(1));

    }
}