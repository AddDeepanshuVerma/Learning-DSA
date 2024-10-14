package Contest.Biweekly_Contest._140.Copied;

import java.util.Random;

class Solution_4 {
    public int minStartingIndex(String s, String pattern) {

        int mul = 101;
        int mod = 1_000_000_007;

        RollingHashLong sHash = RollingHashLong.getHashFromString(s, mul, mod);

        RollingHashLong pHash = RollingHashLong.getHashFromString(pattern, mul, mod);

        int min, max, mid;

        int left, right;

        int end;

        for (int i = 0; i + pattern.length() <= s.length(); ++i) {

            min = -1;
            max = pattern.length();

            end = pattern.length() - 1;

            while (max - min > 1) {
                mid = (max + min) / 2;

                if (sHash.getHashLong(i, mid + i) == pHash.getHashLong(0, mid)) {
                    min = mid;
                } else {
                    max = mid;
                }
            }

            left = min;

            min = -1;
            max = pattern.length();

            while (max - min > 1) {
                mid = (max + min) / 2;

                if (sHash.getHashLong(mid + i, i + end) == pHash.getHashLong(mid, end)) {
                    max = mid;
                } else {
                    min = mid;
                }
            }

            right = max;

            if (right - left <= 2) return i;
        }

        return -1;
    }
}

class RollingHashLong {

    long[] mArr;
    long[] forwardArr;
    long[] backArr;


    long[] mArr2;
    long[] forwardArr2;
    long[] backArr2;


    int[] requestArr;
    int reqMul, reqMul2;

    long mod, mod2;
    static Random rand = new Random();

    static int addMul = 1_005 + rand.nextInt(100);
    static int addMod = 1_000_016 + 2 * rand.nextInt(100_000);

    // lower case alpha
    public static RollingHashLong getHashFromString(String s, int mul, int mod) {
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            arr[i] = s.charAt(i) - 'a';
        }

        return new RollingHashLong(arr, mul, mod);
    }

    // zero indexex
    public RollingHashLong(int[] arr, int mul, int mod) {

        long cHash = 0;
        long mHash = 1;

        mArr = new long[arr.length + 1];
        forwardArr = new long[arr.length];
        backArr = new long[arr.length];

        this.mod = mod;
        this.requestArr = arr;
        this.reqMul = mul;

        mArr[0] = 1;

        for (int i = 0; i < arr.length; ++i) {
            cHash *= mul;
            cHash += arr[i];
            cHash %= mod;

            forwardArr[i] = cHash;

            mHash *= mul;
            mHash %= mod;

            mArr[i + 1] = mHash;
        }

        cHash = 0;

        for (int i = arr.length - 1; i >= 0; --i) {
            cHash *= mul;
            cHash += arr[i];
            cHash %= mod;

            backArr[i] = cHash;
        }

        cHash = 0;
        mHash = 1;

        mArr2 = new long[arr.length + 1];
        forwardArr2 = new long[arr.length];
        backArr2 = new long[arr.length];

        this.mod2 = mod + addMod;
        this.reqMul2 = mul + addMul;
        int mul2 = reqMul2;

        mArr2[0] = 1;

        for (int i = 0; i < arr.length; ++i) {
            cHash *= mul2;
            cHash += arr[i];
            cHash %= mod2;

            forwardArr2[i] = cHash;

            mHash *= mul2;
            mHash %= mod2;

            mArr2[i + 1] = mHash;
        }

        cHash = 0;

        for (int i = arr.length - 1; i >= 0; --i) {
            cHash *= mul2;
            cHash += arr[i];
            cHash %= mod2;

            backArr2[i] = cHash;
        }
    }

    public long getHashLong(int from, int to) {
        long hash = getHash(from, to, forwardArr, backArr, mArr, mod);
        hash *= mod2;
        hash += getHash(from, to, forwardArr2, backArr2, mArr2, mod2);
        return hash;
    }

    private long getHash(int from, int to, long[] forwardArr, long[] backArr, long[] mArr, long mod) {

        long result;
        int prev;

        if (to >= from) {
            result = forwardArr[to];
            prev = from - 1;

            long sub = prev == -1 ? 0 : forwardArr[prev];
            sub *= mArr[to - prev];
            sub %= mod;

            result += mod;
            result -= sub;
            result %= mod;
        } else {
            result = backArr[to];
            prev = from + 1;

            long sub = prev == backArr.length ? 0 : backArr[prev];
            sub *= mArr[prev - to];
            sub %= mod;

            result += mod;
            result -= sub;
            result %= mod;
        }

        return result;
    }
}