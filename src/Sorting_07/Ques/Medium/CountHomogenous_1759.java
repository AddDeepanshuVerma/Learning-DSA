package Sorting_07.Ques.Medium;

class CountHomogenous_1759 {
    public static void main(String[] args) {
        System.out.println(new CountHomogenous_1759().countHomogenous("aaabb"));
    }
    public int countHomogenous(String s) {
        long count = 1;
        long sum = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }else {
                count = 1;
            }
            sum += count;
        }
        return  (int) (sum % 1_000_000_007);
    }
}