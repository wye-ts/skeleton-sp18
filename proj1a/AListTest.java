public class AListTest {
    public static void main (String[] args) {
        AList<Integer> list = new AList<Integer>();
        list.addLast(5);
        System.out.println(list.getLast());
        System.out.println(list.size());
        list.addLast(10);
        System.out.println(list.getLast());
        System.out.println(list.size());
        list.addLast(25);
        System.out.println(list.getLast());
        System.out.println(list.size());
        list.removeLast();
        System.out.println(list.getLast());
        System.out.println(list.size());
        list.removeLast();
        System.out.println(list.getLast());
        System.out.println(list.size());
        list.removeLast();
        System.out.println(list.getLast());
        System.out.println(list.size());
    }
}