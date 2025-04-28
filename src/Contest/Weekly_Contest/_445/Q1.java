package Contest.Weekly_Contest._445;

public class Q1 {
    public int findClosest(int x, int y, int z) {
        int first = Math.abs(z - x);
        int second = Math.abs(z - y);
        if (first == second) return 0;

        return first < second ? 1 : 2;
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();
    }
}
