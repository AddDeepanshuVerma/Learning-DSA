package Random;

import jdk.jfr.Description;

public class ContigeousSubArray {
    public static void main(String[] args) {
        int[] num = {-1,2,9};
        printSubArray(num);
    }

    /*
    The outer loop iterates as many times as the array has elements,this is correct.
    The first inner loop should use the index of the outer loop as start index (int j = i),
    otherwise you always start with the first element.
    And then change the inner loop break condition to k <= j, otherwise i does not print the last element.
    */
    static void printSubArray(int[] num) {
        if (true) {
            for (int i = 0; i < num.length; i++) {
                // j is the number of elements which should be printed
                for (int j = i; j < num.length; j++) {
                    // print the array from i to j
                    for (int k = i; k <= j; k++) {
                        System.out.print(num[k]);
                    }
                    System.out.println();
                }
            }


            if (false) {
                for (int j = 0; j < num.length; j++) {
                    // print the array from i to j
                    for (int k = 0; k <= j; k++) {
                        System.out.print(num[k]);
                    }
                    System.out.println();
                }
            }


        }
    }
}
