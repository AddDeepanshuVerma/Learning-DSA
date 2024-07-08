package DailyCodeChallenge.Binary_Search_on_answers;

class NumWaterBottles_1518 {
    public static void main(String[] args) {
        System.out.println(numWaterBottles2(14, 3));
    }

    public static int numWaterBottles(int n, int k) {
        int sum = n;
        while (n >= k) {
            sum += n / k;
            n = (n % k) + (n / k);
        }
        return sum;
    }

    public static int numWaterBottles2(int n, int k) {
        int sum = n, carry = 0;
        while (n >= k) {
            carry = n % k;
            n = n / k;
            sum += n;
            n += carry;
        }
        return sum;
    }
}