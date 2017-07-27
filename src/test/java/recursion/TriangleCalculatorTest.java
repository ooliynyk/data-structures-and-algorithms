package recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by oleksandr on 19.07.17.
 */
public class TriangleCalculatorTest {
    @Test
    public void calculateIter() throws Exception {
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        assertEquals(1, triangleCalculator.calculateIter(1));
        assertEquals(10, triangleCalculator.calculateIter(4));
    }

    @Test
    public void calculate() throws Exception {
        TriangleCalculator triangleCalc = new TriangleCalculator();
        assertEquals(10, triangleCalc.calculate(4));
/*
        assertEquals(3, triangleCalc.calculate(2));
        assertEquals(10, triangleCalc.calculate(4));
*/
    }


}