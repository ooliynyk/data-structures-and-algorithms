package hash;

import common.DataItem;

public class HashTable {
    private DataItem[] hashArray;
    private int capacity;
    private int size;

    private static final DataItem NULL_DATA_ITEM = new DataItem(-1);

    public HashTable(int capacity) {
        this.capacity = capacity;
        size = 0;
        hashArray = new DataItem[this.capacity];
    }

    public DataItem find(int key) {
        int hash = hashFunc(key);
        while (hashArray[hash] != null) {
            if (hashArray[hash].getValue() == key) {
                return hashArray[hash];
            }
            ++hash;
            hash %= hashArray.length;
        }
        return null;
    }

    public void insert(DataItem item) {
        int hash = hashFunc(item.getValue());
        if (++size == capacity) {
            resize();
        }
        while (hashArray[hash] != null && !hashArray[hash].equals(NULL_DATA_ITEM)) {
            ++hash;
            hash %= hashArray.length;
        }
        hashArray[hash] = item;
    }

    public void delete(int key) {
        int hash = hashFunc(key);
        while (hashArray[hash] != null) {
            if (hashArray[hash].getValue() == key) {
                hashArray[hash] = NULL_DATA_ITEM;
                return;
            }
            ++hash;
            hash %= hashArray.length;
        }
    }

    private int hashFunc(int key) {
        return key % hashArray.length;
    }

    private void resize() {
        int newSize = getPrime(capacity * 2);
        DataItem[] newHashArray = new DataItem[newSize];
        for (int i = 0; i < capacity; i++) {
            DataItem currentItem = hashArray[i];
            if (currentItem != null && !currentItem.equals(NULL_DATA_ITEM)) {
                int hash = hashFunc(currentItem.getValue());
                newHashArray[hash] = currentItem;
            }
        }
        hashArray = newHashArray;
        capacity = newSize;
    }

    private static int getPrime(int n) {
        for (int i = n + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; (i * i) <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
