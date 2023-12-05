package task;

import java.util.*;

public class ArrayTasks {

    public static void main(String[] args) {
        nonDoubleSym();

    }

    /**
     * Print first non doubling value in array[]
     * @return
     */
    private static void nonDoubleSym() {
        Integer[] sourceArray = { 3, 4, 3, 3, 4, 5, 6, 6 };

        // 1st decision
        List<Integer> targetList = Arrays.asList(sourceArray);
        HashMap<Integer, Integer> intMap = new HashMap<>();
        targetList.stream().forEach(i -> {
            intMap.putIfAbsent(i, 0);
            intMap.put(i, intMap.get(i) + 1);
        });

        for(Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (1 == value) System.out.println(key);
        }

        // 2nd decision
        HashMap<Integer, Integer> intMap2 = new HashMap<>();
        for (int i = 0; i < sourceArray.length; i++) {
            intMap2.merge(sourceArray[i], 1, (a, b) -> a + b);
        }

        intMap2.forEach((key, value) -> {
            if (1 == value) System.out.println(key);
        });

        // 3rd decision
        HashMap<Integer, Integer> intMap3 = new HashMap<>();
        Arrays.asList(sourceArray).stream().forEach(key -> {
            intMap3.merge(key, 1, (a, b) -> a + b);
        });

//        Optional<Map.Entry<Integer, Integer>> res = intMap3.entrySet().stream()
//                .filter(entry -> 1 == entry.getValue()).findAny();

        intMap3.forEach((key, value) -> {
            if (1 == value) System.out.println(key);
        });

    }

}
