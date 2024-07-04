package Recursion_10;

class NumberOfSteps_1342 {
    public int numberOfSteps(int n) {
        int count = 0;
        if (n == 0) return count;
        if (n % 2 == 0) {
            count++;
            count += numberOfSteps(n / 2);
        } else {
            count++;
            count += numberOfSteps(n - 1);
        }
        return count;
    }

    public int numberOfSteps_bits(int num) {
        int count = 0;

        while (num > 0) {
            num = (num & 1) == 1 ? num ^ 1 : num >> 1;
            count++;
        }
        return count;
    }
}