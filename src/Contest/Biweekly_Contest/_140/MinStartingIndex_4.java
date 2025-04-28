package Contest.Biweekly_Contest._140;

class MinStartingIndex_4 {
    public static void main(String[] args) {
        System.out.println(MinStartingIndex_4.minStartingIndex("abcdefg", "bcdffg"));
    }
    public static int minStartingIndex(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();

        int j = 0;
        for (int i = 0; i <= (l1 - l2); i++) {
            int count = 0;
            for (j = 0; j < l2; j++) {
                if (s.charAt(j + i) != p.charAt(j)) {
                    count++;
                    if (count > 1) break;
                }
            }
            if (j == l2) {
                return i;
            }
        }
        return -1;
    }
}