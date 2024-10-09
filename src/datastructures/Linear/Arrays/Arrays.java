package datastructures.Linear.Arrays;

public class Arrays {
    private int[] items;
    private int count;

    public Arrays(int capacity) {
        items = new int[capacity];

    }
    public void insert(int item) {
        if (count == items.length) {
            int [] newItem = new int[count * 2];
            for (int i = 0; i < items.length; i++)
                newItem[i] = items[i];
            items = newItem;
        }
        items[count++] = item;
    }
    public void removeAt(int index) {
        for (int i = index; i < count; i++){
            items[i] = items[i + 1];
        }
        count--;
    }
    public int indexOf(int item) {
        for(int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }
    public int max() {
        if (count == 0)
            throw new IllegalStateException("Array is empty");
        int max = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > max)
                max = items[i];
        }
        return max;
    }
    public void print() {
        System.out.println(java.util.Arrays.toString(items));
    }
    public String intersect( Arrays other) {
        Arrays intersection = new Arrays(1);
        for(int item : other.items)
            if (indexOf(item) != -1)
                intersection.insert(item);
        return java.util.Arrays.toString(intersection.items);
    }
public void reverse() {
    for (int i = 0, j = count - 1; i < j; i++, j--) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}

    public void insertAt(int index, int item) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException("Invalid index");
        insert(item);
        for(int i = count - 1; i > index; i--) {
            int k = items[i - 1];
            items[i - 1] = items[i];
            items[i] = k;
        }
    }

}
