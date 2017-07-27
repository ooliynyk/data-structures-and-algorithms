package list;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.*;


/**
 * Created by oleksandr on 11.07.17.
 */
public class ListTest {
    private List list = new List();

    @Test
    public void insert() throws Exception {
        assertTrue(list.isEmpty());
        list.insert(1, 3);
        list.insert(3, 4);
        list.insert(5, 5);
        assertFalse(list.isEmpty());
        list.display();
        assertNotNull(list.delete(5));
        assertEquals(4.0, list.delete(3).getDValue());
        list.display();
    }

    @Test
    public void display() throws Exception {
        list.display();
        List.Link[] links = new List.Link[10];
        for (int i = 0; i < 10; i++) {
            links[i] = new List.Link((int) (Math.random() * 99), Math.random());
        }
        System.out.println(Arrays.toString(links));
        List list = new List(links);
        for (int i = 0; i < 10 && !list.isEmpty(); i++) {
            links[i] = list.remove();
        }
        System.out.println(Arrays.toString(links));
    }

    @Test
    public void iterator() {
        List list = new List();
        list.insert(1, 3);
        list.insert(3, 4);
        list.insert(5, 5);
        List.Iterator iterator = list.iterator();
        while (!iterator.atEnd()) {
            List.Link current = iterator.current();
            System.out.println(current);
        }
    }

}