package array;

/**
 * Created by oleksandr on 29.06.17.
 */
public interface IArray<T> {
    boolean delete(T key);

    int search(T key);

    void insert(T key);

    int size();

    void sort();
}
