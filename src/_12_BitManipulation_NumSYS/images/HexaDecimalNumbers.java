package _12_BitManipulation_NumSYS.images;

public class HexaDecimalNumbers {
    public static void main(String[] args) {
        int temp = 0x5;
        System.out.println("str = " + Integer.toBinaryString(temp));
        int temp_ = 0x55555555;
        printValues(temp_);

        int temp2 = 0xa;
        System.out.println("str = " + Integer.toBinaryString(temp2));
        int temp_2 = 0xaaaaaaaa;
        printValues(temp_2);

        int temp3 = 0x7;
        System.out.println("str = " + Integer.toBinaryString(temp3));
        int temp_3 = 0x77777777;
        printValues(temp_3);

        int temp4 = 0xf;
        System.out.println("str = " + Integer.toBinaryString(temp4));
        int temp_4 = 0xffffffff;
        printValues(temp_4);


    }

    private static void printValues(int temp) {
        String str = Integer.toBinaryString(temp);
        System.out.println("str = " + str);
        System.out.println("str.length() = " + str.length());
        System.out.println("value = " + temp);
        System.out.println();
    }
}
