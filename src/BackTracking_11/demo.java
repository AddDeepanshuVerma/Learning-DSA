package BackTracking_11;

public class demo {
    public static void main(String[] args) {
        String str = "552";
        StringBuilder sb = new StringBuilder("str");
        System.out.println(sb);
        appendSomething(str.toCharArray(), sb);
        System.out.println(sb);
    }

    private static void appendSomething(char[] arr, StringBuilder sb234) {

        arr = new char[]{'z', 'f'};
        sb234.append("12");
    }
}
