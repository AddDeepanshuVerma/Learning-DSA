package DailyCodeChallenge.BitManipulation;

class MinEnd_3133 {
    public static void main(String[] args) {
        MinEnd_3133 obj = new MinEnd_3133();
//        System.out.println("here : " + obj.minEnd(1, 1));
//        System.out.println("here : " + obj.minEnd(4, 1));
//        System.out.println("here : " + obj.minEnd(3, 4));
//        System.out.println("here : " + obj.minEnd(2, 7));
        System.out.println("here : " + obj.minEnd(6715154, 7193485));
    }

    public long minEnd(int n, int x) {
        int num = x;
        for (int i = 0; i < n; i++) {
            num = (num + 1) | x;
        }
        return num;
    }

    // does not work for long values as checking each num 1 by 1
    public long minEnd2(int n, int x) {
        long curr = x, next = x;
        long count = -1;

        while (true) {
            if ((curr & next++) == x) {
                curr = x;
                if (++count == (n - 1)) break;
            }
        }
        return next;
    }

    // does not work for long values
    public long minEnd3(int n, int x) {
        long curr = x;
        long next = x;

        long count = -1;

        while (true) {
            if ((curr & next) == x) {
                curr = curr & next;
                count++;
                if (count == (n - 1)) {
                    break;
                }
            }
            next++;
        }
        return next;
    }
}