package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bag {
    public List<Integer> solve(List<Integer> goods, int capacity) {

        if (calculateTotalWeight(goods) == capacity) {
            return goods;
        }

        for (int i = 0; i < goods.size(); i++) {
            int firstWeight = goods.get(i);
            int subCapacity = capacity - firstWeight;
            if (firstWeight > capacity) {
                continue;
            } else if (firstWeight == capacity) {
                return new ArrayList<Integer>(Arrays.asList(firstWeight));
            } else {
                List<Integer> result = solve(goods.subList(1, goods.size()), subCapacity);
                if (result != null) {
                    result.add(firstWeight);
                    return result;
                }
            }

        }

        return null;
    }

    private int calculateTotalWeight(List<Integer> goods) {
        int totalWeight = 0;
        for (int weight : goods) {
            totalWeight += weight;
        }
        return totalWeight;
    }
}
