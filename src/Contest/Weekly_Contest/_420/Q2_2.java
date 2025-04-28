package Contest.Weekly_Contest._420;

public class Q2_2 {
    public static void main(String[] args) {
        Q2_2 obj = new Q2_2();
        System.out.println(obj.numberOfSubstrings("abcde", 1));
    }

    public int numberOfSubstrings(String s, int k) {

        int count = 0;
        // O(N^3)
        for (int i = 0; i < s.length(); i++) {                      // O(N)
            for (int j = i; j < s.length(); j++) {                  // O(N)
                if (checkSubString(s.substring(i, j + 1), k)) {     // O(N)
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkSubString(String substring, int k) {
        int[] arr = new int[26];
        char[] str = substring.toCharArray();
        for (char c : str) {
            int index = c - 'a';
            arr[index]++;
            if (arr[index] >= k) {
                return true;
            }
        }
        return false;
    }
}
