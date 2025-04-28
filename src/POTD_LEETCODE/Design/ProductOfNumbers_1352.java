package POTD_LEETCODE.Design;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers_1352 {
    List<Integer> list;

    public ProductOfNumbers_1352() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int len = list.size() - 1, product = 1;
        while (k-- > 0) product *= list.get(len--);
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */