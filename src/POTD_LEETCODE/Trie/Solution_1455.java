package POTD_LEETCODE.Trie;

class Solution_1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].indexOf(searchWord) == 0) return i + 1;
        }
        return -1;
    }
}