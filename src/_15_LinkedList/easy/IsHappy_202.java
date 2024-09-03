package _15_LinkedList.easy;

class IsHappy_202 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = squareOfDigits(slow);
            fast = squareOfDigits(squareOfDigits(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int squareOfDigits(int n) {
        int temp = 0;
        while (n > 0) {
            int rem = n % 10;
            temp += (rem * rem);
            n /= 10;
        }
        return temp;
    }
}