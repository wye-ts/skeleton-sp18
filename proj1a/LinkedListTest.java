public class LinkedListTest {
    public static void main (String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<Integer>();
        deque.print();
        deque.addLast(5);
        System.out.println(deque.getLast());
        System.out.println("Size: " + deque.size());
        deque.print();
        deque.addLast(10);
        System.out.println(deque.getLast());
        System.out.println("Size: " + deque.size());
        deque.print();
        deque.addLast(15);
        System.out.println(deque.getLast());
        System.out.println("Size: " + deque.size());
        System.out.println("GEt first: expected: 5 actual: " + deque.getFirst());
        deque.print();
        deque.addFirst(1);
        System.out.println("GEt first: expected: 1 actual: " + deque.getFirst());
        System.out.println("Size: " + deque.size());
        deque.print();

//        removeLast() Test
//        deque.removeLast();
//        deque.print();
//        deque.removeLast();
//        deque.print();
//        deque.removeLast();
//        deque.print();
//        deque.removeLast();
//        deque.print();
//        deque.removeLast();
//        deque.print();
//        deque.removeLast();
//        deque.print();

        // removeFirst() Test
//        deque.removeFirst();
//        deque.print();
//        deque.removeFirst();
//        deque.print();
//        deque.removeFirst();
//        deque.print();
//        deque.removeFirst();
//        deque.print();
//        deque.removeFirst();
//        deque.print();
//        deque.removeFirst();
//        deque.print();

        // Mix Test
        deque.removeFirst();
        deque.print();
        deque.removeLast();
        deque.print();
        deque.removeFirst();
        deque.print();
        System.out.println("Size: " + deque.size());
        deque.removeLast();
        deque.print();
        System.out.println("Size: " + deque.size());


        deque.addLast(4);
        System.out.println(deque.getLast());
        System.out.println("Size: " + deque.size());
        deque.print();
        deque.addLast(9);
        System.out.println(deque.getLast());
        System.out.println("Size: " + deque.size());
        deque.print();
        deque.addLast(6);
        System.out.println(deque.getLast());
        System.out.println("Size: " + deque.size());
        System.out.println("GEt first: expected: 4 actual: " + deque.getFirst());
        deque.print();
        deque.addFirst(100);
        deque.print();
    }
}