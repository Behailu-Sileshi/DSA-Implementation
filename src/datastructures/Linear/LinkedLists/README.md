# Linked List Implementations

This repository contains custom implementations of Singly Linked List, Doubly Linked List, and Circular Linked List in Java. These implementations provide a deep understanding of how different types of linked lists function and help reinforce knowledge about linked data structures.
Linked List Types
1. Singly Linked List

A singly linked list consists of nodes where each node stores a data element and a reference (link) to the next node in the sequence. It allows efficient insertions and deletions from the beginning or end of the list.
Key Methods:

* addFirst(int item): Adds an item at the beginning of the list.
* addLast(int item): Adds an item at the end of the list.
* indexOf(int item): Returns the index of the item if it exists.
* contains(int item): Checks if the list contains the item.
* removeFirst(): Removes the first node.
* removeLast(): Removes the last node.
* toArray(): Converts the linked list to an array.
* reverse(): Reverses the list.
* KthNodeFromTheEnd(int k): Finds the k-th node from the end of the list.
* printMiddle(): Prints the middle node(s) in one pass.
* hasLoop(): Detects if the linked list has a cycle (loop) using Floyd's Cycle-finding Algorithm.

2. Doubly Linked List

A doubly linked list has nodes with two references: one to the next node and one to the previous node. This allows traversal in both directions.
Key Methods:

* addFirst(int item): Adds an item at the beginning.
* addLast(int item): Adds an item at the end.
* indexOf(int item): Finds the index of a given item.
* contains(int item): Checks if the list contains the item.
* removeFirst(): Removes the first node.
* removeLast(): Removes the last node.
* toArray(): Converts the list to an array.

3. Circular Linked List

In a circular linked list, the last node points back to the first node, forming a circular structure. This implementation supports both singly and doubly linked styles with circular behavior.
Key Methods:

* addFirst(int item): Adds an item at the beginning.
* addLast(int item): Adds an item at the end.
* indexOf(int item): Finds the index of a given item.
* contains(int item): Checks if the list contains the item.
* removeFirst(): Removes the first node.
* removeLast(): Removes the last node.
* toArray(): Converts the circular linked list to an array.

## Usage

Each implementation has a simple set of methods to perform common operations like insertion, deletion, and searching.
These implementations are designed for learning purposes and may be enhanced for specific use cases.

## Installation

Clone the repository:

    git clone https://github.com/Behailu-Sileshi/linked-list-implementations.git

Import the classes into your Java project and test the functionality by creating instances of SinglyLinkedList, DoublyLinkedList, or CircularLinkedList.
License

This project is open-source and available under the MIT License.
Author

Developed by behailu as part of learning data structures in Java.