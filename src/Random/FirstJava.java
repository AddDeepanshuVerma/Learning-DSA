package Random;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FirstJava {
    public static void main(String[] args) {
//        Write a program to print whether a number is even or odd, also take input from the user.
//        Take name as input and print a greeting message for that particular name.
//        Write a program to input principal, time, and rate(P, T, R) from the user and find Simple Interest.
//        take array from user in single line
//        Take in two numbers and an operator (+, -, *, /) and calculate the value.(Use if conditions)
//        Take 2 numbers as input and print the largest number.
//        Input currency in rupees and output in USD.
//        To calculate Fibonacci Series up to n numbers.
//        To find out whether the given String is Palindrome or not.
//        To find Armstrong Number between two given number.


//        System.out.println(oddEven(5));
//        System.out.println(greetings("Deepanshu"));
//        System.out.println(simpleInterest());
//        takeArrayAsInput();
//        calculator();
//        largestNum();
//        usd();
//        fibonacci();
//        checkPalindrome();
//        findArmstrong();

//         to count the total digits in a number
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        int count = String.valueOf(a).length();
//        System.out.println("count = " + count);
//        check();

    }

    private static void check() {
        String str = Arrays.toString(new int[]{1, 2, 3, 4, 5});
        System.out.println(str);
        String st = String.valueOf(Integer.toString(55));
        System.out.println(st);

//        return str;
    }

    private static boolean isArmstringNumber(long num) {
        long temp = num;
        double sum = 0;
        long count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        temp = num;
        while (temp > 0) {
            sum = sum + Math.pow(temp % 10, count);
            temp /= 10;
        }
        return sum == num;
    }

    private static void findArmstrong() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two numbers : ");
        int[] arr = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = arr[0]; i <= arr[1]; i++) {
            if (isArmstringNumber(i))
                System.out.print(i + " ");
        }


    }


    private static void checkPalindrome() {
        Scanner in = new Scanner(System.in);
//        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        System.out.print("Enter a String : ");
        String str = in.nextLine();
        boolean flag = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                System.out.println("not Palindrome");
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("Palindrome");
    }

    private static void fibonacci() {
        Scanner in = new Scanner(System.in);
        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = array[0];
        n= in.nextInt();
        int first = 0;
        int second = 1;
        int third;
        System.out.print(first + " ");
        System.out.print(second + " ");

        for (int i = 2; i <= n; i++) {
            third = first + second;
            System.out.printf(third + " ");
            first = second;
            second = third;
        }

    }

    private static void usd() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter a number");
        int[] array = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        System.out.printf("%.2f%n", array[0] / 80.2);
    }


    private static void largestNum() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 2 numbers : ");
        int a = Integer.parseInt(in.next());
        int b = Integer.parseInt(in.next());
        System.out.println(Math.max(a, b));

    }


    private static void calculator() {
        Scanner in = new Scanner(System.in);
        int a = 10;
        int b = 20;
        System.out.print("Enter an Operator : ");
        char ch = in.next().charAt(0);
        if (ch == '+') System.out.println(a + b);
        if (ch == '-') System.out.println(a - b);
        if (ch == '*') System.out.println(a * b);
        if (ch == '/') System.out.println(a / b);
        else System.out.println("enter valid character");
    }

    private static void takeArrayAsInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input N numbers split with space: ");
        int[] array = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(array));

        int[] array1;
        array1 = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        /*List<String> list = Arrays.asList("3", "6", "8","14", "15");
        list.stream().mapToInt(Integer::parseInt)
                .filter(num -> num % 3 == 0)
                .forEach(System.out::println);*/
    }

    private static double simpleInterest() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter principal, time, and rate");
        String str = in.nextLine();
        String[] arr = str.split(" ");
        int[] arrCopy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = Integer.valueOf(arr[i]);
        }
        System.out.println(Arrays.toString(arrCopy));


        return 10d;
    }

    private static String greetings(String deepanshu) {
        return "Welcome " + deepanshu;
    }

    private static String oddEven(int N) {
        return (N ^ 1) > N ? "even" : "odd";
        //return (N & 1) == 0 ?"even":"odd";

    }
}
