package _11_BackTracking.Algo1;

public class demo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("552");
        System.out.println("sb.hashCode() = " + sb.hashCode());
        appendSomething(sb);
        System.out.println("sb.hashCode() = " + sb.hashCode());
    }

    private static void appendSomething(StringBuilder sb234) {
        sb234.append("12");
        System.out.println("sb234.hashCode() = " + sb234.hashCode());
    }
}
