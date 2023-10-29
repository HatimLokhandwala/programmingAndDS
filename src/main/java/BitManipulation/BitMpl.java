package BitManipulation;

import com.sun.tools.javac.util.Pair;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Sample {
    public String getSecretString() {
        return "hello";
    }

    Character[] getSecretBinary() {
        return new Character[]{'a','b', 'c'};
    }
}
public class BitMpl {
    static Pair<Integer, Integer> determineDistinctNonMatchingElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty or null");
        }

        int xorOfElements = determineXor(IntStream.of(arr).boxed().collect(Collectors.toList()));
        int indexOfFirstSetBit = getSetBit(xorOfElements);
        List<Integer> groupOne = getElementsWithBitSetAtGivenIndex(arr, indexOfFirstSetBit);
        List<Integer> groupTwo = getElementsWithBitUnSetAtGivenIndex(arr, indexOfFirstSetBit);
        int elementOne = determineXor(groupOne);
        int elementTwo = determineXor(groupTwo);
        return Pair.of(elementOne, elementTwo);
    }

    String getStrValue() {
        Sample s = new Sample();
        return Optional.of(s.getSecretString())
                .orElse(s.getSecretBinary().toString());
    }
    static int determineXor(List<Integer> group) {
        String s = null;

        int xor = 0;
        for (int elem: group) {
            xor = xor ^ elem;
        }
        return xor;
    }

    static int determineUniqueElement(List<Integer> inputList) {
        int xor = 0;
        for (int elem: inputList) {
            xor = xor ^ elem;
        }
        return xor;
    }
    private static List<Integer> getElementsWithBitSetAtGivenIndex(int[] arr, int index) {
        if (index < 0) {
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();
        for (int elem: arr) {
            if (((elem >> index) & 1) == 1) {
                output.add(elem);
            }
        }
        return output;
    }

    private static List<Integer> getElementsWithBitUnSetAtGivenIndex(int[] arr, int index) {
        if (index < 0) {
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();
        for (int elem: arr) {
            if (((elem >> index) & 1) == 0) {
                output.add(elem);
            }
        }
        return output;
    }

    private static int getSetBit(int value) {
        if (value == 0) {
            return -1;
        }
        int index = 0;
        while (value != 0) {
            if ((value & 1) == 1) {
                break;
            }
            index++;
            value = value >> 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 5, 4};
        Pair pair = determineDistinctNonMatchingElements(arr);
        System.out.println(pair);
        int[] arr1 = {1, 2, 1, 3, 3, 7, 5, 9, 4, 2, 5, 4};
        Pair pair1 = determineDistinctNonMatchingElements(arr1);
        System.out.println(pair1);
    }
}
