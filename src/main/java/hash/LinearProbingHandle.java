package hash;

public class LinearProbingHandle implements ProbingHandle {

    private int hash;

    public LinearProbingHandle(int hash) {
        this.hash = hash;
    }

    @Override
    public int nextProbe() {
        return hash + 1;
    }

}
