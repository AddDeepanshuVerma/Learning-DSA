package _13_Maths.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GetPermutation_60 {
    public static void main(String[] args) {
        GetPermutation_60 obj = new GetPermutation_60();
        System.out.println(obj.getPermutation(9, 278893));
    }
    List<String> list;

    public String getPermutation(int n, int k) {
        list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= n; i++) str.append(i);
        solve(str.toString(), "");
        System.out.println("list = " + list);
        Collections.sort(list);
//        list.sort(String::compareTo);
        System.out.println("list = " + list);
        return list.get(k - 1);
    }

    private void solve(String ip, String op) {
        if (ip.isEmpty()) list.add(op);
        else for (int i = 0; i < ip.length(); i++) {
            String newIp = ip.substring(0, i) + ip.substring(i + 1);
            String newOp = op + ip.charAt(i);
            solve(newIp, newOp);
        }
    }
}