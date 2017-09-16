package hash;

@FunctionalInterface
public interface ProbingHandleFactory {
    ProbingHandle create(int hash);
}
