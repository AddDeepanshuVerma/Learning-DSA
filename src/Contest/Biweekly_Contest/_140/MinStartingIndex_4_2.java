package Contest.Biweekly_Contest._140;

class MinStartingIndex_4_2 {
    public static void main(String[] args) {
        System.out.println(MinStartingIndex_4_2.minStartingIndex("abcdefg", "bcdffg"));
    }

    public static int minStartingIndex(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();

        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < l1; j++) {
            sb.append(s.charAt(j));
            if (j - i + 1 > l2) {
                sb.deleteCharAt(0);
                i++;
            }
            if (j - i + 1 == l2) {
                if (checkIfValidString(sb.toString(), p)) {
                    return i;
                }
            }
        }
        return -1;

    }

    private static boolean checkIfValidString(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}