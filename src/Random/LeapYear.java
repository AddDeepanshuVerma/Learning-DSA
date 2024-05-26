package Random;

import java.util.Scanner;

public class LeapYear {
    static int b = 10;
    public static void main(String[] args) {
//        getLeapYear();
        getLeapYear2();

    }
    private static void getLeapYear2() {
        Scanner in  = new Scanner(System.in);
        int temp = 0 ;
        while(temp!=100){
            System.out.print("Enter a year : ");
            int i = in.nextInt();
            temp = i;
            if((i%4 == 0 && i%100 != 0) || i%400 == 0){
                System.out.println("Enter year : "+temp+ " is a leap year!");
            }else{
                System.out.println("Enter year : "+temp+ " is not a leap year!");
            }
        }
    }

    private static void getLeapYear() {
        Scanner in  = new Scanner(System.in);
        int temp = 0 ;
        while(temp!=100){
            System.out.print("Enter a year : ");
            int i = in.nextInt();
            temp = i;
            while(i%100 == 0){
                i/=100;
            }
            if(i%4 == 0){
                System.out.println("Enter year : "+temp+ " is a leap year!");
            }else{
                System.out.println("Enter year : "+temp+ " is not a leap year!");
            }
        }

    }
}
