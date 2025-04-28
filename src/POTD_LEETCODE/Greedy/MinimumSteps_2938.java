package POTD_LEETCODE.Greedy;

class MinimumSteps_2938 {
    public static void main(String[] args) {
        MinimumSteps_2938 obj = new MinimumSteps_2938();
        System.out.println(obj.minimumSteps("101"));
    }

    public long minimumSteps(String s) {
        return solve(s.toCharArray());
    }

    private long solve(char[] arr) {
        int i = 0, j = arr.length - 1;
        int count = 0;
        while (i < j) {
            if (arr[i] == '1' && arr[j] == '0') {
                count += j - i;
                i++;
                j--;
            } else {
                while (i < j && arr[i] == '0') {
                    i++;
                }
                while (i < j && arr[j] == '1') {
                    j--;
                }
            }
        }
        return count;
    }
}