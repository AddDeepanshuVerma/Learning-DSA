package POTD_LEETCODE.Level_2;

import java.util.Arrays;
import java.util.Scanner;

class FractionAddition_592 {
    public static void main(String[] args) {
        /*String str = "-1/2+1/2+1/3";
        String[] split = str.split("/|(?=[+-])");
        Iterator<String> iterator = Arrays.stream(split).iterator();
        while (iterator.hasNext()) {
            String next1 = iterator.next();
            System.out.println("next1 = " + next1);
            String next2 = iterator.next();
            System.out.println("next2 = " + next2);

        }
        System.out.println("split = " + Arrays.toString(split));*/

        String st = "-1/2+1/2+1/3";
        st = st.replace("-", "+-");
        String[] split = st.split("\\+");
        System.out.println("split = " + Arrays.toString(split));

//        FractionAddition_592 obj = new FractionAddition_592();
//        System.out.println("fractionAddition = " + obj.fractionAddition("-1/2+1/2+1/3"));
    }

    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[+-])");
        int A = 0;
        int B = 1;

        // Init: A / B = 0 / 1
        // A / B + a / b = (Ab + aB) / Bb
        // So, in each round, set A = Ab + aB, B = Bb.
        while (sc.hasNext()) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            A = A * b + a * B;
            B *= b;
            final int g = gcd(A, B);
            A /= g;
            B /= g;
        }

        return A + "/" + B;
    }

    private int gcd(int a, int b) {
        return a == 0 ? Math.abs(b) : gcd(b % a, a);
    }
}