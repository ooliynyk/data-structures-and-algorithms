package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Combinations {

    public List<String> solve(char[] symbols, int size) {
        if (size <= 0 || symbols.length == 0 || size > symbols.length) {
            return Collections.emptyList();
        }

        if (size == 1 && symbols.length == 1) {
            List<String> asList = Arrays.asList(new String(symbols));
            return new ArrayList<>(asList);
        }


        char[] subSymbols = Arrays.copyOfRange(symbols, 1, symbols.length);
        List<String> leftResult = solve(subSymbols, size - 2);
        List<String> rightResult = solve(subSymbols, size - 1);

        char first = symbols[0];
        rightResult.addAll(addAsFirst(first, leftResult));

        return rightResult;
    }

    private List<String> addAsFirst(char symbol, List<String> combination) {
        return combination.stream()
                .map(str -> String.format("%s%s", symbol, str))
                .collect(Collectors.toList());
    }

}
