package _08_Strings.medium;

class RepeatedStringMatch_686 {

    public static void main(String[] args) {
        System.out.println((long) "deepanshu".hashCode());
    }

    public int repeatedStringMatch_optimal(String a, String b) {
        return 0;
    }

    // 261ms Beats 55.72%
    public int repeatedStringMatch(String a, String b) {
        int ceil = (int) Math.ceil((double) b.length() / a.length());
        StringBuilder sb = new StringBuilder();
        sb.append(a.repeat(Math.max(0, ceil)));
//        sb.append(a.repeat(ceil));
//        String repeat = a.repeat(ceil);
        if (sb.toString().contains(b)) return ceil;
        sb.append(a);
        if (sb.toString().contains(b)) return ceil + 1;
        return -1;
    }

    //651ms Beats 5.07%
    public int repeatedStringMatch2(String a, String b) {
        int ceil = (b.length() / a.length()) + 2;
        int ans = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= ceil; i++) {
            sb.append(a);
            if (sb.toString().contains(b)) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }

    // 268ms Beats 31.72%
    public int repeatedStringMatch3(String a, String b) {
        int ceil = (int) Math.ceil((double) b.length() / a.length());
        int ans = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= ceil; i++) {
            sb.append(a);
            if (sb.toString().contains(b)) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}