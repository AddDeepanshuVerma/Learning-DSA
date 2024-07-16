package _08_Strings.easy;

class RestoreString_1528 {
    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
    public static String restoreString(String s, int[] indices) {
        StringBuilder st1 = new StringBuilder(s);
        for (int i = 0; i < indices.length; i++) {
            st1.setCharAt(indices[i], s.charAt(i));
        }
        return st1.toString();
    }
}