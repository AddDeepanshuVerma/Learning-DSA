package Strings_08.easy;

class CheckOnesSegment_1748 {
    public boolean checkOnesSegment(String s) {
        if(s.length() == 1) return true;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1' && s.charAt(i - 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkOnesSegment2(String s) {
        return !s.contains("01");
    }

}