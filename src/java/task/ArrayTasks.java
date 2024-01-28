package task;

import java.util.*;
import java.util.stream.Stream;

public class ArrayTasks {

    public static void main(String[] args) {
        System.out.println(polidrom("abcd", "dcba"));
//        nonDoubleSym();

    }

    /*
    * Polidrom or not?
    * */
    public static boolean polidrom(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        HashMap<String, Integer> str1Map = new HashMap<>();
        Stream.of(str1.split("")).forEach(i -> {
            str1Map.putIfAbsent(i, 0);
            str1Map.put(i, str1Map.get(i) + 1);
        });

        HashMap<String, Integer> str2Map = new HashMap<>();
        Stream.of(str2.split("")).forEach(i -> {
            str2Map.putIfAbsent(i, 0);
            str2Map.put(i, str2Map.get(i) + 1);
        });

//        return str1Map.equals(str2Map);
        return str1Map.entrySet().stream()
                .allMatch(e -> e.getValue().equals(str2Map.get(e.getKey()))) &&
                str2Map.entrySet().stream()
                        .allMatch(e -> e.getValue().equals(str1Map.get(e.getKey())));
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

        Optional<Map.Entry<Integer, Integer>> res = intMap3.entrySet().stream()
                .filter(entry -> 1 == entry.getValue()).findAny();

        System.out.println(res.get().getKey());
    }




}
