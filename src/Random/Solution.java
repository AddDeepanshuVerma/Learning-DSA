package Random;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        return new AbstractList<List<Integer>>() {
            private List<List<Integer>> resList;
            private void onload() {
                resList = new ArrayList<>();
                int[] numbers = arr;
                Arrays.sort(numbers);
                int minDiff = Integer.MAX_VALUE;

                for (int i = 0; i < numbers.length - 1; i++) {
                    int diff = numbers[i + 1] - numbers[i];
                    if (diff < minDiff) {
                        minDiff = diff;
                    }
                }

                for (int i = 0; i < numbers.length - 1; i++) {
                    int diff = numbers[i + 1] - numbers[i];
                    if (diff == minDiff) {
                        resList.add(Arrays.asList(numbers[i], numbers[i + 1]));
                    }
                }
            }

            private void init() {
                if (null == resList) {
                    onload();
                    System.gc();
                }
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return resList.get(index);
            }

            @Override
            public int size() {
                init();
                return resList.size();
            }

        };
    }
}