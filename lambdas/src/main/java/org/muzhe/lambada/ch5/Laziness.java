package org.muzhe.lambada.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream的延迟执行，
 * Stream会有中间操作，和最终操作，只有在执行最终操作的时候才会将中间操作一起执行
 *
 * @author muzhe-wang on  18-10-11 上午9:49.
 */
public class Laziness {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> result = numbers.stream()
                //过滤掉偶数
                .filter(n -> {
                    System.out.println("filter " + n);
                    return n % 2 == 0;
                })
                //map，对这个所有的参数进行处理，这个方法是一个Function，主要是对对应的参数进行处理
                .map(n -> {
                    System.out.println("mapping " + n);
                    return n * n;
                })
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
