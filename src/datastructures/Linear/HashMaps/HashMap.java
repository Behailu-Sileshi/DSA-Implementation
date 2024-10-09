package datastructures.Linear.HashMaps;

public class HashMap {
    //    Implementation of hashmap using linear probing algorithm.
    private class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] entries;
    public HashMap() {
        entries = new Entry[10];
    }
    int count;
    public void put(int key, String value) {
        if (isFull())
            resizeEntries();
        var entry = getEntry(key);
        int index = getIndex(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        entries[index] = new Entry(key, value);
        count++;
    }

    private boolean isFull() {
        return count == entries.length;
    }

    public String get(int key) {
        var entry = getEntry(key);
        return entry != null ? entry.value : null;
    }
    public void remove(int key) {
       var index = getIndex(key);
        if (index == -1 || entries[index] == null)
            return;
        entries[index] = null;
        count--;
    }

    private Entry getEntry(int key) {
        int index = getIndex(key);
        return index != -1 ? entries[index] : null;
    }
    private int getIndex (int key) {
        int steps = 0;
        while(steps < entries.length) {
            int index = index(key, steps++);
            if (entries[index] == null || entries[index].key == key)
                return index;
        }

        return -1;
    }
    private int index(int key, int i) {
        return (hash(key)+ i) % entries.length;
    }
    private int hash(int key) {
        return key % entries.length;
    }
    private void resizeEntries() {
        Entry[] resized = new Entry[count * 2];
        System.arraycopy(entries, 0, resized, 0, entries.length);
        entries = resized;
    }
}
