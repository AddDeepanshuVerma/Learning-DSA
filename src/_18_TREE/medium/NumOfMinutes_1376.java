package _18_TREE.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class NumOfMinutes_1376 {
    int max;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        /*
         * First lets create manager -> List<emp> mapping
         * Then simply do a BFS or DFS and while storing max minutes in a global variable
         * while traversing we need to know that it takes 0 min for headId to get the info
         * and further as per informTime array data
         * */

        HashMap<Integer, List<Integer>> managerToEmp = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            int emp = i;
            int mngr = manager[i];
            managerToEmp.computeIfAbsent(mngr, val -> new ArrayList<>()).add(emp);
            // one manager has multiple employees
            // here we could also put a check for headId's manager being -1 then don't store that
        }
        max = 0;
//        BFS(headID, managerToEmp, informTime);
        DFS(headID, 0, managerToEmp, informTime);

        return max;

    }

    private void DFS(int root, int currTime, HashMap<Integer, List<Integer>> managerToEmp, int[] informTime) {
        max = Math.max(max, currTime);

        for (int emp : managerToEmp.getOrDefault(root, new ArrayList<>())) {
            DFS(emp, currTime + informTime[root], managerToEmp, informTime);
        }
    }

    private void BFS(int headID, HashMap<Integer, List<Integer>> managerToEmp, int[] informTime) {
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        // no need to put visited as it is an up to bottom structure
        q.add(new Pair(headID, 0));

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int root = poll.root;
            int time = poll.time;
            max = Math.max(max, time);

            for (int emp : managerToEmp.getOrDefault(root, new ArrayList<>())) {
                q.add(new Pair(emp, time + informTime[root]));
            }
        }
    }

    record Pair(int root, int time) {
    }
}