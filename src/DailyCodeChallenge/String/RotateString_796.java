package DailyCodeChallenge.String;

class RotateString_796 {
    public static void main(String[] args) {
        RotateString_796 obj = new RotateString_796();
        System.out.println(obj.rotateString("abcde", "abced"));
    }

    public boolean rotateString(String s, String goal) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = goal.toCharArray();

        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[j] && check(arr1, i, arr2, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(char[] arr1, int i, char[] arr2, int j) {
        while (j < arr2.length && arr2[j] == arr1[i]) {
            i++;
            j++;
            i = i % arr1.length;
        }
        return j == arr2.length;
    }
}