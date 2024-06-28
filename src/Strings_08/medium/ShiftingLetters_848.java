package Strings_08.medium;

class ShiftingLetters_848 {

    public String shiftingLetters2(String s, int[] shifts) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        long t = 0;
        for (int i = n - 1; i >= 0; --i) {
            t += shifts[i];
            int temp = (int) ((cs[i] - 'a' + t) % 26);
            cs[i] = (char) ('a' + temp);
        }
        return String.valueOf(cs);
    }

    public String shiftingLetters(String s, int[] shifts) {
        long shift = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = shifts.length - 1; i >= 0; i--) {
            shift += shifts[i];
            long temp = (s.charAt(i) - 'a' + shift) % 26;
            char ch = (char) ('a' + temp);
            sb.append(ch);
        }
        return sb.reverse().toString();
    }

    public String shiftingLetters3(String s, int[] shifts) {
        long shift = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = shifts.length - 1; i >= 0; i--) {
            shift += shifts[i];
            long temp = s.charAt(i) - 'a';
            temp = (temp + shift) % 26;
            char ch = (char) ('a' + temp);
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}