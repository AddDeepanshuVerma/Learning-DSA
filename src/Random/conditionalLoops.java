package Random;

import java.util.Arrays;
import java.util.Scanner;

public class conditionalLoops {
    public static void main(String[] args) {
//        [Subtract the Product and Sum of Digits of an Integer]
//        productAndSumOfDigits();
//        Input a number and print all the factors of that number (use loops).
//        factors();
//        Take integer inputs till the user enters 0 and print the sum of all numbers
//        takeInpt();
//        Take integer inputs till the user enters 0 and print the largest number from all.
//        printLargest();
//        Perfect Number In Java
        perfectNumber();


    }

    private static void perfectNumber() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = 1; 2 * i <= num; i++) {
            count++;
            if (num % i == 0) {
                sum += i;
                if (sum > num) {
                    System.out.println("Broke the loop at value : " + i + " as sum : " + sum);
                    break;
                }
            }

        }
        System.out.println("loop ran : " + count + " times");
        System.out.println(sum == num);

    }

    private static void printLargest() {
        Scanner in = new Scanner(System.in);
        int big = 0;
        int i = 0;
        do {
            big = Math.max(big, i);
            i = in.nextInt();
        } while (i != 0);
        System.out.println(big);
    }

    private static void takeInpt() {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int i = 0;
        do {
            sum += i;
            i = in.nextInt();
        } while (i != 0);
        System.out.println(sum);
    }

    private static void factors() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine()
                                         .split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        int temp = arr[0];
        for (int j = 1; j <= temp; j++) {
            if (temp % j == 0) System.out.print(j + " ");
        }

    }

    private static void productAndSumOfDigits() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine()
                                         .split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        int temp = arr[0];
        int product = 1;
        int sum = 0;
        while (temp > 0) {
            product *= temp % 10;
            sum += temp % 10;
            temp /= 10;
        }
        System.out.println("productAndSumOfDigits are: " + product + " " + sum);

    }
}
