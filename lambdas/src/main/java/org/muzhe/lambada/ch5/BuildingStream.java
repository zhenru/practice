package org.muzhe.lambada.ch5;


import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 这一章是各种Stream的创建的方式
 * @author muzhe-wang on  18-10-10 下午6:01.
 */
public class BuildingStream {

    public static void main(String[] args) {


        handleStreamOf();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleStreamEmpty();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleArrayStream();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleStreamIterate();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleStreamIterate2();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleStreamIterateFibonnaci();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleStreamIterateFibonnaci2();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleStreamGenerate();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleStreamOneList();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleInStreamGenerate();

        System.out.println("　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　");

        handleInStreamSupplierFibbinator();
    }

    /**
     * 使用IntSupllier来处理feibonaqi数列的实现
     */
    private static void handleInStreamSupplierFibbinator() {

        IntStream.generate(new IntSupplier() {
            private int previous = 0;
            private int next = 1;

            @Override
            public int getAsInt() {
                int nextValue = this.previous + this.next;
                this.previous = this.next;
                this.next = nextValue;
                return this.previous;
            }

        });
    }

    /**
     * 处理IntStream随机生成一个数值
     */
    private static void handleInStreamGenerate() {

        IntStream.generate(() -> (int) (Math.random() * 100)).limit(10).forEach(System.out::println);
    }

    private static void handleStreamOneList() {

        Stream.generate(() -> 1).limit(10).forEach(System.out::println);
    }

    /**
     * 处理一下，生成一个随即的队列
     */
    private static void handleStreamGenerate() {

        Stream.generate(Math::random).limit(20)
                .forEach(System.out::println);

    }

    /**
     * 处理feibonaqi数列的第二种方法
     */
    private static void handleStreamIterateFibonnaci2() {

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

    }

    /**
     * 使用　Stream来处理feibonaqishulie.
     */
    private static void handleStreamIterateFibonnaci() {

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10).forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

    }

    private static void handleStreamIterate2() {


        //todo
    }

    /**
     * Stream.iterate会将依次遍历当前的对象
     * iterate表示对当前对象进行遍历，有两个参数，第一个参数是seed,后面的参数是　依次进行处理
     */
    private static void handleStreamIterate() {

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(num -> System.out.print(" " + num));

    }

    /**
     * 处理ArrayStream对象
     * Arrays.stream([])可以将一个数组对象转变为一个Stream对象，这个效果好像是和Stream.of()类似。
     */
    private static void handleArrayStream() {

        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());

    }

    /**
     * 处理一个空的Stream
     */
    private static void handleStreamEmpty() {

        Stream.empty().forEach(System.out::println);
    }

    /**
     * 通过Stream.of这个方法可以将一个[]转变为一个Stream对象
     */
    private static void handleStreamOf() {
        Stream<String> stringStream = Stream.of("Java8", "Lambdas", "In", "Action");

        stringStream.map(String::toUpperCase).forEach(System.out::println);
    }


}
