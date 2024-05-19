package streamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Creation {
    public static void createStreamOfNumbers() {
        Stream<Integer> stream = Stream.of(1, 2);
        stream.forEach(System.out::println);
    }

    public static void createStreamOfNumbersFromArray() {
        int[] arr = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(arr);
        intStream.forEach(System.out::println);
    }

    public static void mapStream() {
        List<String> names = new ArrayList<>();
        names.add("Hatim");
        names.add("MohaMMEd");
        names.add("LOKhandwala");
        names.stream().map(String::toLowerCase)
                .forEach(System.out::println);
    }

    public static void mapStream1() {
        List<String> names = new ArrayList<>();
        names.add("Hatim");
        names.add("MohaMMEd");
        names.add("LOKhandwala");
        names.stream().map(name -> name.toLowerCase())
                .forEach(System.out::println);
    }


    public static List<Integer> test1() {
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(10); list2.add(20);
        listOfLists.add(list1); listOfLists.add(list2);
        return listOfLists.stream()
                .flatMap(a -> {
                    System.out.println(a);
                    return a.stream();
                        }
                        )
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        createStreamOfNumbers();
        createStreamOfNumbersFromArray();
        mapStream();
        mapStream1();
        List<Integer> output = test1();
        System.out.println(output);
    }
}
