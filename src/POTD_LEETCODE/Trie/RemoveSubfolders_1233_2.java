package POTD_LEETCODE.Trie;

import java.util.*;

class RemoveSubfolders_1233_2 {
    public List<String> removeSubfolders(String[] folder) {
        ArrayList<String> ans = new ArrayList<>();
        // Here we first sorted the list lexicographically
        // sort the list so-that short folders gets added first
        Arrays.sort(folder, (a, b) -> (a + b).compareTo(b + a));

        for (String string : folder) {
            if (!folderSearch(string)) {
                ans.add(string);
            }
            insert(string);
        }
        return ans;
    }

    private final Node root = new Node();

    static class Node {
        boolean isFolder;
        Map<String, Node> child = new HashMap<>();

        public boolean contains(String st) {
            return child.containsKey(st);
        }


        public void put(String st) {
            child.put(st, new Node());
        }

        public Node get(String st) {
            return child.get(st);
        }

        public void setFolder(boolean flag) {
            isFolder = flag;
        }

        public boolean isFolder() {
            return isFolder;
        }
    }

    private void insert(String s) {
        String[] strArr = s.split("/");
        Node temp = root;
        for (String st : strArr) {
            if (!temp.contains(st)) temp.put(st);
            temp = temp.get(st);
        }
        temp.setFolder(true);
    }

    private boolean folderSearch(String s) {
        String[] strArr = s.split("/");

        Node temp = root;
        for (String st : strArr) {
            if (!temp.contains(st)) return false;
            temp = temp.get(st);
            if (temp.isFolder()) return true;
        }
        return temp.isFolder;
    }

}