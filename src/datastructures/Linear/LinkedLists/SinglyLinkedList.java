package datastructures.Linear.LinkedLists;

public class SinglyLinkedList {
    private class Node {
        private int item;
        private Node next;

        public Node(int item) {
            this.item = item;
            next = null;
        }
    }
    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        Node newItem = new Node(item);
        if (isEmpty())
            first = last = newItem;
       else {
           last.next = newItem;
           last = newItem;
        }
        size++;
    }
    public void addFirst(int item) {
        Node newItem = new Node(item);
        if (isEmpty())
            first = last = newItem;
        else {
            newItem.next = first;
            first = newItem;
        }
        size++;
    }
    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while(current != null) {
            if(current.item == item)
                return index;
            else {
                current = current.next;
                index++;
            }
        }
        return -1;
    }
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }
    public void removeFirst() {
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty");
        else if(first == last)
            first = last = null;
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty");
        else if(first == last)
            first = last = null;
        else {
            Node current = first;
            while(current.next != last) {
                current = current.next;
            }
            last = current;
            last.next = null;
        }
        size--;
    }
    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }
    public int [] toArray() {
        int [] list = new int [size];
        int count = 0;
        Node current = first;
        while(current != null) {
            list[count++] = current.item;
            current = current.next;
        }
        return list;
    }
    public void reverse() {
        if(isEmpty())
            throw new IllegalArgumentException("The list is empty");

        Node current = first;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        last = first;
        first = prev;

    }

//    Exercises
//    1. KthNodeFromTheEnd()
    public int KthNodeFromTheEnd(int k) {
        if (k < 0 || k > size)
            throw new IllegalArgumentException("Invalid index!");
        Node ptr1 = first;
        Node ptr2 = first;
        for (int i = 0; i < k - 1; i++)
            ptr1 = ptr1.next;
        while(ptr1.next != null) {
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }
        return ptr2.item;
    }
//    2. Find the middle of a linked list in one pass.
    public void printMiddle() {
        if (first == null) {
            throw new IllegalStateException("The list is empty.");
        }
        var slow = first;
        var fast = first;
        while(fast != last && fast.next != last) { // handling for both odd and even size of linkedlist.
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null)
            System.out.println(slow.item);
        else
            System.out.println(slow.item + ", " +  slow.next.item);

    }
//    Floyd’s Cycle-finding Algorithm.
    public boolean hasLoop() {
        var slow = first;
        var fast = first;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
