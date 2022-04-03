/* Invariants:
addLast: The next item we want to add, will go into position size
getLast: The item we want to return is in position size - 1
 */

import java.util.*;

public class AList<T> {
    private T[] items;
    private int size;
    private int capacity;

    public AList() {
        capacity = 100;
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public void addLast(T item) {
        items[size] = item;
        size = size + 1;
        if (size == capacity) {
            increaseSize();
        }
    }

    public T getLast() {
        if (size == 0)
            return null;
        return items[size - 1];
    }

    public T get(int i) {
        return items[i];
    }

    public T removeLast() {
        if (size == 0)
            return null;
        T returnItem = getLast();
        // To prevent loitering
        items[size - 1] = null;
        size = size - 1;
        return returnItem;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void increaseSize() {
        // capacity + REFACTOR is usually bad
        capacity = capacity * 2;
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }
}

//public class AList {
//    private int[] items;
//    private int size;
//    private int capacity;
//
//    public AList() {
//        capacity = 100;
//        items = new int[capacity];
//        size = 0;
//    }
//
//    public void addLast(int x) {
//        items[size] = x;
//        size = size + 1;
//        if (size == capacity) {
//            increaseSize();
//        }
//    }
//
//    public int getLast() {
//        if (size == 0)
//            return Integer.MIN_VALUE;
//        return items[size - 1];
//    }
//
//    public int get(int i) {
//        return items[i];
//    }
//
//    public int removeLast() {
//        if (size == 0)
//            return Integer.MIN_VALUE;
//        int returnItem = getLast();
//        size = size - 1;
//        return returnItem;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    private void increaseSize() {
//        // capacity + REFACTOR is usually bad
//        capacity = capacity * 2;
//        items = Arrays.copyOf(items, capacity);
//    }
//}