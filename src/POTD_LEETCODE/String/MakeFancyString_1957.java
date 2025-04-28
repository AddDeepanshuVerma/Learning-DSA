package POTD_LEETCODE.String;

class MakeFancyString_1957 {
    public String makeFancyString(String s) {
        if(s.length() < 3) return s;

        char[] arr = s.toCharArray();
        StringBuilder str = new StringBuilder();

        char pPrev = arr[0];
        char prev = arr[1];
        str.append(pPrev).append(prev);

        for(int i = 2; i < arr.length; i++){
            if(arr[i] != pPrev || arr[i] != prev){
                str.append(arr[i]);
                pPrev = prev;
                prev = arr[i];
            }

        }
        
        return str.toString();
    }
}