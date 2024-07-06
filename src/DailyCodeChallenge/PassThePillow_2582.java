package DailyCodeChallenge;

class PassThePillow_2582 {
    public int passThePillow(int n, int time) {
        int pass = n - 1;
        if ((time / pass) % 2 == 0) {
            //count from start
            return 1 + (time % pass);
        } else {
            //count from end
            return n - (time % pass);
        }
    }
}