package recursion;

/**
 * Triangle value calculator
 */
public class TriangleCalculator {

    /**
     * Calculate a N triangle value
     * @param position
     * @return triangle value
     */
    public int calculate(int position) {
        System.out.printf("Calc: %d\n", position);
        if (position == 1) {
            return 1;
        } else {
            return position + calculate(position-1);
        }
    }

    public int calculateIter(int position) {
        int triangle = 0;
        while (position > 0) {
            triangle += position;
            --position;
        }
        return triangle;
    }

}
