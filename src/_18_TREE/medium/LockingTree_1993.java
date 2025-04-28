package _18_TREE.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Bruteforce or Naive whatever, IT IS WORKING AND WAS DONE IN A SINGLE GO & NO ERRORS WERE FOUND <3
class LockingTree_1993 {
    private final HashMap<Integer, Integer> childToParent;
    private final HashMap<Integer, HashSet<Integer>> parentToChild;
    private final HashMap<Integer, Integer> lockedNodes; //{nodes, locked by user}

    //[-1,0,0,1,1,2,2] for nodes : 0 1 2 3 4 5 6
    public LockingTree_1993(int[] parent) {
        childToParent = new HashMap<>();
        parentToChild = new HashMap<>();
        lockedNodes = new HashMap<>();

        // create childToParent relationship
        childToParent(childToParent, parent);

        // create parentToChild relationship
        parentToChild(parentToChild, parent);

    }

    private void parentToChild(HashMap<Integer, HashSet<Integer>> parentToChild, int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parentToChild.computeIfAbsent(parent[i], list -> new HashSet<>()).add(i);
            // need to check again for -1 being the parent of root
        }
    }

    private void childToParent(HashMap<Integer, Integer> childToParent, int[] parent) {
        for (int i = 1; i < parent.length; i++) {
            childToParent.put(i, parent[i]);
            // need to check again for root node parent being -1
        }
    }

    public boolean lock(int num, int user) {
        if (lockedNodes.containsKey(num)) {
            return false;
        }

        lockedNodes.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lockedNodes.containsKey(num) && lockedNodes.get(num) == user) {
            lockedNodes.remove(num);
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        /* Check below 3 conditions first
         * The node is unlocked,
         * It has at least one locked descendant (by any user), and
         * It does not have any locked ancestors.*/
        if (lockedNodes.containsKey(num)) return false;

        List<Integer> lockedDesc = listOfLockedDescendant(num);
        if (lockedDesc.isEmpty()) return false;

        List<Integer> lockedAnce = listOfLockedAncestors(num);
        if (!lockedAnce.isEmpty()) return false;

        // ALL THREE CONDITIONS ARE FULFILLED HENCE WE CAN MOVE FORWARD

        /* make all locked descendant unlocked
         * make given num locked by given user from parameter*/

        for (int key : lockedDesc) {
            lockedNodes.remove(key);
        }
        lockedNodes.put(num, user);
        return true;
    }

    private List<Integer> listOfLockedAncestors(int num) {
        int parent = -1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (childToParent.containsKey(num)) {
            parent = childToParent.get(num);
            if (lockedNodes.containsKey(parent)) {
                ans.add(parent);
            }
            num = parent;
        }
        return ans;
    }

    private List<Integer> listOfLockedDescendant(int num) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int child : parentToChild.getOrDefault(num, new HashSet<>()))
            dfs(child, ans);
        return ans;
    }

    private void dfs(int curr, ArrayList<Integer> ans) {
        if (lockedNodes.containsKey(curr)) ans.add(curr);

        for (int child : parentToChild.getOrDefault(curr, new HashSet<>())) {
            dfs(child, ans);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */