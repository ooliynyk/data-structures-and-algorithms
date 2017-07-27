package recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class TowerOfHanoiTest {
    @Test
    public void doTower() throws Exception {
        TowerOfHanoi tower = new TowerOfHanoi();
        tower.doTower(3, 'A', 'B', 'C');
    }

}