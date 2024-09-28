package DailyCodeChallenge.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyCircularDeque q = new MyCircularDeque(4);
        /*System.out.println(q.insertLast(1));  // return True
        System.out.println(q.insertLast(2));  // return True
        System.out.println(q.insertFront(3)); // return True
        System.out.println(q.insertFront(4)); // return False, the queue is full.
        System.out.println(q.getRear());      // return 2
        System.out.println(q.isFull());       // return True
        q.printQueue();       // return True
        System.out.println(q.deleteLast());   // return True
        q.printQueue();       // return True
        System.out.println(q.insertFront(4)); // return True
        q.printQueue();
        System.out.println(q.getFront());     // return 4*/

        System.out.println(q.insertFront(9));
        System.out.println(q.deleteLast());
        System.out.println(q.getRear());
        System.out.println(q.getFront());
        System.out.println(q.getFront());
        System.out.println(q.deleteFront());
        System.out.println(q.insertFront(6));
        System.out.println(q.insertLast(5));
        System.out.println(q.insertFront(9));
        System.out.println(q.getFront());
        System.out.println(q.insertFront(6));
        q.printQueue();

    }
}
