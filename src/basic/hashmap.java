package basic;

import java.util.*;

public class hashmap {
    public void haspmapbasic(){
        HashMap<Integer, String> map = new HashMap<>();

        // put() - Add key-value pairs
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Date");

        System.out.println("Original HashMap: " + map);

        // get() - Retrieve a value by key
        System.out.println("Value at key 2: " + map.get(2));

        // containsKey() - Check if a key exists
        System.out.println("Contains key 3? " + map.containsKey(3));

        // containsValue() - Check if a value exists
        System.out.println("Contains value 'Banana'? " + map.containsValue("Banana"));

        // remove() - Remove by key
        map.remove(4);
        System.out.println("After removing key 4: " + map);

        // replace() - Replace value for a key
        map.replace(1, "Apricot");
        System.out.println("After replacing key 1: " + map);

        // putIfAbsent() - Add value only if key is absent
        map.putIfAbsent(5, "Elderberry");
        System.out.println("After putIfAbsent for key 5: " + map);

        // size() - Get number of entries
        System.out.println("Size of map: " + map.size());

        // isEmpty() - Check if empty
        System.out.println("Is map empty? " + map.isEmpty());

        // keySet() - Get all keys
        System.out.println("Keys: " + map.keySet());

        // values() - Get all values
        System.out.println("Values: " + map.values());

        // entrySet() - Get key-value pairs
        System.out.println("Entries: " + map.entrySet());

        // Iterating using for-each
        System.out.println("Iterating using entrySet:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // clear() - Remove all entries
        map.clear();
        System.out.println("After clearing: " + map);
    }
    public void advHashmap(){
        // --- HashMap Operations ---
        HashMap<String, Integer> scores = new HashMap<>();

        // put() - Insert key-value pairs
        scores.put("Alice", 85);
        scores.put("Bob", 72);
        scores.put("Charlie", 90);
        scores.put("David", 60);
        scores.put("Eve", 95);

        System.out.println("Original HashMap: " + scores);

        // getOrDefault()
        System.out.println("Score of Frank (default 0): " + scores.getOrDefault("Frank", 0));

        // compute() - modify value with function
        scores.compute("Alice", (key, val) -> val + 5);
        System.out.println("After compute for Alice: " + scores);

        // computeIfAbsent()
        scores.computeIfAbsent("Grace", key -> 70);
        System.out.println("After computeIfAbsent for Grace: " + scores);

        // computeIfPresent()
        scores.computeIfPresent("Bob", (key, val) -> val - 5);
        System.out.println("After computeIfPresent for Bob: " + scores);

        // merge()
        scores.merge("Charlie", 10, Integer::sum); // adds 10 to Charlie's score
        System.out.println("After merge for Charlie: " + scores);

        // clone() - returns a shallow copy
        HashMap<String, Integer> clonedScores = (HashMap<String, Integer>) scores.clone();
        System.out.println("Cloned HashMap: " + clonedScores);

        // forEach() - functional iteration
        System.out.println("Using forEach with lambda:");
        scores.forEach((key, value) -> System.out.println(key + " -> " + value));

        // Sorting by value while inserting using PriorityQueue (min-heap)
        System.out.println("\nSorted by value using PriorityQueue:");

        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(Map.Entry.comparingByValue());

        minHeap.addAll(scores.entrySet());

        while (!minHeap.isEmpty()) {
            Map.Entry<String, Integer> entry = minHeap.poll();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Sorting by value using Stream API (Java 8+)
        System.out.println("\nSorted by value using Stream API:");
        scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}
