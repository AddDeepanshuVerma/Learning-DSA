package _16_stack_queue.medium;

import jdk.jfr.Description;

class MinAddToMakeValid_921 {
    public static void main(String[] args) {
        MinAddToMakeValid_921 obj = new MinAddToMakeValid_921();
        System.out.println(obj.minAddToMakeValid2("())"));
    }

    //    "()))(("
    @Description("incorrect")
    public int minAddToMakeValid(String s) {
        int count = 0;
        for (char c : s.toCharArray())
            if (c == '(') count++;
            else count--;
        return Math.abs(count);
    }

    @Description("Working")
    public int minAddToMakeValid2(String s) {
        int countClose = 0;
        int countOpen = 0;
        for (char c : s.toCharArray())
            if (c == '(') countOpen++;
            else {
                if (countOpen > 0) {
                    countOpen--;
                } else {
                    countClose++;
                }
            }

        return countOpen + countClose;
    }

    @Description("less lines of code")
    public int minAddToMakeValid3(String s) {
        int close = 0, open = 0;
        for (char c : s.toCharArray())
            if (c == '(') open++;
            else if (open > 0) open--;
            else close++;
        return open + close;
    }
}