package Random;

import jdk.jfr.Description;

import java.util.Arrays;
import java.util.Scanner;

public class Extras {
    public static void main(String[] args) throws InterruptedException {
//        addTwoNumbers();
//        multiplicationTable();
//        findHCFAndGCD();

        System.out.print("Enter 2 numbers : ");
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        System.out.println("HCF is : " + HCF(A,B));
        System.out.println("LCM is : " + LCM(A,B));
//
//        Long A1 = in.nextLong();
//        Long B1 = in.nextLong();
//        System.out.println(Arrays.toString(lcmAndGcd(A1, B1)));
//
//        takeInput();
    }

    private static void takeInput() {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        String str = "0";
        while (true){
            System.out.print("Enter a number : ");
            str = in.next();
            if(str.equalsIgnoreCase("X")) break;
            sum += Integer.parseInt(str);
        }
        System.out.println("Sum of all entered number is : " +sum);
    }

    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        Long[] i = new Long[2];
        Long multiple = A*B;
        while(A>0 && B>0){
            if(A>B) A=A%B; else B=B%A;
            System.out.println("Value of A = "+A+" and value of B = "+B);
        }
        if(A==0) i[1] = B; else i[1] = A;
        i[0]= multiple/i[1];
        return i;
    }
    private static int LCM(int A, int B) {
        return (A*B)/HCF(A,B);
    }

//    a x b = LCM(a, b) * GCD (a, b)
    private static int HCF(int A, int B) {
//        int min = Math.min(A, B);
//        for (int i = min; i > 2; i--) {
//            if (A % i == 0 && B % i == 0) return i;
//        }
//        return 1;
        while(A>0 && B>0){
            if(A>B) A=A%B; else B=B%A;
        }
        if(A==0) return B; else return A;
    }

    private static void findHCFAndGCD() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 2 numbers : ");
        int A = in.nextInt();
        int B = in.nextInt();
        int min = Math.min(A, B);
        boolean flag = true;
        for (int i = min; i > 1; i--) {
            if (A % i == 0 && B % i == 0) {
                System.out.println("The HCF of given 2 numbers is : " + i);
                flag = false;
                return;
            } else {
                System.out.println("HCF of these two number " + A + " & " + B + " is not " + i);
            }
        }
        if (flag) {
            System.out.println("The HCF of given 2 numbers is only 1");
        }
    }

    private static void addTwoNumbers() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two numbers : ");
        int i = in.nextInt();
        int j = in.nextInt();
        System.out.println(i + j);

    }

    private static void multiplicationTable() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number for multiplication : ");
        int num = in.nextInt();
        int temp = num;
        for (int j = 1; j <= 10; j++) {
            System.out.println(temp + " x "+ j + " = " + num * j);
            Thread.sleep(400);
        }
    }
}