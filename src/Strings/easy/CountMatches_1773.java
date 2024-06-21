package Strings.easy;

import java.util.List;

class CountMatches_1773 {
    public static void main(String[] args) {
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int val = 0;
        switch (ruleKey) {
            case "color" -> val = 1;
            case "name" -> val = 2;
        }
        final int index = val;
        return (int) items.stream().filter(item -> item.get(index).equals(ruleValue)).count();
    }

    public static int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int val = 0;
        switch (ruleKey) {
            case "color" -> val = 1;
            case "name" -> val = 2;
        }
        int count = 0;
        for (List<String> item : items) {
            if (item.get(val).equals(ruleValue)) count++;
        }
        return count;
    }
}