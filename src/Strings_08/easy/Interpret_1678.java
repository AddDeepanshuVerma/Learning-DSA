package Strings_08.easy;

class Interpret_1678 {
    public static void main(String[] args) {
        System.out.println(interpret("G()()()()(al)"));
    }
    public static String interpret(String command) {
        return command.replace("()", "o")
                .replace("(al)", "al");
    }
}