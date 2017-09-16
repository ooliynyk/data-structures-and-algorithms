package hash;

@FunctionalInterface
public interface ProbingHandlerFactory {
    ProbingHandler create();
}
