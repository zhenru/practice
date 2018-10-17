package org.muzhe.lambada.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author muzhe-wang on  18-10-15 上午9:53.
 */
public class HandleFlatMap {


    public static void main(String[] args) {
        handleStreamMap();

        System.out.println(" ========================================================================================= ");

        handleFlatMap();

        System.out.println(" ========================================================================================= ");

        handleMapAndFlatMap();
        System.out.println(" ========================================================================================= ");

        handleFlatMap3();
    }

    /**
     * 处理handleFlatＭap的实现
     */
    private static void handleFlatMap3() {

        List<Integer>  numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> result = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        result.forEach(System.out::println);

    }

    /**
     * 处理Map和flatMap这两种实现
     */
    private static void handleMapAndFlatMap() {

        List<String> words = new ArrayList<>();
        words.add("your");
        words.add("name");

        List<String[]> collect = words.stream().map(word -> word.split("")).distinct().collect(Collectors.toList());


    }

    /**
     * 处理Stream中的flatMap的实现
     */
    private static void handleFlatMap() {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> figures = Stream.of(a,b).flatMap(u ->u.stream()).collect(Collectors.toList());
        figures.forEach(System.out::println);

    }

    /**
     * 这里是一个处理flatMap和map的实现
     */
    private static void handleStreamMap() {

        List<String> collected = Stream.of("a", "b").collect(Collectors.toList());

        collected.stream().map(s -> {
            Integer i;
            switch (s) {
                case "a":
                    i = 1;
                    break;

                case "b":
                    i = 2;
                    break;
                default:
                    i = 3;
                    break;
            }

            System.out.println(i);
            return i;
        }).collect(Collectors.toList());

    }
}
