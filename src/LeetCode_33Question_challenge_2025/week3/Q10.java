package LeetCode_33Question_challenge_2025.week3;

public class Q10 {
    long[] bank;
    int start;
    int end;

    public Q10(long[] balance) {
        bank = balance;
        start = 0;
        end = bank.length - 1;
    }

    private boolean isInvalidAccount(int acc) {
        return acc < start || acc > end;
    }

    public boolean transfer(int account1, int account2, long money) {
        // transfer money from account1 -> account2
        if (isInvalidAccount(--account1) || isInvalidAccount(--account2) || bank[account1] < money) return false;
        bank[account1] -= money;
        bank[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (isInvalidAccount(--account)) return false;
        bank[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (isInvalidAccount(--account) || bank[account] < money) return false;
        bank[account] -= money;
        return true;
    }

    public static void main(String[] args) {
        long[] balance = {10, 100, 20, 50, 30};
        Q10 obj = new Q10(balance);
        System.out.println("null");
        System.out.println(obj.withdraw(3, 10));
        System.out.println(obj.transfer(5, 1, 20));
        System.out.println(obj.deposit(5, 20));
        System.out.println(obj.transfer(3, 4, 15));
        System.out.println(obj.withdraw(10, 50));
    }
}
