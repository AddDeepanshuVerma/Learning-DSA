package DailyCodeChallenge.Level_2;

import java.util.PriorityQueue;

class KthLargest {
    public static void main(String[] args) {
        int size  = 3;
        int[] arr = {4,5,8,2};
        KthLargest obj = new KthLargest(size, arr);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }

    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private final int queueSize;

    public KthLargest(int k, int[] nums) {
        queueSize = k;
        for (int num : nums) addInQueue(num);
        System.out.println(queue);
    }

    private void addInQueue( int num) {
        queue.add(num);
        if (queue.size() > queueSize) queue.poll();
    }

    public int add(int val) {
        addInQueue(val);
        return !queue.isEmpty() ? queue.peek() : -1;
    }

}