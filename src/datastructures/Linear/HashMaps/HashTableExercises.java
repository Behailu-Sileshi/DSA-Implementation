package datastructures.Linear.HashMaps;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {

    // O(n)
    public int[] twoSum(int[] numbers, int target) {
        // If a + b = target, then b = target - a.
        // In this problem we use hashtable, we store numbers and their indexes.
        // There is no need to store all the numbers in the hash table
        // first. If we find two numbers that add up to the target,
        // we simply return their indexes.

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }

        return null;
    }

    // O(n)
    public int mostFrequent(int[] numbers) {
        // To find the most frequent item in an array, we have to count the
        // number of times each item has been repeated. We can use a hash
        // table to store the items and their frequencies.
        Map<Integer, Integer> map = new HashMap<>();
        for (var number : numbers) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        // Once we've populated our hash table, we need to iterate over all
        // key/value pairs and find the one with the highest frequency.
        int max = -1;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }


        return result;
    }

    // O(n)
    public int countPairsWithDiff(int[] numbers, int difference) {
        // For a given number (a) and difference (diff), number (b) can be:

        // b = a + diff
        // b = a - diff
        //
        // We can optimize this by using a set. Sets are like hash tables
        // but they only store keys. We can look up a number in constant time.
        // No need to iterate the array to find it.

        // So, we start by adding all the numbers to a set for quick look up.
        Set<Integer> set = new HashSet<>();
        for (var number : numbers)
            set.add(number);

        // Now, we iterate over the array of numbers one more time,
        // and for each number check to see if we have (a + diff) or
        // (a - diff) in our set.
        //
        // Once we're done, we should remove this number from our set
        // so we don't double count it.
        var count = 0;
        for (var number : numbers) {
            if (set.contains(number + difference))
                count++;
            if (set.contains(number - difference))
                count++;
            set.remove(number);
        }

        return count;
    }

}