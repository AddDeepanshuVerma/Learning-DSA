package _19_TRIE.hard;

import java.util.ArrayList;
import java.util.*;

class Node {
    Node[] links = new Node[2];

    public Node() {
    }

    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    Node get(int ind) {
        return links[ind];
    }

    void put(int ind, Node node) {
        links[ind] = node;
    }
}

class Trie {
    private static Node root;

    //Initialize your data structure here

    Trie() {
        root = new Node();
    }

    //Inserts a word into the trie

    public static void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
};

public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        int m = queries.size();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(queries.get(i).get(1));
            temp.add(queries.get(i).get(0));
            temp.add(i);
            offlineQueries.add(temp);
        }
        offlineQueries.sort((a, b) -> a.getFirst() - b.getFirst());

        int indx = 0;
        int n = arr.size();
        Trie trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<Integer>(m);

        for (int i = 0; i < m; i++) ans.add(-1);

        for (int i = 0; i < m; i++) {
            int upto = offlineQueries.get(i).get(0);
            int find = offlineQueries.get(i).get(1);
            int qIdx = offlineQueries.get(i).get(2);
            while (indx < n && arr.get(indx) <= upto) {
                trie.insert(arr.get(indx));
                indx++;
            }
            ans.set(qIdx, indx == 0 ? -1 : trie.getMax(find));
        }
        return ans;
    }
}