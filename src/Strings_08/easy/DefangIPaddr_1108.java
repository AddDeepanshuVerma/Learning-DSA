package Strings_08.easy;

class DefangIPaddr_1108 {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("255.100.50.0"));
    }
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
//        return address.replaceAll("\\.", "[.]");
    }
}