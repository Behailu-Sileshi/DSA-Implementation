package datastructures.Linear.LinkedLists;

public class DoublyLinkedList {
    private class Node {
        int item;
        Node prev;
        Node next;
        public Node(int item) {
            this.item = item;
            prev = null;
            next = null;
        }
    }
    private Node first;
    private Node last;
    private int size;
    public void addLast(int item) {
        Node newItem = new Node(item);
        if(isEmpty()) {
            first = last = newItem;
        }
        else {
            last.next = newItem;
            newItem.prev = last;
            last = newItem;
        }
        size++;
    }
    public void addFirst(int item){
        Node newItem = new Node(item);
        if(isEmpty()) {
            first = last = newItem;
        }
        else {
            newItem.next = first;
            first.prev = newItem;
            first = newItem;
        }
        size++;
    }
    public int indexOf(int item) {
        Node current = first;
        int count = 0;
        while(current != null) {
            if (current.item == item)
                return count;
            else
                current = current.next;
                count++;
        }
        return -1;
    }
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }
    public void removeFirst(){
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty.");
        else if (first == last)
            first = last = null;
        else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }
    public void removeLast(){
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty.");
        else if (first == last)
            first = last = null;
        else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }
    public int size() {
        return size;
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

    private boolean isEmpty() {
        return first == null;
    }

}
