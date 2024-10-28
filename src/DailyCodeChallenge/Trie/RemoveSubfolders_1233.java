package DailyCodeChallenge.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RemoveSubfolders_1233 {
    public List<String> removeSubfolders(String[] folder) {
        ArrayList<String> ans = new ArrayList<>();
        // either we need to sort the list or
        // put all given Strings in our Trie and while searching make sure we don't judge based on the word itself
        // hence we need to put check if (temp.isFolder() && i != strArr.length - 1) {

        for (String string : folder) insert(string);

        for (String string : folder) {
            if (!folderSearch(string)) ans.add(string);
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
        for (int i = 0; i < strArr.length; i++) {
            String st = strArr[i];
            if (!temp.contains(st)) return false;
            temp = temp.get(st);
            if (temp.isFolder() && i != strArr.length - 1) {
                return true;
            }
        }
        return false;
    }

}