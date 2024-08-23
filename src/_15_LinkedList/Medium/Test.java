package _15_LinkedList.Medium;

public class Test {
    public static void main(String[] args) {
//        MyLinkedList obj = new MyLinkedList();
//        obj.addAtHead(1);
//        obj.addAtTail(3);
//        obj.printLL();
//        obj.addAtIndex(1, 2);       // linked list becomes 1->2->3
//        obj.printLL();
//        System.out.println(obj.get(1));     // return 2
//        obj.deleteAtIndex(1);               // now the linked list is 1->3
//        obj.printLL();
//        System.out.println(obj.get(1));     // return 3

        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(7);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.printLL();
        obj.addAtIndex(3, 0);
        obj.printLL();

        obj.deleteAtIndex(2);
        obj.addAtHead(6);
        obj.addAtTail(4);

        obj.printLL();
        System.out.println("obj.size = " + obj.size);
        System.out.println(obj.get(4)); // print 4
        obj.addAtHead(4);
        obj.addAtIndex(5, 0);
        obj.addAtHead(6);

//                "addAtHead",7
//                "addAtHead",2
//                "addAtHead",1
//                "addAtIndex",3,0
//                "deleteAtIndex",2
//                "addAtHead",6
//                "addAtTail",4
//                "get",4
//                "addAtHead",4
//                "addAtIndex",5,0
//                "addAtHead"6
    }

}
