package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch: s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        List<Character> characters = new ArrayList<>(frequencyMap.keySet());

        characters.sort((charA, charB) -> {
            if (frequencyMap.get(charA) == frequencyMap.get(charB)) {
                return charB - charA;
            }
            return frequencyMap.get(charB) - frequencyMap.get(charA);
        });
        StringBuilder sb = new StringBuilder();
        for (char ch: characters) {
            int count = frequencyMap.get(ch);
            while (count > 0) {
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
