package DailyCodeChallenge.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RemoveSubfolders_1233_5 {
    ArrayList<String> ans = new ArrayList<>();
    private final Node root = new Node();

    public List<String> removeSubfolders(String[] folder) {
        for (String string : folder)
            insert(string);
        dfs(root, "");
        
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
        String[] strArr = s.split("/");
        Node temp = root;
        for (int i = 1; i < strArr.length; i++) {   // 0'th element will be / hence starting from 1
            if (!temp.contains(strArr[i])) temp.put(strArr[i]);
            temp = temp.get(strArr[i]);
            if (temp.isFolder) break; // no need to add further as they all will be subFolder which will be ignored in our DFS
        }
        temp.setFolder(true);
    }

    private void dfs(Node root, String str) {
        if (root.isFolder) ans.add(str);
        else for (String key : root.child.keySet())
            dfs(root.child.get(key), str + "/" + key);
    }
}