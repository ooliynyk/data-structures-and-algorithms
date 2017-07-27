package recursion;

public class Power {

    public int power(int x, int y) {
        if (y == 1)
            return x;
        else {
            if (y % 2 == 0) {
                return power(x * x, y / 2);
            } else {
                return power(x * x, y / 2) * x;
            }
        }
    }

}
