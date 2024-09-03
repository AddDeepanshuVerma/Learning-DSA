package DailyCodeChallenge.Level_1;

class JudgeSquareSum_633 {

    public static void main(String[] args) {
        int a = 46340 * 46340;
        int b = 310 * 310;
        int c = a + b;
//        System.out.println(c);

        System.out.println(judgeSquareSum(2147483600));

    }
    public static boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        long sum = 0;
        while (i <= j) {
            sum = ((long) i * i) + ((long) j * j);
//            sum = ((long) i * i);
//            sum += ((long) j * j);
            if(sum == c) return true;
            else if(sum < c) i++;
            else j--;
        }
        return false;
    }

    public static boolean judgeSquareSum2(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        long sum = 0;
        int count =0;
        while (i <= j) {
            count++;
            sum = (i * i) + (j * j);
            if(sum == c) return true;
            else if(sum < c) i++;
            else j--;
        }
        System.out.println("count : " + count);
        return false;
    }
}