package Contest.Weekly_Contest._421;

public class Q1 {
    public static void main(String[] args) {
        Q1 obj = new Q1();
        String s = "abcyy";
        int t = 2;
        System.out.println(obj.transformedLength2(s, t)); // Example usage
        System.out.println(obj.transformedLength(s, t)); // Example usage
    }

    public int transformedLength(String s, int t) {
        final int MOD = 1_000_000_007;
        long length = s.length();

        for (int i = 0; i < t; i++) {
            long newLength = 0;
            for (char c : s.toCharArray()) {
                if (c == 'z') {
                    newLength += 2; // 'z' becomes "ab"
                } else {
                    newLength += 1; // Other characters remain 1
                }
            }
            length = newLength % MOD;
            // Update s for the next transformation
            StringBuilder newString = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == 'z') {
                    newString.append("ab");
                } else {
                    newString.append((char) (c + 1)); // Move to the next character
                }
            }
            s = newString.toString();
        }

        return (int) length;
    }

    public int transformedLength2(String s, int t) {
        final int MOD = 1_000_000_007;
        long length = s.length();
        long countZ = 0;
        long countY = 0;

        // Count initial 'z's and 'y's
        for (char c : s.toCharArray()) {
            if (c == 'z') {
                countZ++;
            } else if (c == 'y') {
                countY++;
            }
        }

        // Apply transformations
        for (int i = 0; i < t; i++) {
            // Each 'z' produces one new character (2 characters: "ab")
            length = (length + countZ) % MOD;
            // All 'y's become 'z's in the next transformation
            countZ += countY; // Convert all 'y's to 'z's
            countY = 0; // Reset countY since all 'y' have been converted
        }

        return (int) length;
    }

}
