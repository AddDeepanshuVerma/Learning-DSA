package DailyCodeChallenge.level_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class LargestNumber_179 {
    public static void main(String[] args) {
        String a = "10";
        String b = "2";
        System.out.println(a.compareTo(b));

        LargestNumber_179 obj = new LargestNumber_179();
        int[] nums2 = {3, 30, 34, 5, 9};
        int[] nums = {10, 2};
        System.out.println(obj.largestNumber3(nums2));
    }

    public String largestNumber3(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            str[i] = nums[i] + "";

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        String join = String.join("", str);

        while (join.length() > 1 && join.charAt(0) == '0') {
            join = join.substring(1);
        }
        return join;
    }


    public String largestNumber2(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort((a, b) -> ("" + b + a).compareTo("" + a + b));

        StringBuilder sb = new StringBuilder();
        for (Integer num : list)
            sb.append(num);

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public String largestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort((a, b) -> ("" + b + a).compareTo("" + a + b));

        StringBuilder sb = new StringBuilder();
        for (Integer num : list) sb.append(num);

        String res = sb.toString();
        if (checkAllZeros(res.toCharArray())) return "0";
        return res;
    }

    private boolean checkAllZeros(char[] arr) {
        for (char c : arr) {
            if (c != '0') {
                return false;
            }
        }
        return true;
    }

}