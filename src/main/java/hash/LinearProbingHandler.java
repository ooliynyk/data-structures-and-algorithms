package hash;

public class LinearProbingHandler implements ProbingHandler {

    @Override
    public int nextHash(int hash) {
        return hash + 1;
    }

}
