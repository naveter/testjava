package task;

import java.util.*;

public class ArrayTasks {

    public static void main(String[] args) {
        nonDoubleSym();

    }

    public static boolean testMethod(String str1, String str2) {

        List<String> arr1 = new ArrayList<>(Arrays.asList(str1));
        List<String> arr2 = new ArrayList<>(Arrays.asList(str2));

        HashMap<String, Integer> str1Map = new HashMap<>();
        arr1.stream().forEach(i -> {
            str1Map.putIfAbsent(i, 0);
            str1Map.put(i, str1Map.get(i) + 1);
        });

        HashMap<String, Integer> str2Map = new HashMap<>();
        arr2.stream().forEach(i -> {
            str2Map.putIfAbsent(i, 0);
            str2Map.put(i, str2Map.get(i) + 1);
        });

        // Get greater by length HashMap
        for(Map.Entry<String, Integer> entry : str1Map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if ( !str2Map.containsKey(key) || !str2Map.get(key).equals(value) ) return false;
        }

        return true;
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
