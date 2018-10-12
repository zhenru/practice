package org.muzhe.lambada.ch4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author muzhe-wang on  18-10-10 下午5:45.
 */
public class StreamVsCollect {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);

    }
}
