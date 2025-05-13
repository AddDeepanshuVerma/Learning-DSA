package POTD_LEETCODE;

class LengthAfterTransformations_3335 {
    public int lengthAfterTransformations(String s, int t) {
        while (t-- > 0) {
            s = updateString(s);
        }
        return s.length();
    }

    private String updateString(String s) {
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 'z') {
                res.append("ab");
            } else {
                res.append((char) (ch + 1));
            }
        }
        return res.toString();
    }
}