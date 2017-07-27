package recursion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 19.07.17.
 */
public class AnagramCreatorTest {
    @Test
    public void make() throws Exception {
        AnagramCreator anagramCreator = new AnagramCreator("catout");
        anagramCreator.make(6);
    }

}