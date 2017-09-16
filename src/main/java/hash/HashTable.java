package hash;

import common.DataItem;

public class HashTable {
    private DataItem[] hashArray;
    private int size;

    private static final DataItem NULL_DATA_ITEM = new DataItem(-1);

    public HashTable(int capacity) {
        size = capacity;
        hashArray = new DataItem[size];
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
        while (hashArray[hash] != null && hashArray[hash].equals(NULL_DATA_ITEM)) {
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
}
