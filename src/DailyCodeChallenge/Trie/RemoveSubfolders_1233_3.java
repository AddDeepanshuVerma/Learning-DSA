package DailyCodeChallenge.Trie;

import java.util.*;

class RemoveSubfolders_1233_3 {
    ArrayList<String> ans = new ArrayList<>();
    private final Node root = new Node();

    public List<String> removeSubfolders(String[] folder) {
        // add all folder name to the Trie
        for (String string : folder) insert(string);

        // run a dfs and as find all path sum till that path does not reach a word
        dfs(root, new StringBuilder());
//        dfs(root, "");
        return ans;
    }


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
        String[] strArr = s.substring(1).split("/"); // first element will be / hence starting from 1
        Node temp = root;
        for (String st : strArr) {
            if (!temp.contains(st)) temp.put(st);
            temp = temp.get(st);
            if (temp.isFolder) break;
        }
        temp.setFolder(true);
    }

    private void dfs(Node node, StringBuilder str) {
        if (node.isFolder) {
            ans.add(str.toString());
            return;
        }

        for (String key : node.child.keySet()) {
            int tempLength = str.length();
            str.append("/").append(key);
            dfs(node.child.get(key), str);
            str.setLength(tempLength);
        }
    }

    public void dfs(Node node, String str) {
        if (node.isFolder) {
            // break as soon as we find the first isWord==true
            ans.add(str);
            return;
        }
        for (String key : node.child.keySet()) {
            // repeat for all children maintaining path encountered till now
            dfs(node.child.get(key), str + "/" + key);
        }
        return;
    }

}