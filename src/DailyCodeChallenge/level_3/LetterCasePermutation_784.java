package DailyCodeChallenge.level_3;

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation_784 {
    List<String> list;

    public List<String> letterCasePermutation(String s) {
        list = new ArrayList<>();
        String ip = s.toLowerCase();
        String op = "";
        DFS(op, ip);
        return list;
    }

    private void DFS(String op, String ip) {
        if (ip.isEmpty()) {
            list.add(op);
            return;
        }
        // Take with capital alpha
        DFS(op + Character.toLowerCase(ip.charAt(0)), ip.substring(1));
        // Take with small alpha
        DFS(op + Character.toUpperCase(ip.charAt(0)), ip.substring(1));

    }
}