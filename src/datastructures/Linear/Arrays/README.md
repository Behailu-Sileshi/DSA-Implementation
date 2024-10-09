# Custom Array Class

This repository contains a custom implementation of a dynamic array in Java. It mimics the behavior of arrays with features like dynamic resizing, element insertion, deletion, searching, and more. This project was developed for learning purposes to understand how arrays work under the hood and to practice implementing core data structures from scratch.
Features

- **Dynamic Resizing**: Automatically resizes the array when it reaches its capacity.
- **Insert**: Adds new elements to the array.
- **Remove**: Removes an element at a specified index and shifts the remaining elements.
- **Index Search**: Finds the index of a given element.
- **Max Element**: Returns the maximum element in the array.
- **Reverse**: Reverses the array.
- **Intersection**: Returns the common elements between two arrays.
- **Insert At**: Inserts an element at a specified index and shifts the existing elements.

## Methods Overview

1. **insert(int item)**:

    Adds an element to the array. Resizes the array if it is full.
2. **removeAt(int index)**:

    Removes the element at the specified index and shifts the remaining elements to the left.
3. **indexOf(int item)**:

    Returns the index of the specified item or -1 if the item is not found.
4. **max()**:

    Returns the maximum element in the array.
5. **reverse()**:

    Reverses the order of elements in the array.
6. **intersect(Array other)**:

    Finds the common elements between the current array and another array.
7. **insertAt(int index, int item)**:

    Inserts an element at a specified index and shifts the remaining elements to the right.

## Usage

Clone the repository:

    git clone https://github.com/your-username/your-repo-name.git

Compile and run the program in your Java environment.


    javac Array.java
    java Array
