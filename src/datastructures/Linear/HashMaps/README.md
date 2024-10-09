# HashMap

## Overview
This package contains a custom implementation of the HashMap data structure using two techniques:
- **Chaining**: Handling collisions by maintaining a list of entries at each index.
- **Linear Probing**: Resolving collisions by finding the next available index in the array.

In addition to the HashMap implementations, the package also includes exercises involving various HashMap-related problems.

## Implementations

### 1. HashMap using Chaining
This implementation stores key-value pairs in a list at each index to handle collisions. Each entry in the list contains a key and its associated value.

### 2. HashMap using Linear Probing
Linear probing is used to handle collisions by finding the next open slot in the hash table. It rehashes the key when a collision occurs, ensuring each key is stored in a unique slot.

## Exercises

### 1. **Most Frequent Element**
This method finds the most frequent element in an array using a HashMap to count the occurrences of each element.

### 2. **Two-Sum Problem**
Given an array of integers, this method finds two numbers that add up to a target sum using a HashMap for quick lookups.

### 3. **Count Pairs with Difference**
This method counts the number of pairs in an array whose absolute difference is equal to a given value. The algorithm uses a HashMap to track visited elements and their differences.

### 4. **Character Finder**
This method finds the first non-repeated character in a string using a HashMap to store character frequencies. It also finds the first repeated character using a similar approach.

## Author
This package was developed to showcase custom implementations of HashMap and problem-solving techniques using this data structure.
