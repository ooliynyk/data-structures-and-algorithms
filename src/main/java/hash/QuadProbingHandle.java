package hash;

public class QuadProbingHandle implements ProbingHandle {
    private int step = 0;
    private int hash;

    public QuadProbingHandle(int hash) {
        this.hash = hash;
    }

    @Override
    public int nextProbe() {
        hash += nextStep();
        return hash;
    }

    private int nextStep() {
        return (int) Math.pow(++step, 2.0);
    }

}
