package hash;

public class QuadProbingHandler implements ProbingHandler {
    private int step = 0;

    @Override
    public int nextHash(int hash) {
        hash += nextProbe();
        return hash;
    }

    private int nextProbe() {
        return (int) Math.pow(++step, 2.0);
    }

}
