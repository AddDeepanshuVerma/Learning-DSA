package DailyCodeChallenge;

class MinOperations_1598 {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String str : logs) {
            if (str.charAt(1) == '.') {
                count = Math.max(--count, 0);
            } else if (str.charAt(0) != '.') count++;
        }
        return count;
    }


    // public int minOperations(String[] logs) {
    //     int count = 0;
    //     for(String str : logs){
    //         if(str.equals("../")) count =  Math.max(--count, 0);
    //         else if(!str.equals("./") ) count++;
    //     }
    //     return count;
    // }
}