public class LinkedListDeque<T> {
    private class Node {
        T val;
        Node next;
        Node prev;

        public Node(T val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
            this.prev = null;
        }
    }

    private Node first;
    private int size;

    public LinkedListDeque() {
        this.first = new Node(null, null);
        this.size = 0;
    }

    public void addFirst(T val) {
        Node newFirstNode = new Node(val, this.first.next);
        if (isEmpty()) {
            this.first.next = newFirstNode;
            this.first.prev = newFirstNode;
        }
        else {
            this.first.next.prev = newFirstNode;
            this.first.next = newFirstNode;
        }
        size++;
    }

    public void addLast(T val) {
        Node lastNode = this.first.prev;
        Node newLastNode = new Node(val, null);
        if (lastNode == null) {
            // newNode prev and next are both null if this is the first Node entered
            this.first.prev = newLastNode;
            this.first.next = newLastNode;
        }
        else {
            newLastNode.prev = lastNode;
            lastNode.next = newLastNode;
            this.first.prev = newLastNode;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            return;
        if (size == 1) {
            this.first.next = null;
            this.first.prev = null;
        }
        else {
            Node secondNode = this.first.next.next;
            // Remove the connection with the first node
            if (secondNode != null)
                secondNode.prev = null;
            this.first.next = secondNode;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            return;
        size--;
        Node lastNode = this.first.prev;
        Node prevNode = lastNode.prev;
        // check if it is sentinal node
        if (prevNode == null) {
            this.first.next = null;
            this.first.prev = null;
            return;
        }
        prevNode.next = null;
        this.first.prev = prevNode;
    }

    public T getFirst() {
        if (isEmpty())
            return null;
        return (T) this.first.next.val;
    }

    public T getLast() {
        if (isEmpty())
            return null;
        return (T) this.first.prev.val;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        Node curr = this.first.next;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        if (!isEmpty())
            System.out.println("\nFirst Node Val is: " + getFirst() + " | Last Node Val is: " + getLast());
        else
            System.out.println("No elements in the list");
    }
}

// Two sentinels
//public class LinkedListDeque<T> {
//    private class Node {
//        T val;
//        Node next;
//        Node prev;
//
//        public Node(T val) {
//            this.val = val;
//            this.next = null;
//            this.prev = null;
//        }
//
//        public Node(T val, Node next) {
//            this.val = val;
//            this.next = next;
//            this.prev = null;
//        }
//    }
//
//    private Node first;
//    private Node last;
//    private int size;
//
//    public LinkedListDeque() {
//        this.first = new Node(null, null);
//        this.last = new Node(null, null);
//    }
//
//    public void addFirst(T val) {
//        Node newFirstNode = new Node(val, this.first.next);
//        if (isEmpty()) {
//            this.first.next = newFirstNode;
//            this.last.next = newFirstNode;
//        }
//        else {
//            this.first.next.prev = newFirstNode;
//            this.first.next = newFirstNode;
//        }
//        size++;
//    }
//
//    public void addLast(T val) {
//        Node lastNode = this.last.next;
//        Node newLastNode = new Node(val, null);
//        if (lastNode == null) {
//            // newNode prev and next are both null if this is the first Node entered
//            this.last.next = newLastNode;
//            this.first.next = newLastNode;
//        }
//        else {
//            newLastNode.prev = lastNode;
//            lastNode.next = newLastNode;
//            this.last.next = newLastNode;
//        }
//        size++;
//    }
//
//    public void removeFirst() {
//        if (isEmpty())
//            return;
//        if (size == 1) {
//            this.first.next = null;
//            this.last.next = null;
//        }
//        else {
//            Node secondNode = this.first.next.next;
//            // Remove the connection with the first node
//            if (secondNode != null)
//                secondNode.prev = null;
//            this.first.next = secondNode;
//        }
//        size--;
//    }
//
//    public void removeLast() {
//        if (isEmpty())
//            return;
//        size--;
//        Node lastNode = this.last.next;
//        Node prevNode = lastNode.prev;
//        if (prevNode == null) {
//            this.first.next = null;
//            this.last.next = null;
//            return;
//        }
//        prevNode.next = null;
//        this.last.next = prevNode;
//    }
//
//    public T getFirst() {
//        if (isEmpty())
//            return null;
//        return (T) this.first.next.val;
//    }
//
//    public T getLast() {
//        if (isEmpty())
//            return null;
//        return (T) this.last.next.val;
//    }
//
//    public int size() {
//        return this.size;
//    }
//
//    public boolean isEmpty() {
//        return this.size == 0;
//    }
//
//    public void print() {
//        Node curr = this.first.next;
//        while (curr != null) {
//            System.out.print(curr.val + " ");
//            curr = curr.next;
//        }
//        if (!isEmpty())
//            System.out.println("\nFirst Node Val is: " + getFirst() + " | Last Node Val is: " + getLast());
//        else
//            System.out.println("No elements in the list");
//    }
//}

