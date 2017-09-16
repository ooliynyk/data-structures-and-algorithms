package hash;

import common.DataItem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChainableHashTable {
    private List<DataItem>[] hashArray;
    private int capacity;
    private int size;

    private static final DataItem NULL_DATA_ITEM = new DataItem(-1);

    public ChainableHashTable(int capacity) {
        this.capacity = capacity;
        size = 0;
        hashArray = (List<DataItem>[]) new List[this.capacity];
    }

    public DataItem find(int key) {
        int hash = hashFunc(key);

        for (DataItem item : hashArray[hash]) {
            if (item.getValue() == key) {
                return item;
            }
        }

        return null;
    }

    public void insert(DataItem item) {
        int hash = hashFunc(item.getValue());

        if (++size >= capacity * 2/3) {
            resize();
        }
        if (hashArray[hash] == null) {
            hashArray[hash] = new LinkedList<>();
        }

        hashArray[hash].add(item);
    }

    public void delete(int key) {
        int hash = hashFunc(key);
        Iterator<DataItem> it =  hashArray[hash].iterator();
        while ( it.hasNext()) {
            DataItem item = it.next();
            if (item.getValue() == key) {
                it.remove();
                return;
            }
        }
    }

    private int hashFunc(int key) {
        return key % hashArray.length;
    }

    private void resize() {
        int newSize = getPrime(capacity * 2);
        List<DataItem>[] newHashArray = new List[newSize];
        for (int i = 0; i < capacity; i++) {
            for (DataItem currentItem : hashArray[i]) {
                if (currentItem != null && !currentItem.equals(NULL_DATA_ITEM)) {
                    int hash = hashFunc(currentItem.getValue());
                    newHashArray[hash].add(currentItem);
                }
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
