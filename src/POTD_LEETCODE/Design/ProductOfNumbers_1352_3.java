package POTD_LEETCODE.Design;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers_1352_3 {
    public static void main(String[] args) {
        ProductOfNumbers_1352_3 productOfNumbers = new ProductOfNumbers_1352_3();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }

    List<Integer> list;
    int prod, size;

    public ProductOfNumbers_1352_3() {
        setDefault();
    }

    private void setDefault() {
        list = new ArrayList<>();
        size = 0;
        prod = 1;
    }

    public void add(int num) {
        if (num == 0) {
            setDefault();
        } else {
            prod *= num;
            list.add(prod);
            size++;
        }
    }

    public int getProduct(int k) {
        if (size < k) return 0;
        return size == k ? prod : prod / list.get(size - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */