package POTD_LEETCODE.Design;

import java.util.HashMap;
import java.util.TreeSet;

class NumberContainers_2349 {
    HashMap<Integer, Integer> indexNumber;
    HashMap<Integer, TreeSet<Integer>> numberIndexes;

    public static void main(String[] args) {
        NumberContainers_2349 obj = new NumberContainers_2349();

    }

    public NumberContainers_2349() {
        indexNumber = new HashMap<>();
        numberIndexes = new HashMap<>();
    }

    public void change(int index, int number) {
        if (!indexNumber.containsKey(index)) {
            indexNumber.put(index, number);
            numberIndexes.computeIfAbsent(number, val -> new TreeSet<>()).add(index);
        } else {
            int prevNum = indexNumber.get(index);
            numberIndexes.get(prevNum).remove(index);

            indexNumber.put(index, number);
            numberIndexes.computeIfAbsent(number, val -> new TreeSet<>()).add(index);
        }
    }

    public int find(int number) {
        if (numberIndexes.containsKey(number)) {
            TreeSet<Integer> set = numberIndexes.get(number);
            return !set.isEmpty() ? set.getFirst() : -1;
        } else return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */