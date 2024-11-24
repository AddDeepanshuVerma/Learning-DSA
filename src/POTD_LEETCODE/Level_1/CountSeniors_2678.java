package POTD_LEETCODE.Level_1;

import java.util.Arrays;

class CountSeniors_2678 {

    public int countSeniors4(String[] details) {
        return (int) Arrays.stream(details)
                           .mapToInt(n -> Integer.parseInt(n.substring(11, 13)))
                           .filter(age -> age > 60)
                           .count();
    }

    public int countSeniors3(String[] details) {
        return (int) Arrays.stream(details).filter(str -> Integer.parseInt(str.substring(11, 13)) > 60).count();
    }

    public int countSeniors(String[] details) {
        int count = 0;
        for(String str : details){
            int age = Integer.parseInt(str.substring(11,13));
            if(age > 60) count++;
        }
        return count;
    }

    public int countSeniors2(String[] details) {
        int count = 0;
        for(String str : details){
            String temp = "" + str.charAt(11) + str.charAt(12);
            int age = Integer.parseInt(temp);
            if(age > 60) count++;
        }
        return count;
    }
}