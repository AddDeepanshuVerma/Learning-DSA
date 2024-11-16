package DailyCodeChallenge.BitManipulation;

class MinChanges_2914 {
    public static void main(String[] args) {
        MinChanges_2914 obj = new MinChanges_2914();
        System.out.println(obj.minChanges("00010100111000"));
    }

    public int minChanges(String s) {
        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] != arr[i + 1]) {
                count++;
            }
        }
        return count;
    }
}