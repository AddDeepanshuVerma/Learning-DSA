package _13_Maths.Medium;

public class minimumPushes_3014 {
    public int minimumPushes(String word) {
        int ans = 0;
        int n = word.length();

        int row = 1;
        int quotient = n / 8;
        int remainder = n % 8;

        while (quotient > 0) {
            ans += 8 * row;
            quotient--;
            row++;
        }

        ans += remainder * row;
        return ans;
    }


    public int minimumPushes2(String word) {
        int n = word.length();
        if (n <= 8) return n;
        else if (n > 8 && n <= 16) return 8 + (n - 8) * 2;
        else if (n > 16 && n <= 24) return 24 + (n - 16) * 3;
            // else if( n > 24 ) return 48 + (n - 24) * 4;
        else return 48 + (n - 24) * 4;
    }
}