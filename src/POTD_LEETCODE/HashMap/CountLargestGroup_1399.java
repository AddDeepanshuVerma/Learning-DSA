package POTD_LEETCODE.HashMap;

class CountLargestGroup_1399 {
    public int countLargestGroup(int n) {
        int[] map = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            map[digitSum(i)]++;
        }

        int maxSize = 0;
        int count = 1;

        for (int size : map) {
            if (size == maxSize) {
                count++;
            } else if (size > maxSize) {
                count = 1;
                maxSize = size;
            }
        }
        return count;
    }

    public int countLargestGroup2(int n) {
        int[] map = new int[(String.valueOf(n).length()) * 9 + 1];

        for (int i = 1; i <= n; i++) {
            map[digitSum2(i)]++;
        }

        int maxSize = 0;
        int count = 1;

        for (int size : map) {
            if (size == maxSize) {
                count++;
            } else if (size > maxSize) {
                count = 1;
                maxSize = size;
            }
        }
        return count;
    }

    private int digitSum2(int val) {
        int sum = 0;
        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }

    int digitSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        for (char ch : s.toCharArray()) {
            sum += ch - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        var obj = new CountLargestGroup_1399();
        int count = obj.countLargestGroup2(13);
        System.out.println("count = " + count);
    }
}